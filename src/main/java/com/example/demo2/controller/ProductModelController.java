package com.example.demo2.controller;

import com.example.demo2.entity.Beltwidth;
import com.example.demo2.entity.Material;
import com.example.demo2.entity.Productmodel;
import com.example.demo2.entity.Surfacetreatment;
import com.example.demo2.service.ProductmodelService;
import com.example.demo2.util.HttpResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductModelController {
    private static final Logger logger = LoggerFactory.getLogger("ProductModelController.class");
    @Autowired
    private ProductmodelService productmodelService;

    /**
     * 获取材质列表
     * @param productmodelId
     * @return
     */
    @RequestMapping(value = "/product/model/material", method = RequestMethod.POST)
    @ResponseBody
    public Object materialList(@RequestParam("productmodelId") String productmodelId){
        logger.info("ProductModelController.material.productmodelId={}",productmodelId);
        HttpResponseMap map = new HttpResponseMap();
        List<Material> list = productmodelService.materialList(productmodelId);
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }

    /**
     * 获取表面处理列表
     * @param productmodelId
     * @param materialId
     * @return
     */
    @RequestMapping(value = "/product/model/surfacetreatment", method = RequestMethod.POST)
    @ResponseBody
    public Object surfacetreatmentList(@RequestParam("productmodelId") String productmodelId, @RequestParam("materialId") String materialId){
        logger.info("ProductModelController.material.productmodelId={}",productmodelId);
        HttpResponseMap map = new HttpResponseMap();
        List<Surfacetreatment> list = productmodelService.surfacetreatmentList(productmodelId,materialId);
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }
    /**
     * 获皮带宽度列表
     * @param productmodelId
     * @return
     */
    @RequestMapping(value = "/product/model/beltwidth", method = RequestMethod.POST)
    @ResponseBody
    public Object beltwidthList(@RequestParam("productmodelId") String productmodelId, @RequestParam("materialId") String materialId,
                                @RequestParam("surfacetreatmentId") String surfacetreatmentId){
        logger.info("ProductModelController.beltwidthList.productmodelId={}",productmodelId);
        HttpResponseMap map = new HttpResponseMap();
        List<Beltwidth> list = productmodelService.beltwidthList(productmodelId,materialId,surfacetreatmentId);
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }
}
