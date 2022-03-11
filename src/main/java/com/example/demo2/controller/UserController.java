package com.example.demo2.controller;

import com.example.demo2.entity.ShortMessage;
import com.example.demo2.entity.User;
import com.example.demo2.entity.UserAddr;
import com.example.demo2.entity.UserLoginLog;
import com.example.demo2.model.LoginModel;
import com.example.demo2.model.UserInfoUpdateModel;
import com.example.demo2.service.ShortMessageService;
import com.example.demo2.service.UserAddrService;
import com.example.demo2.service.UserLoginLogService;
import com.example.demo2.service.UserService;
import com.example.demo2.util.CodeUtil;
import com.example.demo2.util.HttpResponseMap;
import com.example.demo2.util.SendSms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger("UserController.class");
    @Autowired
    private UserService userService;
    @Autowired
    private ShortMessageService shortMessageService;
    @Autowired
    private UserLoginLogService userLoginLogService;

    /**
     * 用户登录
     * @param loginModel
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(LoginModel loginModel, HttpServletRequest request){
        logger.info("UserController.login.userName={},loginType={}", loginModel.getUserName(),loginModel.getLoginType());
        HttpResponseMap map = new HttpResponseMap();
        if (loginModel.getLoginType().equals("0")) {
            User user = userService.selectUserByUserNameAndPassword(loginModel.getUserName(),loginModel.getPassword());
            if (user != null) {
                UserLoginLog userLoginLog = new UserLoginLog();
                userLoginLog.setUserId(user.getId());
                userLoginLog.setLoginType(loginModel.getLoginType());
                userLoginLog.setLoginIp(request.getRemoteAddr());
                userLoginLog.setLoginStatus(1);
                userLoginLogService.add(userLoginLog);
                map.setCode("200");
                map.setMsg("登录成功");
                map.setData(user);
            } else {
                map.setCode("400");
                map.setMsg("用户名活或密码错误");
            }
        } else if (loginModel.getLoginType().equals("1")) {
            User user = userService.selectUserByPhone(loginModel.getPhone());
            if (user != null) {
                ShortMessage shortMes = shortMessageService.selectByPhoneAndCodeOrderByCreateTimeDesc(loginModel.getPhone(),loginModel.getCode());
                if (shortMes != null) {
                    long create = shortMes.getCreateTime().getTime();
                    long now = new Date().getTime();
                    //验证码有效时间为60秒
                    if (now - create > 60000) {
                        map.setCode("400");
                        map.setMsg("验证码已失效");
                    } else {
                        map.setCode("200");
                        map.setMsg("登录成功");
                        map.setData(user);
                    }
                } else {
                    map.setCode("400");
                    map.setMsg("验证码不正确");
                }
            } else {
                map.setCode("400");
                map.setMsg("该手机号还未注册");
            }
        } else {
            map.setCode("400");
            map.setMsg("登录类型错误");
        }
        return map;
    }

    /**
     * 用户注册接口
     * @param user
     * @return
     */
    @RequestMapping(value = "/register/{verificationCode}", method = RequestMethod.POST)
    @ResponseBody
    public Object register(User user, @PathVariable String verificationCode){
        logger.info("UserController.register.getPhone={},verificationCode={}", user.getPhone(),verificationCode);
        HttpResponseMap map = new HttpResponseMap();
        ShortMessage shortMes = shortMessageService.selectByPhoneAndCodeOrderByCreateTimeDesc(user.getPhone(),verificationCode);
        if (shortMes != null) {
            long create = shortMes.getCreateTime().getTime();
            long now = new Date().getTime();
            //验证码有效时间为60秒
            if (now - create < 60000) {
                map.setCode("400");
                map.setMsg("验证码已失效");
            } else {
                if (userService.selectUserByPhone(user.getPhone()) != null) {
                    map.setCode("400");
                    map.setMsg("该手机号已注册");
                }
                else if (userService.selectUserByUserName(user.getUserName()) != null) {
                    map.setCode("400");
                    map.setMsg("该用户名已注册");
                }
                else if (userService.selectUserByEmail(user.getUserName()) != null) {
                    map.setCode("400");
                    map.setMsg("该邮箱已注册");
                }
                else if (userService.selectUserByEnterpriseName(user.getEnterpriseName()) != null) {
                    map.setCode("400");
                    map.setMsg("该企业名已注册");
                }
                else {
                    user.setCreateTime(new Date());
                    user.setCustomerCode(CodeUtil.customerCode());
                    int c = userService.add(user);
                    if (c != 0) {
                        User u = userService.selectUserByPhone(user.getPhone());
                        map.setCode("200");
                        map.setMsg("注册成功");
                        map.setData(u);
                    }
                }
            }
        } else {
            map.setCode("400");
            map.setMsg("验证码不正确");
        }

        return map;
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/info", method = RequestMethod.POST)
    @ResponseBody
    public Object userInfo(@RequestParam("userId") String userId){
        logger.info("UserController.register.userId={}", userId);
        HttpResponseMap map = new HttpResponseMap();
        User user = userService.selectUserByUserId(userId);
        if (user !=  null) {
            map.setCode("200");
            map.setMsg("获取用户信息成功");
            map.setData(user);
        } else {
            map.setCode("400");
            map.setMsg("获取用户信息失败");
        }
        return map;
    }

    /**
     * 用户信息修改
     * type信息修改类型 0：基本信息修改，1修改邮箱地址，2修改手机号，3修改密码，4找回密码，5修改图像
     * @param userInfoUpdateModel
     * @return
     */
    @RequestMapping(value = "/user/info/update", method = RequestMethod.POST)
    @ResponseBody
    public Object userInfoUpdate(UserInfoUpdateModel userInfoUpdateModel){
        logger.info("UserController.userInfoUpdate.userInfoUpdate={}", userInfoUpdateModel.getUserId());
        HttpResponseMap map = new HttpResponseMap();
        User user = userService.selectUserByUserId(userInfoUpdateModel.getUserId());
        User user1 = new User();
        user1.setId(user.getId());
        if (userInfoUpdateModel.getType().equals("0")) {
            if (!userInfoUpdateModel.getUserName().equals(null)) {
                user1.setUserName(userInfoUpdateModel.getUserName());
            } else {
                map.setCode("400");
                map.setMsg("用户名不能为空");
                return map;
            }
            if (!userInfoUpdateModel.getUserposition().equals(null)) {
                user1.setUserposition(userInfoUpdateModel.getUserposition());
            } else {
                map.setCode("400");
                map.setMsg("职位不能为空");
                return map;
            }
        } else if (userInfoUpdateModel.getType().equals("1")) {
            if (!userInfoUpdateModel.getEmail().equals(null)) {
                user1.setEmail(userInfoUpdateModel.getEmail());
            } else {
                map.setCode("400");
                map.setMsg("邮箱不能为空");
                return map;
            }
        } else if (userInfoUpdateModel.getType().equals("2")) {
            if (!(userInfoUpdateModel.getPhone().equals(null) && userInfoUpdateModel.getPhoneOld().equals(null))) {
                ShortMessage shortMessage = shortMessageService.selectByPhoneAndCodeOrderByCreateTimeDesc(userInfoUpdateModel.getPhone(),userInfoUpdateModel.getCode());
                if (shortMessage == null) {
                    map.setCode("400");
                    map.setMsg("验证码不正确");
                    return map;
                } else {
                    long create = shortMessage.getCreateTime().getTime();
                    long now = new Date().getTime();
                    //验证码有效时间为60秒
                    if (now - create < 60000) {
                        map.setCode("400");
                        map.setMsg("验证码已失效");
                        return map;
                    } else {
                        user1.setPhone(userInfoUpdateModel.getPhone());
                    }
                }
            } else {
                map.setCode("400");
                map.setMsg("手机号码不能为空");
                return map;
            }
        } else if (userInfoUpdateModel.getType().equals("3")) {
            if ((!userInfoUpdateModel.getPassword().equals(null)) && (!userInfoUpdateModel.getPasswordOld().equals(null)) && user.getPassword().equals(userInfoUpdateModel.getPasswordOld())) {
                user1.setPassword(userInfoUpdateModel.getPassword());
            } else {
                map.setCode("400");
                map.setMsg("原密码不正确");
                return map;
            }
        } else {
            if (!userInfoUpdateModel.getPassword().equals(null)) {
                ShortMessage shortMessage = shortMessageService.selectByPhoneAndCodeOrderByCreateTimeDesc(userInfoUpdateModel.getPhone(),userInfoUpdateModel.getCode());
                if (shortMessage == null) {
                    map.setCode("400");
                    map.setMsg("验证码不正确");
                    return map;
                } else {
                    long create = shortMessage.getCreateTime().getTime();
                    long now = new Date().getTime();
                    //验证码有效时间为60秒
                    if (now - create < 60000) {
                        map.setCode("400");
                        map.setMsg("验证码已失效");
                        return map;
                    } else {
                        user1.setPassword(userInfoUpdateModel.getPassword());
                    }
                }
            } else {
                map.setCode("400");
                map.setMsg("密码不能为空");
                return map;
            }
        }
        userService.updateById(user1);
        User user2 = userService.selectUserByUserId(userInfoUpdateModel.getUserId());
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(user2);
        return map;
    }

    /**
     * 获取手机验证码
     * @param phone
     * @param type 0:登录 1:注册 2 旧邮箱验证码 3 新邮箱号验证码 4修改密码验证码 5找回密码
     * @return
     */
    @RequestMapping(value = "/user/phonecode", method = RequestMethod.POST)
    @ResponseBody
    public Object phoneCode(@RequestParam("phone") String phone, @RequestParam("type") String type) {
        logger.info("UserController.phoneCode.phone={}", phone);
        HttpResponseMap map = new HttpResponseMap();
        Map<String,String> dataMap = new HashMap<String,String>();
        if (phone.equals(null) || type.equals(null)) {
            map.setCode("400");
            map.setMsg("缺少参数");
        } else {
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setPhone(phone);
            String code = CodeUtil.phoneCode();
            shortMessage.setVerificationCode(code);
            shortMessage.setCodeType(Integer.parseInt(type));
            if (type.equals("1")) {
                boolean flag = SendSms.send(phone,code);
                if (flag) {
                    shortMessage.setStatus(1);
                    map.setCode("200");
                    map.setMsg("操作成功");
                } else {
                    shortMessage.setStatus(0);
                    map.setCode("400");
                    map.setMsg("操作失败");
                }
                shortMessageService.add(shortMessage);
                dataMap.put("phone",phone);
                dataMap.put("verificationCode",code);
                map.setData(dataMap);
            } else {
                User user = userService.selectUserByPhone(phone);
                if (user == null) {
                    map.setCode("400");
                    map.setMsg("该手机号还未注册");
                } else {
                    boolean flag = SendSms.send(phone,code);
                    if (flag) {
                        shortMessage.setStatus(1);
                        map.setCode("200");
                        map.setMsg("操作成功");
                    } else {
                        shortMessage.setStatus(0);
                        map.setCode("400");
                        map.setMsg("操作失败");
                    }
                    shortMessageService.add(shortMessage);
                    dataMap.put("phone",phone);
                    dataMap.put("verificationCode",code);
                    map.setData(dataMap);
                }
            }
        }
        return map;
    }
    @RequestMapping(value = "/user/info/updateCustomerLevel", method = RequestMethod.POST)
    @ResponseBody
    public Object customerLevelUpdate(User user) {
        logger.info("UserController.customerLevelUpdate.userId={}", user.getId());
        HttpResponseMap map = new HttpResponseMap();
        int cnt = userService.updateUserForCustomerLevel(user);
        if (cnt > 0) {
            map.setCode("200");
            map.setMsg("操作成功");
        } else {
            map.setCode("400");
            map.setMsg("操作失败");
        }
        return map;
    }
}
