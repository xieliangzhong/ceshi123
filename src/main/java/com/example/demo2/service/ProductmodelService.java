package com.example.demo2.service;

import com.example.demo2.entity.Beltwidth;
import com.example.demo2.entity.Material;
import com.example.demo2.entity.Productmodel;
import com.example.demo2.entity.Surfacetreatment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductmodelService {
    public List<Productmodel> productmodelList(String contentstwoId);
    public List<Material> materialList(String productmodelId);
    public List<Surfacetreatment> surfacetreatmentList(String productmodelId, String materialId);
    public List<Beltwidth> beltwidthList(String productmodelId, String materialId,String surfacetreatmentId);
}
