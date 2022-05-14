package com.spp.labs.lab10_spp;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


public class Account {
    private SimpleIntegerProperty id;
    private int id_comp;
    private int id_user;
    private SimpleStringProperty model;
    private SimpleStringProperty userName;
    private SimpleObjectProperty<Date> regDate;

    public Account(int id, int id_comp, int id_user, String model, String userName, Date regDate) {
        this.id = new SimpleIntegerProperty(id);
        this.id_comp = id_comp;
        this.id_user = id_user;
        this.model = new SimpleStringProperty(model);
        this.userName = new SimpleStringProperty(userName);
        this.regDate = new SimpleObjectProperty<>(regDate);
    }

    public int getId() {
        return id.get();
    }

    public int getId_comp() {
        return id_comp;
    }

    public int getId_user() {
        return id_user;
    }

    public String getModel() {
        return model.get();
    }

    public String getUserName() {
        return userName.get();
    }

    public Date getRegDate() {
        return regDate.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setModel(String value) {
        model.set(value);
    }

    public void setUserName(String value) {
        userName.set(value);
    }

    public void setRegDate(Date value) {
        regDate.set(value);
    }
}
