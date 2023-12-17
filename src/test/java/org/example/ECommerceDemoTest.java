package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ECommerceDemoTest {
    private ECommercePlatform platform;
    @Before
    public void setUp() {
        platform = new ECommercePlatform();
    }
    @Test
    public void testProductSortingByPrice() {
        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Smartphone", 499.99, 20);

        int result = product1.compareTo(product2);

        assertEquals("Sorting by price failed", 1, result);
    }
    @Test
    public void testAddToCart() {
        User user = new User(1, "Isagi Yoichi");
        Product product = new Product(1, "Laptop", 999.99, 10);

        user.addToCart(product, 2);

        assertEquals("Adding to cart failed", 2, user.getCart().get(product).intValue());
    }
    @Test
    public void testAddUser() {
        ECommercePlatform platform = new ECommercePlatform();
        User user = new User(1, "Serhii Skyba");

        platform.addUser(user);

        assertEquals("Adding user failed", user, platform.getUsers().get(1));
    }
    @Test
    public void testCalculateTotalPrice() {
        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Smartphone", 499.99, 20);

        Map<Product, Integer> orderDetails;
        orderDetails = new HashMap<>();
        orderDetails.put(product1, 2);
        orderDetails.put(product2, 1);

        Order order = new Order(1, 1, orderDetails);

        double totalPrice = order.calculateTotalPrice();

        assertEquals("Calculating total price failed", 2499.97, totalPrice, 0.01);
    }
    @Test
    public void testCreateOrder() {
        ECommercePlatform platform = new ECommercePlatform();
        User user = new User(1, "Bart Simson");
        Product product1 = new Product(1, "Laptop", 999.99, 10);

        platform.addUser(user);
        platform.addProduct(product1);

        Map<Product, Integer> orderDetails = new HashMap<>();
        orderDetails.put(product1, 2);

        platform.createOrder(user, orderDetails);

        assertEquals(1, platform.getOrders().size());

        assertEquals(8, product1.getStock());
    }
    @Test
    public void testListAvailableProducts() {
        ECommercePlatform platform = new ECommercePlatform();
        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Smartphone", 499.99, 5);

        platform.addProduct(product1);
        platform.addProduct(product2);

        String availableProducts = platform.listAvailableProducts();

        System.out.println(availableProducts);

        assertNotNull(availableProducts);

        assertTrue(availableProducts.contains("Laptop"));
        assertTrue(availableProducts.contains("Smartphone"));
    }
    @Test
    public void testRecommendProducts() {
        User user = new User(1, "Bart Simson");
        platform.addUser(user);

        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Smartphone", 499.99, 20);
        platform.addProduct(product1);
        platform.addProduct(product2);

        Map<Product, Integer> userCart = new HashMap<>();
        userCart.put(product1, 2);
        user.setCart(userCart);

        Order order = new Order(1, user.getId(), Map.of(product2, 1));
        platform.createOrder(user, order.getOrderDetails());

        List<Product> recommendedProducts = platform.recommendProducts(user);

        assertEquals(1, recommendedProducts.size());
        assertEquals(product2, recommendedProducts.get(0));
    }

}