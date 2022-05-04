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

import java.sql.SQLException;


public class FromInsertDBController {

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
    Partments partments;

    @FXML
    void initialize() throws ClassNotFoundException {
        try {
            ObservableList<String> CompanyLIST = FXCollections.observableArrayList(DBConnector.getCompany());
            Company.setItems(CompanyLIST);

            ObservableList<String> LastNameLIST = FXCollections.observableArrayList(DBConnector.getLastName());
            LastName.setItems(LastNameLIST);

            ObservableList<String> AdressLIST = FXCollections.observableArrayList(DBConnector.getAdress());
            Adress.setItems(AdressLIST);

            ObservableList<String> NumberLIST = FXCollections.observableArrayList(DBConnector.getNumbers());
            Number.setItems(NumberLIST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onClickInsert(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(Company.getValue() == null || Name.getText() == null ||
                LastName.getValue() == null || Number.getValue() == null || Adress.getValue() == null) return;
        partments = new Partments(3,Company.getValue(), Name.getText(), LastName.getValue(), Number.getValue(), Adress.getValue());
        DBConnector.insertPartments(partments);
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        stage.close();
    }
}
