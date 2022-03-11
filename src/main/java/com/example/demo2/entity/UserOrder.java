package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "userorder")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "orderNumber")
    private String orderNumber;//订单编号
    private String consignee;//收货人姓名
    private String phone;//联系电话
    @Column(name = "paymentMethod")
    private Integer paymentMethod;//支付方式：1转账，2微信，3支付宝
    @Column(name = "orderMoney")
    private Double orderMoney;//订单金额
    @Column(name = "shippingMoney")
    private Double shippingMoney;//运费金额
    @Column(name = "districtMoney")
    private Double districtMoney;//优惠金额
    @Column(name = "shippingCompName")
    private String shippingCompName;//快递公司名称
    @Column(name = "shippingNumber")
    private String shippingNumber;//#快递单号
    @Column(name = "orderStatus")
    private Integer orderStatus;//订单状态
    private String  province;
    private String address;
    @Column(name = "orderPoint")
    private String orderPoint;//订单积分
    @Column(name = "productId")
    private String  productId;//商品id
    @Column(name = "productName")
    private String  productName;//商品名称
    @Column(name = "productCnt")
    private Integer productCnt;//购买商品数量
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
    private Date createTime;//下单时间
    @Column(name = "updateTime")
    private Date updateTime;//最后修改时间
    @Column(name = "shippingTime")
    private Date shippingTime;//发货时间
    @Column(name = "payTime")
    private Date payTime;//支付时间
    @Column(name = "receiveTime")
    private Date receiveTime;//收货时间

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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Double getShippingMoney() {
        return shippingMoney;
    }

    public void setShippingMoney(Double shippingMoney) {
        this.shippingMoney = shippingMoney;
    }

    public Double getDistrictMoney() {
        return districtMoney;
    }

    public void setDistrictMoney(Double districtMoney) {
        this.districtMoney = districtMoney;
    }

    public String getShippingCompName() {
        return shippingCompName;
    }

    public void setShippingCompName(String shippingCompName) {
        this.shippingCompName = shippingCompName;
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(String orderPoint) {
        this.orderPoint = orderPoint;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}
