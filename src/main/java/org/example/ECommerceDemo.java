package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "Bart Simson");
        User user2 = new User(2, "Lisa Simson");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Laptop", 1199.99, 10);
        Product product2 = new Product(2, "Smartphone", 899.90, 20);
        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addToCart(product1, 2);
        user2.addToCart(product2, 3);

        System.out.println("Initial State:");
        platform.listAvailableProducts();
        platform.listUsers();
        platform.listOrders();

        System.out.println("\nSimulating Orders:");
        platform.createOrder(user1, user1.getCart());
        platform.createOrder(user2, user2.getCart());

        System.out.println("\nSimulating Recommendations:");
        recommendAndDisplay(platform, user1);
        recommendAndDisplay(platform, user2);

        System.out.println("\nFinal State:");
        platform.listAvailableProducts();
        platform.listUsers();
        platform.listOrders();
    }

    public static void displaySortedProducts(ECommercePlatform platform) {
        List<Product> productList = new ArrayList<>(platform.getProducts().values());

        productList.sort(new ProductNameComparator());
        System.out.println("Sorted by Name:");
        productList.forEach(System.out::println);

        Collections.sort(productList);
        System.out.println("\nSorted by Price:");
        productList.forEach(System.out::println);

        productList.sort(new ProductStockComparator());
        System.out.println("\nSorted by Stock:");
        productList.forEach(System.out::println);
    }

    public static void filterProductsByStock(ECommercePlatform platform, int minStock) {
        List<Product> filteredProducts = platform.getProducts().values().stream()
                .filter(product -> product.getStock() >= minStock)
                .collect(Collectors.toList());

        System.out.println("\nProducts with Stock >= " + minStock + ":");
        filteredProducts.forEach(System.out::println);
    }
    private static void recommendAndDisplay(ECommercePlatform platform, User user) {
        List<Product> recommendations = platform.recommendProducts(user);
        System.out.println("Recommendations for User " + user.getUsername() + ":");
        recommendations.forEach(System.out::println);
        System.out.println();
    }
}