package org.example;


import java.util.List;

import java.util.ArrayList;

public class Order {

    private int orderId;
    private ArrayList<Product> products;
    private String status;

    public Order(int orderId, ArrayList<Product> products, String status) {
        this.orderId = orderId;
        this.products = products;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
