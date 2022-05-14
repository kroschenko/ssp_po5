package com.spp.labs.lab10_spp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class User {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleIntegerProperty age;

    public User(int id, String name, String surname, int age) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.age = new SimpleIntegerProperty(age);
    }

    public int getId() {
        return id.get();
    }

    public int getAge() {
        return age.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public String getName() {
        return name.get();
    }

    public void setId(int value) {
        this.id.set(value);
    }

    public void setAge(int value) {
        this.age.set(value);
    }

    public void setSurname(String value) {
        this.surname.set(value);
    }

    public void setName(String value) {
        this.name.set(value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(getId()) + " / " + getName() + " / " + getSurname() + " / " + String.valueOf(getAge());
    }
}
