package com.example.lab4.Controllers;

import com.example.lab4.Connector.DBConnector;
import com.example.lab4.Model.Info;
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
    public TextField Date;
    @FXML
    public ComboBox<String> Path;
    @FXML
    public ComboBox<String> Type;
    @FXML
    public ComboBox<String> Number;
    @FXML
    public ComboBox<String> Driver;
    Info partments;

    @FXML
    void initialize() {
        try {
            ObservableList<String> PathLIST = FXCollections.observableArrayList(DBConnector.getPath());
            Path.setItems(PathLIST);

            ObservableList<String> TypeLIST = FXCollections.observableArrayList(DBConnector.getType());
            Type.setItems(TypeLIST);

            ObservableList<String> NumberLIST = FXCollections.observableArrayList(DBConnector.getNumber());
            Number.setItems(NumberLIST);

            ObservableList<String> DriverLIST = FXCollections.observableArrayList(DBConnector.getDriver());
            Driver.setItems(DriverLIST);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onClickInsert(ActionEvent actionEvent) throws ClassNotFoundException {
        if(Path.getValue() == null || Type.getValue() == null ||
                Number.getValue() == null || Driver.getValue() == null || Date.getText() == null) return;
        partments = new Info(10, Date.getText(),Path.getValue(), Type.getValue(), Number.getValue(), Driver.getValue());
        DBConnector.insertInfo(partments);
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        stage.close();
    }
}
