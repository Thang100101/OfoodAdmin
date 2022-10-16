package com.example.ofoodadmin.Model.User;

import com.example.ofoodadmin.Model.User.User;

import java.io.Serializable;

public class Product implements Serializable {
    protected int id;
    protected String productName,productCode,vietgapCode;
    protected String certificationDate,address,phone;


    protected User user;
    protected boolean isExpired;
    protected Exp status;

    public enum Exp{
        Due,OutOfDate
    }

    public Product(String productName, String productCode, String vietgapCode, Exp status, String certificationDate,String phone,String address,boolean isExpired) {
        this.productName = productName;
        this.productCode = productCode;
        this.vietgapCode = vietgapCode;
        this.status = status;
        this.certificationDate = certificationDate;
        this.isExpired=isExpired;
        this.address=address;
        this.phone=phone;
    }

    public Product() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isExpỉed() {
        return isExpired;
    }

    public void setExpỉed(boolean expỉed) {
        isExpired = expỉed;
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
