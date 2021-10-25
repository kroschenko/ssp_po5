package com.company;

public class Main {

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        Administrator administrator = new Administrator(onlineStore);
        administrator.addProduct("Диван");
        administrator.addProduct("Ноутбук");
        administrator.addProduct("Стул");
        administrator.addProduct("Лампа");
        administrator.addProduct("Телефон");
        administrator.addProduct("Стол");
        Client client1 = new Client(1, onlineStore);
        System.out.println("Все товары: ");
        client1.printProducts();
        client1.addOrder(2).pay();
        client1.addOrder(3);
        client1.addOrder(1).pay();
        System.out.println("\nЗаказы 1 клиента: ");
        client1.printOrders();
        Client client2 = new Client(2, onlineStore);
        client2.addOrder(5).pay();
        client2.addOrder(1).pay();
        System.out.println("\nЗаказы 2 клиента: ");
        client2.printOrders();
        administrator.addToBlackList();
        System.out.println("\nПользователь пытается добавить товар: ");
        client1.addOrder(5).pay();
        client2.addOrder(6).pay();
        System.out.println("\nЗаказы 1 клиента: ");
        client1.printOrders();
        System.out.println("\nЗаказы 2 клиента: ");
        client2.printOrders();
    }
}
