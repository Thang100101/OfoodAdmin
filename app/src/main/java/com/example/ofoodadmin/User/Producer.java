package com.example.ofoodadmin.User;

import java.io.Serializable;

public class Producer  implements Serializable {

    private String address;
    private String ownerName;
    private String phone;
    private String city;
    private int id;

    public Producer( String address, String ownerName, String phone, String city) {
        this.address = address;
        this.ownerName = ownerName;
        this.phone = phone;
        this.city = city;
    }

    public Producer( String address, String ownerName, String phone, String city, int id) {
        this.address = address;
        this.ownerName = ownerName;
        this.phone = phone;
        this.city = city;
        this.id = id;
    }

    public Producer() {

    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Builder{

        private String address;
        private String ownerName;
        private String phone;
        private String city;
        private int id;

        public Builder() {
        }


        public Builder setOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setCity(String city){
            this.city = city;
            return this;
        }

        public Producer build(){
            return new Producer(this.address,this.ownerName, this.phone, this.city);
        }
    }
}
