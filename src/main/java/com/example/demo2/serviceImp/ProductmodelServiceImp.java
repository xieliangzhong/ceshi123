package com.example.demo2.serviceImp;

import com.example.demo2.dao.MaterialDao;
import com.example.demo2.dao.ProductmodelDao;
import com.example.demo2.dao.SurfacetreatmentDao;
import com.example.demo2.entity.*;
import com.example.demo2.service.ProductmodelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductmodelServiceImp implements ProductmodelService {
    @Autowired
    private ProductmodelDao productmodelDao;
    @Autowired
    private MaterialDao materialDao;
    @Autowired
    private SurfacetreatmentDao surfacetreatmentDao;
    @Override
    public List<Productmodel> productmodelList(String contentstwoId) {
        Example example1 = new Example(Productmodel.class);
        // 创建Criteria
        Example.Criteria criteria1 = example1.createCriteria();
        //参数为 属性名+值
        criteria1.andEqualTo("contentstwoId",contentstwoId);
        return productmodelDao.selectByExample(example1);
    }

    @Override
    public List<Material> materialList(String productmodelId) {
        Example example1 = new Example(Material.class);
        // 创建Criteria
        Example.Criteria criteria1 = example1.createCriteria();
        //参数为 属性名+值
        criteria1.andEqualTo("productmodelId",productmodelId);
        return materialDao.selectByExample(example1);

    }

    @Override
    public List<Surfacetreatment> surfacetreatmentList(String productmodelId, String materialId) {
        Example example1 = new Example(Surfacetreatment.class);
        // 创建Criteria
        Example.Criteria criteria1 = example1.createCriteria();
        //参数为 属性名+值
        criteria1.andEqualTo("productmodelId",productmodelId);
        if ("".equals(materialId) || materialId.equals(null) || materialId.equals("null")) {

        } else {
            criteria1.andEqualTo("materialId",materialId);
        }
        return surfacetreatmentDao.selectByExample(example1);
    }

    @Override
    public List<Beltwidth> beltwidthList(String productmodelId, String materialId, String surfacetreatmentId) {
        Example example1 = new Example(Beltwidth.class);
        // 创建Criteria
        Example.Criteria criteria1 = example1.createCriteria();
        //参数为 属性名+值
        criteria1.andEqualTo("productmodelId",productmodelId);
        if ("".equals(materialId) || materialId.equals(null) || materialId.equals("null")) {

        } else {
            criteria1.andEqualTo("materialId",materialId);
        }
        if ("".equals(surfacetreatmentId) || surfacetreatmentId.equals(null) || surfacetreatmentId.equals("null")) {

        } else {
            criteria1.andEqualTo("surfacetreatmentId",surfacetreatmentId);
        }

        return null;
    }
}
