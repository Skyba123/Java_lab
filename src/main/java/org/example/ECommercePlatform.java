package org.example;

import java.util.*;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;


    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(User user, Map<Product, Integer> orderDetails) {
        int orderId = orders.size() + 1;
        Order order = new Order(orderId, user.getId(), orderDetails);
        orders.put(orderId, order);

        updateProductStocks(orderDetails);
    }

    private void updateProductStocks(Map<Product, Integer> orderDetails) {
        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            Product product = entry.getKey();
            int quantityOrdered = entry.getValue();
            int currentStock = product.getStock();
            product.setStock(currentStock - quantityOrdered);
        }
    }

    public String listAvailableProducts() {
        StringBuilder result = new StringBuilder("Available Products:\n");
        for (Product product : products.values()) {
            result.append(product).append("\n");
        }
        return result.toString();
    }

    public void listUsers() {
        System.out.println("Users:");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void listOrders() {
        System.out.println("Orders:");
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }
    public Map<Integer, Product> getProducts() {
        return products;
    }

    public List<Product> recommendProducts(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        List<Product> recommendedProducts = new ArrayList<>();

        Map<Product, Integer> userCart = user.getCart();

        List<Order> userOrders = getUserOrders(user);


        for (Order order : userOrders) {
            for (Map.Entry<Product, Integer> orderItem : order.getOrderDetails().entrySet()) {
                Product orderedProduct = orderItem.getKey();
                int orderedQuantity = orderItem.getValue();
                int userCartQuantity = userCart.getOrDefault(orderedProduct, 0);

                if (userCartQuantity < orderedQuantity && orderedProduct.getStock() > orderedQuantity - userCartQuantity) {
                    recommendedProducts.add(orderedProduct);
                }
            }
        }

        for (User otherUser : users.values()) {
            if (!otherUser.equals(user)) {
                for (Map.Entry<Product, Integer> cartItem : otherUser.getCart().entrySet()) {
                    Product cartProduct = cartItem.getKey();
                    int cartQuantity = cartItem.getValue();
                    int userCartQuantity = userCart.getOrDefault(cartProduct, 0);

                    if (userCartQuantity < cartQuantity && cartProduct.getStock() > cartQuantity - userCartQuantity) {
                        recommendedProducts.add(cartProduct);
                    }
                }
            }
        }

        return recommendedProducts;
    }

    private List<Order> getUserOrders(User user) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getUserId() == user.getId()) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer,Order> getOrders() {
        return orders;
    }
}
