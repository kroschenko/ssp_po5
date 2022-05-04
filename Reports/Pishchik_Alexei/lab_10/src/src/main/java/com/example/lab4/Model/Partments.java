package com.example.lab4.Model;

public class Partments {
    int id;
    String CompanyName;
    String Name;
    String LName;
    String Number;
    String Adress;

    public Partments(int id, String companyName, String name, String LName, String number, String adress) {
        this.id = id;
        this.CompanyName = companyName;
        this.Name = name;
        this.LName = LName;
        this.Number = number;
        this.Adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String countComp) {
        Number = countComp;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
}
