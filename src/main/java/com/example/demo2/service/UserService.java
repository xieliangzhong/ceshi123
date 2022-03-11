package com.example.demo2.service;

import com.example.demo2.entity.User;

public interface UserService {
    public User selectUserByUserId(String userId);
    public User selectUserByUserName(String userName);
    public User selectUserByPhone(String phone);
    public User selectUserByEmail(String email);
    public User selectUserByEnterpriseName(String enterpriseName);
    public User selectUserByUserNameAndPassword(String userName, String password);
    public int updateById(User user);
    public int add(User user);
    public int updateUserForCustomerLevel(User user);

}
