package com.example.demo2.service;

import com.example.demo2.entity.CertifiedEnterprise;

public interface CertifiedEnterpriseService {
    public int add(CertifiedEnterprise certifiedEnterprise);
    public int updateStatusById(String id, String status);
}
