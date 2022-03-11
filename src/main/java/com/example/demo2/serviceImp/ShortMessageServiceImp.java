package com.example.demo2.serviceImp;

import com.example.demo2.dao.ShortMessageDao;
import com.example.demo2.entity.ShortMessage;
import com.example.demo2.service.ShortMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortMessageServiceImp implements ShortMessageService {
    private static final Logger logger = LoggerFactory.getLogger("ShortMessageServiceImp.class");
    @Autowired
    private ShortMessageDao shortMessageDao;

    @Override
    public ShortMessage selectByPhoneAndCodeOrderByCreateTimeDesc(String phone, String verificationCode) {
        ShortMessage shortMessage = shortMessageDao.selectByPhoneAndCodeOrderByCreateTimeDesc(phone,verificationCode);
        return shortMessage;
    }

    @Override
    public int updateStatusById(String status, String id) {
        return shortMessageDao.updateStatusById(status,id);

    }

    @Override
    public int add(ShortMessage shortMessage) {
        return shortMessageDao.add(shortMessage);
    }
}
