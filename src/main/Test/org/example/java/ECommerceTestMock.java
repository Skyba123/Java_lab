package org.example.java;

import org.example.Cart;
import org.example.Order;
import org.example.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ECommerceTestMock {

    @Mock
    private Product product1;
    @Mock
    private Product product2;

    private Cart cart;
    private Order order;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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