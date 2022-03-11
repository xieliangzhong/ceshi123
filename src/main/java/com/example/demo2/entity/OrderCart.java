package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ordercart")
public class OrderCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;//用户id
    @Column(name = "productId")
    private String productId;//商品id
    @Column(name = "productName")
    private String productName;//商品id
    @Column(name = "productCnt")
    private Integer  productCnt;//商品数量
    @Column(name = "productPrice")
    private Double productPrice;//未税单价
    @Column(name = "productCntDiscount")
    private Double productCntDiscount;//数量折扣
    @Column(name = "productPriceDiscount")
    private Double productPriceDiscount;//未税折扣单价
    @Column(name = "productPriceTaxDiscount")
    private Double productPriceTaxDiscount;//含税折扣单价
    @Column(name = "deliveryDays")
    private Integer deliveryDays;//发货天数
    @Column(name = "createTime")
    private Date createTime;//加入购物车时间
    @Column(name = "updateTime")
    private Date updateTime;//最后修改时间

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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductCntDiscount() {
        return productCntDiscount;
    }

    public void setProductCntDiscount(Double productCntDiscount) {
        this.productCntDiscount = productCntDiscount;
    }

    public Double getProductPriceDiscount() {
        return productPriceDiscount;
    }

    public void setProductPriceDiscount(Double productPriceDiscount) {
        this.productPriceDiscount = productPriceDiscount;
    }

    public Double getProductPriceTaxDiscount() {
        return productPriceTaxDiscount;
    }

    public void setProductPriceTaxDiscount(Double productPriceTaxDiscount) {
        this.productPriceTaxDiscount = productPriceTaxDiscount;
    }

    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
