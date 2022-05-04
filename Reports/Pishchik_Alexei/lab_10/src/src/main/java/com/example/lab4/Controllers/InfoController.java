package com.example.lab4.Controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class InfoController {
    public Text idGUI;
    public Text companyGUI;
    public Text nameGUI;
    public Text branchesGUI;
    public Text countcompGUI;
    public Text addressGUI;
    public Text nameofficeGUI;
    public Text fnameGUI;

    public static int id;
    public static String company;
    public static String name;
    public static String branches;
    public static String countcomp;
    public static String address;
    public static String nameoffice;
    public static String fname;


    public static void getData(int ID, String Company, String Name, String Branches, String Countcomp, String Adress, String Nameoffice, String Fname) {
        id = ID;
        company = Company;
        name = Name;
        branches = Branches;
        countcomp = Countcomp;
        address = Adress;
        nameoffice = Nameoffice;
        fname = Fname;
    }

    @FXML
    void initialize() throws ClassNotFoundException {
        try {
            idGUI.setText(String.valueOf(id));
            companyGUI.setText(company);
            nameGUI.setText(name);
            branchesGUI.setText(branches);
            countcompGUI.setText(countcomp);
            addressGUI.setText(address);
            nameofficeGUI.setText(nameoffice);
            fnameGUI.setText(fname);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
