package com.company;
public class Administrator {
    private OnlineStore onlineStore;
    public Administrator(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }
    public void addProduct(String productName) {
        onlineStore.addProduct(productName);
    }
    public void addToBlackList() {
        onlineStore.addToBlackList();
    }
}
