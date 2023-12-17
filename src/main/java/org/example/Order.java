package org.example;

import java.util.Map;

public class Order {
    private int id;
    private int userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(int id, int userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        this.totalPrice = calculateTotalPrice();
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    double calculateTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", userId=" + userId + ", orderDetails=" + orderDetails + ", totalPrice=" + totalPrice + '}';
    }
}
