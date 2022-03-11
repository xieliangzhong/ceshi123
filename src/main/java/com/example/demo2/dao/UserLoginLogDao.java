package com.example.demo2.dao;

import com.example.demo2.entity.UserLoginLog;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserLoginLogDao extends Mapper<UserLoginLog> {

    int add(UserLoginLog userLoginLog);
}
