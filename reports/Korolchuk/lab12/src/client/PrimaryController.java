package com.labs.spp.lab12_spp_client;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class PrimaryController implements Initializable {

    @FXML
    private ListView<String> chatsList;
    
    @FXML
    private TextArea chatStory;
    
    @FXML
    private TextField clientMessage;
    
    public static ClientSomthing client;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> chats = FXCollections.observableArrayList();
        chats.add("Общий чат");
        chatsList.setItems(chats);
        
        MultipleSelectionModel<String> chatsListSelectionModel = chatsList.getSelectionModel();
        chatsListSelectionModel.select("Общий чат");
        
        clientMessage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    if (clientMessage.getText().equals(""))
                        return;
                    
                    LocalDateTime now = LocalDateTime.now();
                    String whom = chatsList.getSelectionModel().getSelectedItem();
                    String msg = clientMessage.getText();

                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("what", "messageSent");
                    jsonObj.put("when", now.format(formatter));
                    jsonObj.put("whom", whom);
                    jsonObj.put("msg", msg);
                    client.send(jsonObj.toString());

                    chatStory.setText("[" + now.format(formatter) + "] " + client.getNickname() + ": " + msg + "\n" + chatStory.getText());
                    clientMessage.clear();
                }
            }
        });
    }
    
    public void chatChanged() {
        chatStory.clear();
        
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("what", "chatChanged");
        jsonObj.put("chat", chatsList.getSelectionModel().getSelectedItem());
        client.send(jsonObj.toString());
    }

    public TextArea getChatStory() {
        return chatStory;
    }

    public ListView<String> getChatsList() {
        return chatsList;
    }

    public TextField getClientMessage() {
        return clientMessage;
    }

    public void setChatStory(TextArea chatStory) {
        this.chatStory = chatStory;
    }

    public void setChatsList(ListView<String> chatsList) {
        this.chatsList = chatsList;
    }

    public void setClientMessage(TextField clientMessage) {
        this.clientMessage = clientMessage;
    }
}
