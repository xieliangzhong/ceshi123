package com.example.demo2.util;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.dysmsapi.model.v20170525.*;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class SendSms {
    private static final Logger logger = LoggerFactory.getLogger("SendSms.class");
    private static final String accessKeyId = "LTAI5tLtDCoZgBjBLU2aAR67";
    private static final String accessKeySecret = "Nw13GQDIqNaMHfkl7q1Tpi1dj4LMik";
    private static final String templateCode= "SMS_235850070";
    public static boolean send(String phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-huangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);//接收短信的手机号码
        request.setSignName("爱合发");//短信签名名称
        request.setTemplateCode(templateCode);//短信模板CODE
        Map<String, String> data = new HashMap<String,String>();
        data.put("code",code);
        Gson gson = new Gson();
        request.setTemplateParam(gson.toJson(data));//短信模板变量对应的实际值

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            logger.info("发送短信返回结果,respose={}",new Gson().toJson(response));
            if (response.getCode().equals("OK")) {
                return true;
            } else {
                return false;
            }
        } catch (ServerException e) {
            logger.error("发送短信异常erro={}",e.getMessage());
            return false;
        } catch (ClientException e) {
            logger.error("ErrCode={},ErrMsg={},RequestId={}", e.getErrCode(),e.getErrMsg(),e.getRequestId());
            return false;
        }

    }
 /*   public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-huangzhou", "LTAI5tLtDCoZgBjBLU2aAR67", "Nw13GQDIqNaMHfkl7q1Tpi1dj4LMik");
        *//** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **//*
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers("17671461390");//接收短信的手机号码
        request.setSignName("爱合发");//短信签名名称
        request.setTemplateCode("SMS_235850070");//短信模板CODE
        Map<String, String> data = new HashMap<String,String>();
        data.put("code","1789");
        Gson gson = new Gson();
        request.setTemplateParam(gson.toJson(data));//短信模板变量对应的实际值

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }*/
}

