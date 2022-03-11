package com.example.demo2.controller;

import com.example.demo2.entity.UserAddr;
import com.example.demo2.service.UserAddrService;
import com.example.demo2.util.HttpResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class UserAddrController {
    private static final Logger logger = LoggerFactory.getLogger("UserAddrController.class");
    @Autowired
    private UserAddrService userAddrService;

    /**
     * 增加地址
     * @param userAddr
     * @return
     */
    @RequestMapping(value = "/user/addr/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addUserAddr (UserAddr userAddr) {
        logger.info("UserAddrController.userAddr.userId={}", userAddr.getUserId());
        HttpResponseMap map = new HttpResponseMap();
        userAddr.setCreateTime(new Date());
        int cnt = userAddrService.addUserAddr(userAddr);
        if (cnt > 0) {
            map.setCode("200");
            map.setMsg("操作成功");
        } else {
            map.setCode("400");
            map.setMsg("操作失败");
        }
        return map;
    }

    /**
     * 获取地址列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/addr/list", method = RequestMethod.POST)
    @ResponseBody
    public Object  userAddrList(@RequestParam("userId") String userId) {
        logger.info("UserAddrController.userAddr.userId={}", userId);
        HttpResponseMap map = new HttpResponseMap();
        List<UserAddr> list = userAddrService.userAddrList(userId);
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }

    /**
     * 删除地址
     * @param userAddrId
     * @return
     */
    @RequestMapping(value = "/user/addr/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delUserAddr (@RequestParam("userAddrId") String userAddrId) {
        logger.info("UserAddrController.userAddr.userAddrId={}", userAddrId);
        HttpResponseMap map = new HttpResponseMap();
        int cnt = userAddrService.delUserAddr(userAddrId);
        if (cnt > 0) {
            map.setCode("200");
            map.setMsg("操作成功");
        } else {
            map.setCode("400");
            map.setMsg("操作失败");
        }
        return map;
    }

    /**
     * 设置默认地址
     * @param userAddrId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/addr/default", method = RequestMethod.POST)
    @ResponseBody
    public Object defaultUserAddr (@RequestParam("userAddrId") String userAddrId, @RequestParam("userId") String userId) {
        logger.info("UserAddrController.userAddr.userAddrId={}", userAddrId);
        HttpResponseMap map = new HttpResponseMap();
        int cnt = userAddrService.defulatUserAddr(userAddrId, userId);
        if (cnt > 0) {
            map.setCode("200");
            map.setMsg("操作成功");
        } else {
            map.setCode("400");
            map.setMsg("操作失败");
        }
        return map;
    }

    /**
     * 修该地址
     * @param userAddr
     * @return
     */
    @RequestMapping(value = "/user/addr/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateUserAddr (UserAddr userAddr) {
        logger.info("UserAddrController.userAddr.userAddrId={}", userAddr.getId());
        HttpResponseMap map = new HttpResponseMap();
        int cnt = userAddrService.updateUserAddr(userAddr);
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
