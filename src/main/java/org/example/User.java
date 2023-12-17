package org.example;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String username;
    private Map<Product, Integer> cart;


    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }
    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);
        if (currentQuantity <= quantity) {
            cart.remove(product);
        } else {
            cart.put(product, currentQuantity - quantity);
        }
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', cart=" + cart + '}';
    }
}
