package com.example.demo2.serviceImp;

import com.example.demo2.dao.CertifiedEnterpriseDao;
import com.example.demo2.entity.CertifiedEnterprise;
import com.example.demo2.entity.UserAddr;
import com.example.demo2.service.CertifiedEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class CertifiedEnterpriseServiceImp implements CertifiedEnterpriseService {
    @Autowired
    private CertifiedEnterpriseDao certifiedEnterpriseDao;

    @Override
    public int add(CertifiedEnterprise certifiedEnterprise) {
        certifiedEnterprise.setCreateTime(new Date());
        return certifiedEnterpriseDao.insertSelective(certifiedEnterprise);
    }

    @Override
    public int updateStatusById(String id, String status) {
        CertifiedEnterprise certifiedEnterprise= new CertifiedEnterprise();
        certifiedEnterprise.setStatus(Integer.parseInt(status));
        certifiedEnterprise.setUpdateTime(new Date());
        Example example = new Example(CertifiedEnterprise.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        //参数为 属性名+值
        criteria.andEqualTo("id",id);
        return certifiedEnterpriseDao.updateByExampleSelective(certifiedEnterprise,example);
    }
}
