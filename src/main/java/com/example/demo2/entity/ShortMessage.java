package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "shortmessage")
public class ShortMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    private String phone;//手机号
    private String message;//短信内容
    @Column(name = "verificationCode")
    private String verificationCode;//验证码
    @Column(name = "codeType")
    private Integer codeType;//0:登录 1:注册 2 旧邮箱验证码 3 新邮箱号验证码 4修改密码验证码 5找回密码") #短信类型
    private Integer status;//发送状态：0未成功，1成功
    @Column(name = "createTime")
    private Date createTime;//短信发送时间
    @Column(name = "updateTime")
    private Date updateTime;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
