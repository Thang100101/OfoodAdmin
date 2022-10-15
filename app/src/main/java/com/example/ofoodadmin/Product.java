package com.example.ofoodadmin;

import com.example.ofoodadmin.User.User;
import com.example.ofoodadmin.User.User;

import java.io.Serializable;

public class Product implements Serializable {
    protected int id;
    protected String productName,productCode,vietgapCode;
    protected String certificationDate;


    protected User user;
    protected boolean isExpỉed;
    protected Exp status;

    public enum Exp{
        Due,OutOfDate
    }

    public Product(String productName, String productCode, String vietgapCode, Exp status, String certificationDate, User user, boolean isExpỉed) {
        this.productName = productName;
        this.productCode = productCode;
        this.vietgapCode = vietgapCode;
        this.status = status;
        this.certificationDate = certificationDate;
        this.user = user;
        this.isExpỉed=isExpỉed;
    }

    public Product() {
    }

    public boolean isExpỉed() {
        return isExpỉed;
    }

    public void setExpỉed(boolean expỉed) {
        isExpỉed = expỉed;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getVietgapCode() {
        return vietgapCode;
    }

    public void setVietgapCode(String vietgapCode) {
        this.vietgapCode = vietgapCode;
    }

    public Exp getStatus() {
        return status;
    }

    public void setStatus(Exp status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(String certificationDate) {
        this.certificationDate = certificationDate;
    }
}
