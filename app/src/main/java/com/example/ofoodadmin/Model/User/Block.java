package com.example.ofoodadmin.Model.User;

import com.example.ofoodadmin.Model.User.Product;
import com.example.ofoodadmin.Model.User.User;
import java.io.Serializable;

public class Block implements Serializable {
    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Block(boolean status, Action action, Product product, User user) {
        this.status = status;
        this.action = action;
        this.product = product;
        this.user = user;
    }

    public Block() {
    }

    private int id;
    private boolean status;
    private Action action;
    private Product product;



    private User user;

    public enum Action{
        Add, Update
    }
}
