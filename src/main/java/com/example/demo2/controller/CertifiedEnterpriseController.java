package com.example.demo2.controller;

import com.example.demo2.entity.CertifiedEnterprise;
import com.example.demo2.entity.UserAddr;
import com.example.demo2.service.CertifiedEnterpriseService;
import com.example.demo2.service.UserAddrService;
import com.example.demo2.util.HttpResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class CertifiedEnterpriseController {
    private static final Logger logger = LoggerFactory.getLogger("CertifiedEnterpriseController.class");
    @Autowired
    private CertifiedEnterpriseService certifiedEnterpriseService;

    /**
     *
     * @param certifiedEnterprise
     * @return
     */
    @RequestMapping(value = "/enterprise/certified/add", method = RequestMethod.POST)
    @ResponseBody
    public Object enterpriseCertified (CertifiedEnterprise certifiedEnterprise) {
        logger.info("UserAddrController.certifiedEnterprise.userId={}", certifiedEnterprise.getUserId());
        HttpResponseMap map = new HttpResponseMap();
        int cnt = certifiedEnterpriseService.add(certifiedEnterprise);
        if (cnt > 0) {
            map.setCode("200");
            map.setMsg("操作成功");
        } else {
            map.setCode("400");
            map.setMsg("操作失败");
        }
        return map;
    }

    /**
     * 认证企业 通过/拒绝
     * @param certifiedEnterpriseId
     * @param status
     * @return
     */
    @RequestMapping(value = "/enterprise/certified/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateEnterpriseCertified (@RequestParam("certifiedEnterpriseId") String certifiedEnterpriseId, @RequestParam("status") String status) {
        logger.info("UserAddrController.certifiedEnterprise.id={}", certifiedEnterpriseId);
        HttpResponseMap map = new HttpResponseMap();
        int cnt = certifiedEnterpriseService.updateStatusById(certifiedEnterpriseId,status);
        if (cnt > 0) {
            map.setCode("200");
            map.setMsg("操作成功");
        } else {
            map.setCode("400");
            map.setMsg("操作失败");
        }
        return map;
    }
}
