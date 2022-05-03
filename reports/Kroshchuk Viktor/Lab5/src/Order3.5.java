package com.company;
public class Order {
    private int userId;
    private Product product;
    private boolean isPaid;
    public Order(int userId, Product product) {
        this.userId = userId;
        this.product = product;
        this.isPaid = false;
    }
    public void pay() {
        this.isPaid = true;
    }
    public int getUserId() {
        return userId;
    }
    public boolean isPaid() {
        return isPaid;
    }
    @Override
    public String toString() {
        return product +
                ", Куплено=" + isPaid;
    }
}
