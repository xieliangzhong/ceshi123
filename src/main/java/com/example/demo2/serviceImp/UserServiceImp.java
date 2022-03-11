package com.example.demo2.serviceImp;

import com.example.demo2.dao.UserDao;
import com.example.demo2.entity.User;
import com.example.demo2.entity.UserAddr;
import com.example.demo2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImp implements UserService {
    private static final Logger logger = LoggerFactory.getLogger("UserServiceImp.class");
    @Autowired
    private UserDao userDao;
    @Override
    public User selectUserByUserId(String userId) {
        logger.info("UserServiceImp.selectUserByUserId={}", userId);
        User user = userDao.selectUserByUserId(userId);
        return user;
    }

    @Override
    public User selectUserByUserName(String userName) {
        logger.info("UserServiceImp.selectUserByUserId={}", userName);
        User user = userDao.selectUserByUserName(userName);
        return user;
    }

    @Override
    public User selectUserByPhone(String phone) {
        logger.info("UserServiceImp.selectUserByUserId={}", phone);
        User user = userDao.selectUserByPhone(phone);
        return user;
    }

    @Override
    public User selectUserByEmail(String email) {
        logger.info("UserServiceImp.selectUserByUserId={}", email);
        User user = userDao.selectUserByEmail(email);
        return user;
    }

    @Override
    public User selectUserByEnterpriseName(String enterpriseName) {
        logger.info("UserServiceImp.selectUserByUserId={}", enterpriseName);
        User user = userDao.selectUserByEnterpriseName(enterpriseName);
        return user;
    }

    @Override
    public User selectUserByUserNameAndPassword(String userName, String password) {
        logger.info("UserServiceImp.selectUserByUserNameAndPassword,userName={},password", userName,password);
        User user = userDao.selectUserByUserNameAndPassword(userName,password);
        return user;
    }

    @Override
    public int updateById(User user) {
        logger.info("UserServiceImp.selectUserByUserId={}", user);
        int count = userDao.updateById(user);
        return count;

    }
    @Override
    public int add(User user) {
        logger.info("UserServiceImp.selectUserByUserId={}", user);
        int count = userDao.add(user);
        return count;
    }

    @Override
    public int updateUserForCustomerLevel(User user) {
        User user1= new User();
        user1.setCustomerLevel("02");
        user1.setUpdateTime(new Date());
        Example example = new Example(User.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        //参数为 属性名+值
        criteria.andEqualTo("id",user.getId());
        return userDao.updateByExampleSelective(user1,example);
    }

}
