package com.example.demo2.entity;

import javax.persistence.*;

/**
 * 材质
 */
@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "productmodelId")
    private Integer productmodelId;
    @Column(name = "productmodelName")
    private String productmodelName;
    @Column(name = "materialModel")
    private String materialModel;
    @Column(name = "materialName")
    private String materialName;
    private String name;

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

    public String getProductmodelName() {
        return productmodelName;
    }

    public void setProductmodelName(String productmodelName) {
        this.productmodelName = productmodelName;
    }

    public String getMaterialModel() {
        return materialModel;
    }

    public void setMaterialModel(String materialModel) {
        this.materialModel = materialModel;
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
}
