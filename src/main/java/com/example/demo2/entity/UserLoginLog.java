package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "userloginlog")
public class UserLoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "loginTime")
    private Date loginTime;//登录时间
    @Column(name = "loginIp")
    private String loginIp;//登陆Ip
    @Column(name = "loginType")
    private String loginType;//登陆类型：0账号密码，1手机验证码
    @Column(name = "loginStatus")
    private Integer loginStatus;//登陆状态：0未成功，1成功

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }
}
