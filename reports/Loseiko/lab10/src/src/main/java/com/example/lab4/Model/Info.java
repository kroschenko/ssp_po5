package com.example.lab4.Model;

public class Info {
    int id_info;
    String date;
    String number;
    String path;
    String type;
    String driver;

    public Info(int id_info, String date, String path, String trainType,String number, String trainDriver) {
        this.id_info = id_info;
        this.date=date;
        this.number=number;
        this.path=path;
        this.type=trainType;
        this.driver=trainDriver;
    }

    public int getId_info() {
        return id_info;
    }

    public void setId_info(int id_info) {
        this.id_info = id_info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
