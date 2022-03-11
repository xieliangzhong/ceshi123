package com.example.demo2.service;

import com.example.demo2.entity.ShortMessage;

public interface ShortMessageService {
    ShortMessage selectByPhoneAndCodeOrderByCreateTimeDesc(String phone, String verificationCode);
    int updateStatusById(String status,String id);
    int add(ShortMessage shortMessage);

}
