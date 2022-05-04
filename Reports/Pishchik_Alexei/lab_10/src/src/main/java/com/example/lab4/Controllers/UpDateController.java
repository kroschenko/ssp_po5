package com.example.lab4.Controllers;

import com.example.lab4.Connector.DBConnector;
import com.example.lab4.Model.Partments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpDateController {
    @FXML
    public Button bottonOk;
    @FXML
    public TextField Name;
    @FXML
    public ComboBox<String> Company;
    @FXML
    public ComboBox<String> LastName;
    @FXML
    public ComboBox<String> Number;
    @FXML
    public ComboBox<String> Adress;


    public static int id;
    public static String company;
    public static String name;
    public static String branches;
    public static String countcomp;
    public static String adress;

    Partments partments;

    public static void setPartments(int ID, String Company, String Name, String Branches, String Countcomp, String Adress) {
        id = ID;
        company = Company;
        name = Name;
        branches = Branches;
        countcomp = Countcomp;
        adress = Adress;
    }

    @FXML
    void initialize() {
        try {
            Name.setText(name);

            ObservableList<String> CompanyLIST = FXCollections.observableArrayList(DBConnector.getCompany());
            Company.setItems(CompanyLIST);
            Company.setValue(company);

            ObservableList<String> LastNameLIST = FXCollections.observableArrayList(DBConnector.getLastName());
            LastName.setItems(LastNameLIST);
            LastName.setValue(branches);

            ObservableList<String> AdressLIST = FXCollections.observableArrayList(DBConnector.getAdress());
            Adress.setItems(AdressLIST);
            Adress.setValue(adress);

            ObservableList<String> NumberLIST = FXCollections.observableArrayList(DBConnector.getNumbers());
            Number.setItems(NumberLIST);
            Number.setValue(countcomp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onClickUpdate(ActionEvent actionEvent) throws ClassNotFoundException {
        if(Company.getValue() == null || Name.getText() == null ||
                LastName.getValue() == null || Number.getValue() == null || Adress.getValue() == null) return;
        partments = new Partments(id,Company.getValue(), Name.getText(), LastName.getValue(), Number.getValue(), Adress.getValue());
        DBConnector.updatePartments(partments);
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        stage.close();
    }
}
