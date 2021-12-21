package com.company;

public class Client extends User {
    private int clientId;
    public Client(int clientId, OnlineStore onlineStore) {
        super(onlineStore);
        this.clientId = clientId;
    }
    public void printProducts() {
        getOnlineStore().printProducts();
    }
    public void printOrders() {
        getOnlineStore().printUserOrders(clientId);
    }
    public Order addOrder(int productId) {
        return getOnlineStore().addOrder(clientId, productId);
    }
}
