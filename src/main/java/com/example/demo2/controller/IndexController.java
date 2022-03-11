package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("/")
    public  String index(Map<String,Object> map){
        map.put("name","xieliangzhong");
        return "index";
    }

}
