package com.example.demo2.controller;

import com.example.demo2.entity.Contents;
import com.example.demo2.entity.Contentstwo;
import com.example.demo2.entity.Productmodel;
import com.example.demo2.service.ContentsService;
import com.example.demo2.service.ContentstwoService;
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
public class ContentsController {
    private static final Logger logger = LoggerFactory.getLogger("ContentsController.class");
    @Autowired
    private ContentsService contentsService;
    @Autowired
    private ContentstwoService contentstwoService;
    @Autowired
    private ProductmodelService productmodelService;

    /**
     * 一级菜单
     * @return
     */
    @RequestMapping(value = "/home/contentslist", method = RequestMethod.POST)
    @ResponseBody
    public Object contents(){
        logger.info("ContentsController.contents");
        HttpResponseMap map = new HttpResponseMap();
        List<Contents> list = contentsService.contentsList();
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }

    /**
     * 二级菜单
     * @param contentsId
     * @return
     */
    @RequestMapping(value = "/home/contents/two", method = RequestMethod.POST)
    @ResponseBody
    public Object contentsTwo(@RequestParam("contentsId") String contentsId){
        logger.info("ContentsController.contents.contentsId={}",contentsId);
        HttpResponseMap map = new HttpResponseMap();
        List<Contentstwo> list = contentstwoService.contentstwoList(contentsId);
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }
    /**
     * 三级菜单列表
     * @param contentstwoId
     * @return
     */
    @RequestMapping(value = "/home/contents/productmodel", method = RequestMethod.POST)
    @ResponseBody
    public Object productmodel(@RequestParam("contentstwoId") String contentstwoId){
        logger.info("ContentsController.contents.contentstwoId={}",contentstwoId);
        HttpResponseMap map = new HttpResponseMap();
        List<Productmodel> list = productmodelService.productmodelList(contentstwoId);
        map.setCode("200");
        map.setMsg("操作成功");
        map.setData(list);
        return map;
    }
}
