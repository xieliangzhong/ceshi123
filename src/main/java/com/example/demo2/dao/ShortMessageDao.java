package com.example.demo2.dao;

import com.example.demo2.entity.ShortMessage;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface ShortMessageDao extends Mapper<ShortMessage> {
    /**
     *
     * @param phone
     * @param verificationCode
     * @return
     */
    ShortMessage selectByPhoneAndCodeOrderByCreateTimeDesc(String phone, String verificationCode);

    /**
     *
     * @param status
     * @return
     */
    int updateStatusById(String status,String id);

    /**
     *
     * @param shortMessage
     * @return
     */
    int add(ShortMessage shortMessage);
}
