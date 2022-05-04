package com.example.lab4.Controllers;

import com.example.lab4.Connector.DBConnector;
import com.example.lab4.Model.Partments;
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

    public TableView<Partments> table;
    @FXML
    private TableColumn<Partments, String> idColumn;
    @FXML
    private TableColumn<Partments, String> nameColumn;
    @FXML
    private TableColumn<Partments, String> nameCompanyColumn;
    @FXML
    private TableColumn<Partments, String> lNameColumn;
    @FXML
    private TableColumn<Partments, String> NumberColumn;
    @FXML
    private TableColumn<Partments, String> AdressColumn;

    public ObservableList<Partments> listview = FXCollections.observableArrayList();

    public int ID;
    public String company;
    public String name;
    public String branches;
    public String countcomp;
    public String adress;
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
    void initialize() {
        try {
            listview.addAll(bdController.connection());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<Partments, String>("id"));
        nameCompanyColumn.setCellValueFactory(new PropertyValueFactory<Partments, String>("CompanyName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Partments, String>("Name"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<Partments, String>("LName"));
        NumberColumn.setCellValueFactory(new PropertyValueFactory<Partments, String>("Number"));
        AdressColumn.setCellValueFactory(new PropertyValueFactory<Partments, String>("Adress"));

        table.setItems(listview);

        table.getSortOrder().add(idColumn);


        TableView.TableViewSelectionModel<Partments> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Partments>(){

            @Override
            public void changed(ObservableValue<? extends Partments> observableValue, Partments oldval, Partments newVal) {
                if(newVal != null) {
                    ID = newVal.getId();
                    company = newVal.getCompanyName();
                    name = newVal.getName();
                    branches = newVal.getLName();
                    countcomp = newVal.getNumber();
                    adress = newVal.getAdress();
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
            UpDateController.setPartments(ID, company, name, branches, countcomp, adress);
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
        DBConnector.deletePartments(ID);
        onClickRefresh();
        ID = 0;
    }

    public void onClickAllInfo(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            if(ID < 1) return;
            System.out.println(ID);
            DBConnector.getAllInfo(ID);
            fxmlLoader.setLocation(getClass().getResource("/com/example/lab4/Info.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("All Info Element");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e.getMessage());
        }
    }
}