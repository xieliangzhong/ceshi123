package com.example.demo2.entity;

import javax.persistence.*;

/**
 * 表面处理
 */
@Entity
@Table(name = "surfacetreatment")
public class Surfacetreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "materialId")
    private Integer materialId;
    @Column(name = "materialName")
    private String materialName;
    private String name;
    @Column(name = "modelName")
    private String modelName;
    @Column(name = "modelValue")
    private String modelValue;
    @Column(name = "productmodelId")
    private Integer productmodelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelValue() {
        return modelValue;
    }

    public void setModelValue(String modelValue) {
        this.modelValue = modelValue;
    }

    public Integer getProductmodelId() {
        return productmodelId;
    }

    public void setProductmodelId(Integer productmodelId) {
        this.productmodelId = productmodelId;
    }
}
