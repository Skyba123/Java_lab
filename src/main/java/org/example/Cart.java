package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products =new ArrayList<>();
    public void addProduct(Product product){
        products.add(product);
    }
    public List<Product> getProducts(){
        return products;
    }
    public void removeProduct(Product product){
        products.remove(product);
    }
}
