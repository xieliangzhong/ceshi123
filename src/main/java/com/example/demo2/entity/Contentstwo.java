package com.example.demo2.entity;

import javax.persistence.*;

/**
 * 二级产品菜单
 */
@Entity
@Table(name = "contentstwo")
public class Contentstwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "contentsId")
    private Integer contentsId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentsId() {
        return contentsId;
    }

    public void setContentsId(Integer contentsId) {
        this.contentsId = contentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
