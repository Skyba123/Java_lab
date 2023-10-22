package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopTest {
    private Product product1;
    private Product product2;
    private Cart cart;
    private Order order;

    @Before
    public void setUp() {
        product1 = new Product(1, "Product 1", 10.0);
        product2 = new Product(2, "Product 2", 20.0);
        cart = new Cart();
        order = new Order(1, new ArrayList<>(), "Waiting");
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        assertTrue(cart.getProducts().contains(product1));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.removeProduct(product1);
        assertFalse(cart.getProducts().contains(product1));
    }

    @Test
    public void testPlaceOrder() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        order = new Order(1, new ArrayList<>(cart.getProducts()), "Waiting");
        assertEquals("Waiting", order.getStatus());
    }

    @Test
    public void testOrderStatus() {
        order.setStatus("Done");
        assertEquals("Done", order.getStatus());
    }
}