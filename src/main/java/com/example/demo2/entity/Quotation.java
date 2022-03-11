package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "quotation")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;//用户id
    @Column(name = "productId")
    private String productId;//商品id
    @Column(name = "productName")
    private String productName;//商品名称
    @Column(name = "productCnt")
    private Integer productCnt;//商品数量
    @Column(name = "itemNo")
    private String itemNo;//内部料号
    @Column(name = "customizedRequirements")
    private String customizedRequirements;//定制需求
    @Column(name = "applicationIndustry")
    private String applicationIndustry;//应用行业
    @Column(name = "enclosureAddr")
    private String enclosureAddr;//附件地址
    @Column(name = "createTime")
    private Date createTime;//制单时间
    @Column(name = "updateTime")
    private Date updateTime;//最后修改时间
    @Column(name = "completeTime")
    private Date completeTime;//报价完成时间
    @Column(name = "quotedAmount")
    private Double quotedAmount ;//报价金额
    @Column(name = "quotedCnt")
    private Integer quotedCnt;//报价次数

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductCnt() {
        return productCnt;
    }

    public void setProductCnt(Integer productCnt) {
        this.productCnt = productCnt;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getCustomizedRequirements() {
        return customizedRequirements;
    }

    public void setCustomizedRequirements(String customizedRequirements) {
        this.customizedRequirements = customizedRequirements;
    }

    public String getApplicationIndustry() {
        return applicationIndustry;
    }

    public void setApplicationIndustry(String applicationIndustry) {
        this.applicationIndustry = applicationIndustry;
    }

    public String getEnclosureAddr() {
        return enclosureAddr;
    }

    public void setEnclosureAddr(String enclosureAddr) {
        this.enclosureAddr = enclosureAddr;
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

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Double getQuotedAmount() {
        return quotedAmount;
    }

    public void setQuotedAmount(Double quotedAmount) {
        this.quotedAmount = quotedAmount;
    }

    public Integer getQuotedCnt() {
        return quotedCnt;
    }

    public void setQuotedCnt(Integer quotedCnt) {
        this.quotedCnt = quotedCnt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
