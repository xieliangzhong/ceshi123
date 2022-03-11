package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "certifiedenterprise")
public class CertifiedEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private String userId;
    private String name;
    private String phone;
    private String email;
    @Column(name = "enterpriseName")
    private String enterpriseName; //企业名称
    @Column(name = "userPosition")
    private String userPosition;//职位
    private String addrerss;
    @Column(name = "detailedAddress")
    private String detailedAddress;
    @Column(name = "applicationPath")
    private String applicationPath;//申请表地址
    @Column(name = "businessLicensePath")
    private String businessLicensePath;//营业执照地址
    private Integer status;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "updateTime")
    private Date  updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getAddrerss() {
        return addrerss;
    }

    public void setAddrerss(String addrerss) {
        this.addrerss = addrerss;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public String getBusinessLicensePath() {
        return businessLicensePath;
    }

    public void setBusinessLicensePath(String businessLicensePath) {
        this.businessLicensePath = businessLicensePath;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
