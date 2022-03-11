package com.example.demo2.entity;

import javax.persistence.*;

/**
 * 型号
 */
@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "productmodelId")
    private Integer productmodelId;
    @Column(name = "toothNo")
    private String toothNo;
    @Column(name = "pulleyShapeA")
    private String pulleyShapeA;
    @Column(name = "pulleyShapeB")
    private String pulleyShapeB;
    @Column(name = "pulleyShapeK")
    private String pulleyShapeK;
    @Column(name = "A_H")
    private String A_H;
    @Column(name = "A_N")
    private String A_N;
    @Column(name = "A_Y")
    private String A_Y;
    @Column(name = "A_Y_Q")
    private String A_Y_Q;
    @Column(name = "A_Y_R")
    private String A_Y_R;
    @Column(name = "A_Y_S")
    private String A_Y_S;
    @Column(name = "A_Y_T")
    private String A_Y_T;
    @Column(name = "A_V")
    private String A_V;
    @Column(name = "A_V_Z")
    private String A_V_Z;
    @Column(name = "A_V_J")
    private String A_V_J;
    @Column(name = "B_V")
    private String B_V;
    @Column(name = "B_V_Z")
    private String B_V_Z;
    @Column(name = "B_V_J")
    private String B_V_J;
    @Column(name = "B_F")
    private String B_F;
    @Column(name = "B_F_Z")
    private String B_F_Z;
    @Column(name = "B_F_J")
    private String B_F_J;
    @Column(name = "B_H")
    private String B_H;
    @Column(name = "B_P")
    private String B_P;
    @Column(name = "B_N")
    private String B_N;
    @Column(name = "K_H")
    private String K_H;
    @Column(name = "K_P")
    private String K_P;
    @Column(name = "K_N")
    private String K_N;

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

    public String getToothNo() {
        return toothNo;
    }

    public void setToothNo(String toothNo) {
        this.toothNo = toothNo;
    }

    public String getPulleyShapeA() {
        return pulleyShapeA;
    }

    public void setPulleyShapeA(String pulleyShapeA) {
        this.pulleyShapeA = pulleyShapeA;
    }

    public String getPulleyShapeB() {
        return pulleyShapeB;
    }

    public void setPulleyShapeB(String pulleyShapeB) {
        this.pulleyShapeB = pulleyShapeB;
    }

    public String getPulleyShapeK() {
        return pulleyShapeK;
    }

    public void setPulleyShapeK(String pulleyShapeK) {
        this.pulleyShapeK = pulleyShapeK;
    }

    public String getA_H() {
        return A_H;
    }

    public void setA_H(String a_H) {
        A_H = a_H;
    }

    public String getA_N() {
        return A_N;
    }

    public void setA_N(String a_N) {
        A_N = a_N;
    }

    public String getA_Y() {
        return A_Y;
    }

    public void setA_Y(String a_Y) {
        A_Y = a_Y;
    }

    public String getA_Y_Q() {
        return A_Y_Q;
    }

    public void setA_Y_Q(String a_Y_Q) {
        A_Y_Q = a_Y_Q;
    }

    public String getA_Y_R() {
        return A_Y_R;
    }

    public void setA_Y_R(String a_Y_R) {
        A_Y_R = a_Y_R;
    }

    public String getA_Y_S() {
        return A_Y_S;
    }

    public void setA_Y_S(String a_Y_S) {
        A_Y_S = a_Y_S;
    }

    public String getA_Y_T() {
        return A_Y_T;
    }

    public void setA_Y_T(String a_Y_T) {
        A_Y_T = a_Y_T;
    }

    public String getA_V() {
        return A_V;
    }

    public void setA_V(String a_V) {
        A_V = a_V;
    }

    public String getA_V_Z() {
        return A_V_Z;
    }

    public void setA_V_Z(String a_V_Z) {
        A_V_Z = a_V_Z;
    }

    public String getA_V_J() {
        return A_V_J;
    }

    public void setA_V_J(String a_V_J) {
        A_V_J = a_V_J;
    }

    public String getB_V() {
        return B_V;
    }

    public void setB_V(String b_V) {
        B_V = b_V;
    }

    public String getB_V_Z() {
        return B_V_Z;
    }

    public void setB_V_Z(String b_V_Z) {
        B_V_Z = b_V_Z;
    }

    public String getB_V_J() {
        return B_V_J;
    }

    public void setB_V_J(String b_V_J) {
        B_V_J = b_V_J;
    }

    public String getB_F() {
        return B_F;
    }

    public void setB_F(String b_F) {
        B_F = b_F;
    }

    public String getB_F_Z() {
        return B_F_Z;
    }

    public void setB_F_Z(String b_F_Z) {
        B_F_Z = b_F_Z;
    }

    public String getB_F_J() {
        return B_F_J;
    }

    public void setB_F_J(String b_F_J) {
        B_F_J = b_F_J;
    }

    public String getB_H() {
        return B_H;
    }

    public void setB_H(String b_H) {
        B_H = b_H;
    }

    public String getB_P() {
        return B_P;
    }

    public void setB_P(String b_P) {
        B_P = b_P;
    }

    public String getB_N() {
        return B_N;
    }

    public void setB_N(String b_N) {
        B_N = b_N;
    }

    public String getK_H() {
        return K_H;
    }

    public void setK_H(String k_H) {
        K_H = k_H;
    }

    public String getK_P() {
        return K_P;
    }

    public void setK_P(String k_P) {
        K_P = k_P;
    }

    public String getK_N() {
        return K_N;
    }

    public void setK_N(String k_N) {
        K_N = k_N;
    }
}
