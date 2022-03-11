package com.example.demo2.entity;

import javax.persistence.*;

/**
 * 三级产品菜单列表
 */
@Entity
@Table(name = "productmodel")
public class Productmodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "contenststwoId")
    private Integer contenststwoId;
    private String type;
    private String model;
    @Column(name = "modelName")
    private String modelName;
    private String purpose;
    private String pitch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContenststwoId() {
        return contenststwoId;
    }

    public void setContenststwoId(Integer contenststwoId) {
        this.contenststwoId = contenststwoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }
}
