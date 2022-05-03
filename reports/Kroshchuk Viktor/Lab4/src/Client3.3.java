package com.company;
public class Client {
    private int clientId;
    private OnlineStore onlineStore;
    public Client(int clientId, OnlineStore onlineStore) {
        this.clientId = clientId;
        this.onlineStore = onlineStore;
    }
    public void printProducts() {
        onlineStore.printProducts();
    }
    public void printOrders() {
        onlineStore.printUserOrders(clientId);
    }
    public Order addOrder(int productId) {
        return onlineStore.addOrder(clientId, productId);
    }
}
