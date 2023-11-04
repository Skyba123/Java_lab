package org.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ECommerceTest {
    @Mock
    private Product product1;

    @Mock
    private Product product2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Define the behavior of mock products
        when(product1.getId()).thenReturn(1);
        when(product1.getName()).thenReturn("Product 1");
        when(product1.getPrice()).thenReturn(10.0);

        when(product2.getId()).thenReturn(2);
        when(product2.getName()).thenReturn("Product 2");
        when(product2.getPrice()).thenReturn(20.0);
    }

    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        List<Product> productsInCart = cart.getProducts();
        assertEquals(2, productsInCart.size());
        assertTrue(productsInCart.contains(product1));
        assertTrue(productsInCart.contains(product2));
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        List<Product> productsInCart = cart.getProducts();
        assertEquals(1, productsInCart.size());
        assertFalse(productsInCart.contains(product1));
        assertTrue(productsInCart.contains(product2));
    }

    @Test
    public void testOrderStatus() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Order order = new Order(1, products, "Waiting");
        assertEquals(1, order.getOrderId());
        assertEquals(products, order.getProducts());
        assertEquals("Waiting", order.getStatus());

        // Change order status and verify
        order.setStatus("Done");
        assertEquals("Done", order.getStatus());
    }
}