package com.example.demo2.serviceImp;

import com.example.demo2.dao.UserLoginLogDao;
import com.example.demo2.entity.UserLoginLog;
import com.example.demo2.service.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginLogServiceImp implements UserLoginLogService {
    @Autowired
    private UserLoginLogDao userLoginLogDao;
    @Override
    public int add(UserLoginLog userLoginLog) {
        return userLoginLogDao.add(userLoginLog);
    }
}
