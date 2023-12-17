package org.example;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product (int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + ", stock=" + stock + '}';
    }
}
