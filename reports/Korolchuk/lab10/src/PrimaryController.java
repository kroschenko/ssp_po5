package com.spp.labs.lab10_spp;

import java.io.FilterInputStream;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {
    
    @FXML
    private TableView accountsTable;
    
    @FXML
    private DatePicker filterInput;
    
    @FXML
    private Button showTableButton;
    
    @FXML
    private Button addRowButton;
    
    @FXML
    private Button alterRowButton;
    
    @FXML
    private Button deleteRowButton;
    
    @FXML
    private GridPane  recordForm;
    
    @FXML
    private Label idLabel;
    
    @FXML
    private Label modelLabel;
    
    @FXML
    private Label userNameLabel;
    
    @FXML
    private Label regDateLabel;
    
    @FXML
    private Label idRowLabel;
    
    @FXML
    private Label modelRowLabel;
    
    @FXML
    private Label userNameRowLabel;
    
    @FXML
    private Label regDateRowLabel;
    
    @FXML
    private TableColumn idColumn;
    
    @FXML
    private TableColumn modelColumn;
    
    @FXML
    private TableColumn userNameColumn;
    
    @FXML
    private TableColumn regDateColumn;
    
    private Computer computer;
    private User user;
    private Date regDate;
    
    @FXML
    public void initialize() throws IOException, SQLException {
        accountsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        showTableButtonClicked();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));

        SecondaryController controller = loader.getController();
        //controller.say("Hi");
        
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    
    @FXML
    private void showTableButtonClicked() throws IOException, SQLException {
        LocalDate date = filterInput.getValue();
        
        Statement statement = App.conn.createStatement();
        String sqlCommand;
        if (Objects.isNull(date))
            sqlCommand = "SELECT accounts.id, computers.model, users.name, accounts.register_date FROM accounts INNER JOIN computers ON computers.id = accounts.id_comp INNER JOIN users ON users.id = accounts.id_user";
        else
            sqlCommand = "SELECT accounts.id, computers.model, users.name, accounts.register_date FROM accounts INNER JOIN computers ON computers.id = accounts.id_comp INNER JOIN users ON users.id = accounts.id_user WHERE accounts.register_date = '" + date.toString() + "'";
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        
        while (resultSet.next()) {
            accounts.add(
                new Account(
                    resultSet.getInt(1),
                    0,
                    0,
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4)
                )
            );
        }
        
        accountsTable.setItems(accounts);
        
        idColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("id"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("model"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("userName"));
        regDateColumn.setCellValueFactory(new PropertyValueFactory<Account, Date>("regDate"));
    }
    
    @FXML
    private void addRowButtonClicked() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("secondary.fxml"));
        
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(fxmlLoader.load()));
        
        SecondaryController controller = fxmlLoader.getController();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        Statement statement = App.conn.createStatement();
        String sqlCommand = "SELECT * FROM computers";
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Computer> computers = FXCollections.observableArrayList();
        
        while (resultSet.next()) {
            computers.add(
                new Computer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                )
            );
        }
        
        sqlCommand = "SELECT * FROM users";
        resultSet = statement.executeQuery(sqlCommand);
        ObservableList<User> users = FXCollections.observableArrayList();
        
        while (resultSet.next()) {
            users.add(
                new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                )
            );
        }
        
        controller.computerCombo.setItems(computers);
        controller.userCombo.setItems(users);
        
        Account account = controller.showDialog(stage, null, null, null);
        
        if (account.getModel() == null || account.getUserName() == null || account.getRegDate() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ошибка добавления");
            alert.setHeaderText("");
            alert.setContentText("Должны быть заполнены все поля!");

            alert.showAndWait();
            
            return;
        }
        
        sqlCommand = "INSERT INTO accounts (id_comp, id_user, register_date) VALUES ('" + account.getId_comp() + "', '" + account.getId_user() + "', '" + account.getRegDate() + "')";
        statement.execute(sqlCommand);
        
        showTableButtonClicked();
    }
    
    @FXML
    private void alterRowButtonClicked() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("secondary.fxml"));
        
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(fxmlLoader.load()));
        
        SecondaryController controller = fxmlLoader.getController();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        Account selectedAccount = (Account) accountsTable.getSelectionModel().getSelectedItem();
        Computer selectedComputer = null;
        User selectedUser = null;
        
        Statement statement = App.conn.createStatement();
        String sqlCommand = "SELECT id_comp, id_user FROM accounts WHERE id = '" + selectedAccount.getId() + "'";
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        while (resultSet.next()) {
            selectedAccount.setId_comp(resultSet.getInt(1));
            selectedAccount.setId_user(resultSet.getInt(2));
        }
        
        sqlCommand = "SELECT * FROM computers";
        resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Computer> computers = FXCollections.observableArrayList();
        
        while (resultSet.next()) {
            if (resultSet.getInt(1) == selectedAccount.getId_comp()) {
                selectedComputer = new Computer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                );
            }
            
            computers.add(
                new Computer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                )
            );
        }
        
        sqlCommand = "SELECT * FROM users";
        resultSet = statement.executeQuery(sqlCommand);
        ObservableList<User> users = FXCollections.observableArrayList();
        
        while (resultSet.next()) {
            if (resultSet.getInt(1) == selectedAccount.getId_user()) {
                selectedUser = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                );
            }
            
            users.add(
                new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                )
            );
        }
        
        controller.computerCombo.setItems(computers);
        controller.userCombo.setItems(users);
        
        Account account = controller.showDialog(stage, selectedComputer, selectedUser, selectedAccount.getRegDate().toLocalDate());
        
        if (account.getModel() == null || account.getUserName() == null || account.getRegDate() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ошибка изменения");
            alert.setHeaderText("");
            alert.setContentText("Должны быть заполнены все поля!");

            alert.showAndWait();
            
            return;
        }
        
        sqlCommand = "UPDATE accounts SET id_comp = '" + account.getId_comp() + "', id_user = '" + account.getId_user() + "', register_date = '" + account.getRegDate() + "' WHERE id = '" + selectedAccount.getId() + "'";
        statement.execute(sqlCommand);
        
        showTableButtonClicked();
    }
    
    @FXML
    private void deleteRowButtonClicked() throws IOException, SQLException {
        ObservableList<Account> accounts = accountsTable.getSelectionModel().getSelectedItems();
        
        for (int i = 0; i < accounts.size(); i++) {
            Account account = (Account) accounts.get(i);
            Statement statement = App.conn.createStatement();
            String sqlCommand = "DELETE FROM accounts WHERE id = '" + account.getId() + "'";
            statement.execute(sqlCommand);
        }
        
        showTableButtonClicked();
    }
    
    @FXML
    private void handleRowSelect() {
        Account row = (Account) accountsTable.getSelectionModel().getSelectedItem();
        if (row == null) return;
        
        idRowLabel.setText(String.valueOf(row.getId()));
        modelRowLabel.setText(row.getModel());
        userNameRowLabel.setText(row.getUserName());
        regDateRowLabel.setText(row.getRegDate().toString());
    }
}
