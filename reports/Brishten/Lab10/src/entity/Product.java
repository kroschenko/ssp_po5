package com.company.entity;
import javafx.beans.property.*;

public class Product {
    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private Manufacturer manufacturer;

    public Product(int ID, String name, double price, Manufacturer manufacturer) {
        this.ID = new SimpleIntegerProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.manufacturer = manufacturer;
    }

    public int getID() {return ID.get();}
    public String getName() {return name.get();}
    public double getPrice() {return price.get();}
    public Manufacturer getManufacturer() {return this.manufacturer;}

    public void setID(int value) {ID.set(value);}
    public void setName(String value) {name.set(value);}
    public void setPrice(double value) {price.set(value);}
    public void setManufacturer(Manufacturer manufacturer) {this.manufacturer = manufacturer;}
}
