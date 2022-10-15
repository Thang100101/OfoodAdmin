package com.example.ofoodadmin.User;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private Certificator certificator;
    private Producer producer;
    private boolean accessRights;
    private boolean isCer;
    private static User currentUser;

    public static User getCurrentUser(){
        return currentUser;
    }
    public static void setCurrentUser(User user){
        User.currentUser = user;
    }
    public static void signOut(){
        User.currentUser = null;
    }

    public User(Certificator certificator,String username, String password, boolean accessRights,boolean isCer) {
        this.username = username;
        this.password = password;
        this.accessRights = accessRights;
        this.isCer=isCer;
        this.certificator=certificator;
    }
    public User(Producer producer,String username, String password, boolean accessRights,boolean isCer) {
        this.username = username;
        this.password = password;
        this.accessRights = accessRights;
        this.isCer=isCer;
        this.producer=producer;
    }

    public User() {
    }

    public Certificator getCertificator() {
        return certificator;
    }

    public void setCertificator(Certificator certificator) {
        this.certificator = certificator;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public boolean isCer() {
        return isCer;
    }

    public void setCer(boolean cer) {
        isCer = cer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccessRights() {
        return accessRights;
    }

    public void setAccessRights(boolean accessRights) {
        this.accessRights = accessRights;
    }
}
