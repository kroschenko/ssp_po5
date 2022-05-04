package com.example.client;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class ClientGUI {
    private String ip;
    private int port;
    private Client client;
    private String username;

    @FXML
    public TextField name;

    @FXML
    public TextField textNum;
    @FXML
    public TextField textIp;
    @FXML
    public TextField textPort;

    @FXML
    public Button take;

    @FXML
    public Button connected;

    @FXML
    public Text result;

    @FXML
    public Text place;

    @FXML
    public Text size;

    @FXML
    protected void takeClick() {
        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        client.send(false);
                        return null;
                    }
                };
            }
        };
        service.start();
    }

    @FXML
    protected void connectedClick() throws IOException {

        if(name.getText().equals("") || textIp.getText().equals("")
                || textPort.getText().equals("")) {
            return;
        }
        ip = textIp.getText();
        try {
            port = Integer.parseInt(textPort.getText());
        } catch (NumberFormatException e) {
            result.setText("Not correct port!");
        }
        try {
        Socket socket = new Socket(ip, port);
            username = name.getText();
            client = new Client(socket, username, this);
            Service<Void> service = new Service<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            client.listenForMessage();
                            client.sendName();
                            return null;
                        }
                    };
                }
            };
            service.start();
        } catch (IOException e) {
            result.setText("Connected Failed!");
        }
    }
}