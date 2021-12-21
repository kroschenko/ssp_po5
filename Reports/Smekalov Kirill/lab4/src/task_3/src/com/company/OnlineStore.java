package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnlineStore {
    private List<Product> productList;
    private List<Order> orderList;
    private List<Integer> blackList;
    public OnlineStore() {
        this.productList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.blackList = new ArrayList<>();
    }
    private boolean isInBlackList(int userId) {
        return blackList.contains(userId);
    }
    public void printProducts() {
        productList.forEach(System.out::println);
    }
    public void printUserOrders(int userId) {
        orderList.stream().filter(order -> order.getUserId() ==
                userId).forEach(System.out::println);
    }
    public void addToBlackList() {
        blackList = orderList.stream().filter(order ->
                !order.isPaid()).map(Order::getUserId).collect(Collectors.toList());
    }
    public void addProduct(String productName) {
        productList.add(new Product(productList.size() + 1, productName));
    }
    public Order addOrder(int userId, int productId) {
        if (!isInBlackList(userId)) {
            Order order = new Order(userId, productList.get(--productId));
            orderList.add(order);
            return order;
        } else {
            System.out.println("Sorry, but you are in the blacklist");
            return null;
        }
    }
}
