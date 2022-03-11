package com.example.demo2.util;

import java.util.Random;

public class CodeUtil {

    /**
     * 获取企业编码
     * @return
     */
    public static String customerCode(){
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<8;i++){
            int number=random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return "HFCD" + sb.toString();
    }
    public static String phoneCode(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<4;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
