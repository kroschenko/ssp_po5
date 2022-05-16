package com.company.entity;
import javafx.beans.property.*;

public class Manufacturer {
    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;
    private SimpleStringProperty establishDate;

    public Manufacturer(int ID, String name, String establishDate) {
        this.ID = new SimpleIntegerProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.establishDate = new SimpleStringProperty(establishDate);
    }

    public int getID() {return ID.get();}
    public String getName() {return name.get();}
    public String getEstablishDate() {return establishDate.get();}

    public void setID(int value) {ID.set(value);}
    public void setName(String value) {name.set(value);}
    public void setEstablishDate(String value) {establishDate.set(value);}
}
