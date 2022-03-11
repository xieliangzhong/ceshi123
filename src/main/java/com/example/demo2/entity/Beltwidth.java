package com.example.demo2.entity;

import javax.persistence.*;

/**
 * 皮带宽度
 */
@Entity
@Table(name = "beltwidth")
public class Beltwidth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "productmodelId")
    private Integer productmodelId;
    @Column(name = "surfacetreatmentId")
    private Integer surfacetreatmentId;
    @Column(name = "BeltwidthValue")
    private String BeltwidthValue;
    @Column(name = "BeltwidthName")
    private String  BeltwidthName;
    @Column(name = "widthA")
    private String widthA;
    @Column(name = "widthW")
    private String widthW;
    @Column(name = "widthL")
    private String widthL;
    @Column(name = "modelName")
    private String modelName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductmodelId() {
        return productmodelId;
    }

    public void setProductmodelId(Integer productmodelId) {
        this.productmodelId = productmodelId;
    }

    public Integer getSurfacetreatmentId() {
        return surfacetreatmentId;
    }

    public void setSurfacetreatmentId(Integer surfacetreatmentId) {
        this.surfacetreatmentId = surfacetreatmentId;
    }

    public String getBeltwidthValue() {
        return BeltwidthValue;
    }

    public void setBeltwidthValue(String beltwidthValue) {
        BeltwidthValue = beltwidthValue;
    }

    public String getBeltwidthName() {
        return BeltwidthName;
    }

    public void setBeltwidthName(String beltwidthName) {
        BeltwidthName = beltwidthName;
    }

    public String getWidthA() {
        return widthA;
    }

    public void setWidthA(String widthA) {
        this.widthA = widthA;
    }

    public String getWidthW() {
        return widthW;
    }

    public void setWidthW(String widthW) {
        this.widthW = widthW;
    }

    public String getWidthL() {
        return widthL;
    }

    public void setWidthL(String widthL) {
        this.widthL = widthL;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
