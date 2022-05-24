package com.labs.spp.lab12_spp_client;

import java.io.IOException;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SecondaryController implements Initializable {

    @FXML
    public TextField clientNicknameInput;
    
    @FXML
    public Button submitButton;
    
    private String clientNickname;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public String showDialog(Stage stage) throws IOException {
        submitButton.setOnAction(e -> {
            if (clientNicknameInput.getText() != null && clientNicknameInput.getText().equals(""))
                clientNicknameInput.setText("Введите ник!!!");
            else {
                clientNickname = clientNicknameInput.getText();
                stage.close();
            }
        });
        
        stage.showAndWait();
        
        return clientNickname;
    }
}