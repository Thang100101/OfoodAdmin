package com.example.ofoodadmin.Model.User;

import java.io.Serializable;

public class Certificator  implements Serializable {
    private String address,certficationScope,phoneNumber,email;
    private String locatorCode;
    private int id;

    public Certificator(String address, String certficationScope, String phoneNumber, String email, String locatorCode) {
        this.address = address;
        this.certficationScope = certficationScope;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.locatorCode = locatorCode;
    }

    public Certificator(String address, String certficationScope, String phoneNumber, String email, String locatorCode, int id) {
        this.address = address;
        this.certficationScope = certficationScope;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.locatorCode = locatorCode;
        this.id = id;
    }

    public Certificator() {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCertficationScope() {
        return certficationScope;
    }

    public void setCertficationScope(String certficationScope) {
        this.certficationScope = certficationScope;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocatorCode() {
        return locatorCode;
    }

    public void setLocatorCode(String locatorCode) {
        this.locatorCode = locatorCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Builder{
        private String address,certficationScope,phoneNumber,email;
        private String locatorCode;
        private int id;



        public Builder() {
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }


        public Builder setCertficationScope(String certficationScope) {
            this.certficationScope = certficationScope;
            return this;
        }


        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }


        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }


        public Builder setLocatorCode(String locatorCode) {
            this.locatorCode = locatorCode;
            return this;
        }
        public Certificator build(){
            return new Certificator(this.address,this.certficationScope,this.phoneNumber,this.email,this.locatorCode);
        }
    }
}
