package com.example.lab4.Controllers;

import com.example.lab4.Connector.DBConnector;
import com.example.lab4.Model.Info;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class HelloController {

    public HelloController() throws SQLException, ClassNotFoundException {
        bdController = new DBConnector(this);
    }

    public TableView<Info> table;
    @FXML
    private TableColumn<Info, String> idColumn;
    @FXML
    private TableColumn<Info, String> dateColumn;
    @FXML
    private TableColumn<Info, String> pathColumn;
    @FXML
    private TableColumn<Info, String> typeColumn;
    @FXML
    private TableColumn<Info, String> numberColumn;
    @FXML
    private TableColumn<Info, String> driverColumn;

    public ObservableList<Info> listview = FXCollections.observableArrayList();

    public int ID;
    public String date;
    public String path;
    public String type;
    public String number;
    public String driver;
    private final DBConnector bdController;
    @FXML
    public Button Add;
    @FXML
    public Button Change;
    @FXML
    public Button Delete;
    @FXML
    public Button Refresh;
    @FXML
    public Button AllInfo;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        try {
            listview.addAll(bdController.connection());
            for(Info i: listview ){
                System.out.println(i.getId_info());
                System.out.println(i.getDate());
                System.out.println(i.getPath());
                System.out.println(i.getType());
                System.out.println(i.getDriver());
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<Info, String>("id_info"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Info, String>("path"));
        pathColumn.setCellValueFactory(new PropertyValueFactory<Info, String>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Info, String>("type"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<Info, String>("number"));
        driverColumn.setCellValueFactory(new PropertyValueFactory<Info, String>("driver"));

        table.setItems(listview);

        table.getSortOrder().add(idColumn);


       TableView.TableViewSelectionModel<Info> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Info>(){

            @Override
            public void changed(ObservableValue<? extends Info> observableValue, Info oldval, Info newVal) {
                if(newVal != null) {
                    ID = newVal.getId_info();
                    date = newVal.getDate();
                    path = newVal.getPath();
                    type = newVal.getType();
                    number = newVal.getNumber();
                    driver = newVal.getDriver();
                }
            }
        });
    }


    public void onClickRefresh() throws SQLException, ClassNotFoundException {
        listview.clear();
        listview.addAll(bdController.connection());
        table.setItems(listview);
        table.getSortOrder().add(idColumn);
    }

    public void onClickAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/lab4/insert.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Add Element");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e.getMessage());
        }
    }

    public void onClickChange(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            UpDateController.setInfo(ID, date, path, type, number, driver);
            fxmlLoader.setLocation(getClass().getResource("/com/example/lab4/update.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Update Element");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e.getMessage());
        }
    }

    public void onClickDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       if(ID < 1) return;
       DBConnector.deleteInfo(ID);
       ID = 0;
    }
}