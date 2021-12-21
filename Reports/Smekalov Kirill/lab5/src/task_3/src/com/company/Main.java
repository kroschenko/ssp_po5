package com.company;

public class Main {
    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        Administrator administrator = new Administrator(onlineStore);
        administrator.addProduct("Sofa");
        administrator.addProduct("Laptop");
        administrator.addProduct("Chair");
        administrator.addProduct("Lamp");
        administrator.addProduct("Phone");
        administrator.addProduct("Table");
        Client client1 = new Client(1, onlineStore);
        System.out.println("All products:");
        client1.printProducts();
        client1.addOrder(2).pay();
        client1.addOrder(3);
        client1.addOrder(1).pay();
        System.out.println("\nUser's orders:");
        client1.printOrders();
        Client client2 = new Client(2, onlineStore);
        client2.addOrder(5).pay();
        client2.addOrder(1).pay();
        administrator.addToBlackList();
        System.out.println("\nUser is trying to add order:");
        client1.addOrder(5);
        client2.addOrder(6).pay();
    }
}