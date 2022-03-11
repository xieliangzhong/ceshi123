package com.example.demo2.service;

import com.example.demo2.entity.UserAddr;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserAddrService {
    int addUserAddr(UserAddr userAddr);
    int delUserAddr(String userAddrId);
    int defulatUserAddr(String userAddrId, String userId);
    int updateUserAddr(UserAddr userAddr);
    List<UserAddr> userAddrList(String userId);
}
