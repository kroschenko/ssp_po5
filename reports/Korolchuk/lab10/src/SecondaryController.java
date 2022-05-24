package com.spp.labs.lab10_spp;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SecondaryController {
    
    @FXML
    public ComboBox computerCombo;
    
    @FXML
    public ComboBox userCombo;
    
    @FXML
    public DatePicker regDateInput;
    
    @FXML
    public Button submitButton;
    
    public Computer computer = null;
    public User user = null;
    public Date regDate = null;

    public Account showDialog(Stage stage, Computer computerComboValue, User userComboValue, LocalDate regDateInputValue) throws IOException, SQLException {
        computerCombo.setValue(computerComboValue);
        userCombo.setValue(userComboValue);
        regDateInput.setValue(regDateInputValue);
        
        submitButton.setOnAction(e -> {
            if (computerCombo.getValue() != null)
                computer = (Computer) computerCombo.getValue();
            if (userCombo.getValue() != null)
                user = (User) userCombo.getValue();
            if (regDateInput.getValue() != null)
                regDate = Date.valueOf(regDateInput.getValue());
            stage.close();
        });
        
        stage.showAndWait();
        
        if (computer == null || user == null || regDate == null) {
            return new Account(0, 0, 0, null, null, null);
        }
        
        return new Account(0, computer.getId(), user.getId(), computer.getModel(), user.getName(), regDate);
    }
}