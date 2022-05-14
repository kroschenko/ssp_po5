package com.spp.labs.lab10_spp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Computer {
    private SimpleIntegerProperty id;
    private SimpleStringProperty os;
    private SimpleStringProperty model;
    private SimpleIntegerProperty life_time;

    public Computer(int id, String os, String model, int life_time) {
        this.id = new SimpleIntegerProperty(id);
        this.os = new SimpleStringProperty(os);
        this.model = new SimpleStringProperty(model);
        this.life_time = new SimpleIntegerProperty(life_time);
    }

    public int getId() {
        return id.get();
    }

    public int getLife_time() {
        return life_time.get();
    }

    public String getModel() {
        return model.get();
    }

    public String getOs() {
        return os.get();
    }

    public void setId(int value) {
        this.id.set(value);
    }

    public void setLife_time(int value) {
        this.life_time.set(value);
    }

    public void setModel(String value) {
        this.model.set(value);
    }

    public void setOs(String value) {
        this.os.set(value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(getId()) + " / " + getOs() + " / " + getModel() + " / " + String.valueOf(getLife_time());
    }
}
