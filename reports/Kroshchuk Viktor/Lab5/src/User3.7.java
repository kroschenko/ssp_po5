package com.company;
public class User {
    private OnlineStore onlineStore;
    public User(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }
    public OnlineStore getOnlineStore() {
        return onlineStore;
    }
    public void setOnlineStore(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }
}
