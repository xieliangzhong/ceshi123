package com.example.demo2.serviceImp;

import com.example.demo2.dao.UserAddrDao;
import com.example.demo2.entity.UserAddr;
import com.example.demo2.service.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserAddrServiceImp implements UserAddrService {
    @Autowired
    private UserAddrDao userAddrDao;
    @Override
    public int addUserAddr(UserAddr userAddr) {

        return userAddrDao.insertSelective(userAddr);
    }

    @Override
    public int delUserAddr(String userAddrId) {
        return userAddrDao.deleteByPrimaryKey(userAddrId);
    }

    @Override
    public int defulatUserAddr(String userAddrId, String userId) {
        UserAddr userAddr1= new UserAddr();
        userAddr1.setDefaultAddr("0");
        Example example1 = new Example(UserAddr.class);
        // 创建Criteria
        Example.Criteria criteria1 = example1.createCriteria();
        //参数为 属性名+值
        criteria1.andEqualTo("userId",userId);
        userAddrDao.updateByExampleSelective(userAddr1,example1);

        UserAddr userAddr= new UserAddr();
        userAddr.setDefaultAddr("1");
        userAddr.setUpdateTime(new Date());
        Example example = new Example(UserAddr.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        //参数为 属性名+值
        criteria.andEqualTo("id",userAddrId);
        return userAddrDao.updateByExampleSelective(userAddr,example);
    }

    @Override
    public int updateUserAddr(UserAddr userAddr) {
        userAddr.setUpdateTime(new Date());
        return userAddrDao.updateByPrimaryKeySelective(userAddr);
    }

    @Override
    public List<UserAddr> userAddrList(String userId) {
        //查询器
        Example example = new Example(UserAddr.class);
        //获得criteria
        Example.Criteria criteria=example.createCriteria();
        //参数为 属性名+值
        criteria.andEqualTo("userId",userId);
        //排序
        example.orderBy("defaultAddr").desc();
        example.orderBy("createTime").desc();
        return userAddrDao.selectByExample(example);
    }
}
