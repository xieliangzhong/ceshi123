package com.example.demo2.serviceImp;

import com.example.demo2.dao.ContentstwoDao;
import com.example.demo2.entity.Contentstwo;
import com.example.demo2.entity.UserAddr;
import com.example.demo2.service.ContentstwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ContentstwoServiceImp implements ContentstwoService {
    @Autowired
    private ContentstwoDao contentstwoDao;
    @Override
    public List<Contentstwo> contentstwoList(String contentsId) {
        Example example1 = new Example(Contentstwo.class);
        // 创建Criteria
        Example.Criteria criteria1 = example1.createCriteria();
        //参数为 属性名+值
        criteria1.andEqualTo("contentsId",contentsId);
        return contentstwoDao.selectByExample(example1);

    }
}
