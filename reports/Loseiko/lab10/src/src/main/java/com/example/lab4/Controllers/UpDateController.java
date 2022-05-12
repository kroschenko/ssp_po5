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

public class UpDateController {
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


    public static int id;
    public static String date;
    public static String path;
    public static String type;
    public static String number;
    public static String driver;

    Info partments;

    public static void setInfo(int ID, String Date, String Path, String Type, String Number, String Driver) {
        id = ID;
        date = Date;
        path = Path;
        type = Type;
        number = Number;
        driver = Driver;
    }

    @FXML
    void initialize() {
        try {
            Date.setText(date);

            ObservableList<String> PathLIST = FXCollections.observableArrayList(DBConnector.getPath());
            Path.setItems(PathLIST);
            Path.setValue(path);

            ObservableList<String> TypeLIST = FXCollections.observableArrayList(DBConnector.getType());
            Type.setItems(TypeLIST);
            Type.setValue(type);

            ObservableList<String> NumberLIST = FXCollections.observableArrayList(DBConnector.getNumber());
            Number.setItems(NumberLIST);
            Number.setValue(number);

           ObservableList<String> DriverLIST = FXCollections.observableArrayList(DBConnector.getDriver());
            Driver.setItems(DriverLIST);
            Driver.setValue(driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onClickUpdate(ActionEvent actionEvent) throws ClassNotFoundException {
        if(Path.getValue() == null || Type.getValue() == null ||
                Number.getValue() == null || Driver.getValue() == null || Date.getText() == null) return;
        partments = new Info(id,Path.getValue(), Date.getText(), Type.getValue(), Number.getValue(), Driver.getValue());
        DBConnector.updateInfo(partments);
        Stage stage = (Stage) bottonOk.getScene().getWindow();
        stage.close();
    }
}
