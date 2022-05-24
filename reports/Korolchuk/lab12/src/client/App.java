package com.labs.spp.lab12_spp_client;


import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.scene.Parent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.WindowEvent;
import org.json.JSONArray;
import org.json.JSONObject;

class ClientSomthing {
    
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String addr;
    private int port;
    private String nickname;
    private PrimaryController primaryController = App.getPrimaryController();
    private SecondaryController secondaryController;
    private Stage secondaryControllerStage;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
    
    public ClientSomthing(String addr, int port) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(App.class.getResource("secondary.fxml"));
            secondaryControllerStage = new Stage(StageStyle.DECORATED);
            secondaryControllerStage.setScene(new Scene(fxmlLoader2.load()));
            secondaryController = fxmlLoader2.getController();

            this.addr = addr;
            this.port = port;
            
            try {
                this.socket = new Socket(addr, port);
            } catch (IOException e) {
                System.err.println("Socket failed");
            }
            
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.pressNickname();
                new ReadMsg().start();
            } catch (IOException e) {
                ClientSomthing.this.downService();
            }
        } catch (IOException ignored) {
        }
    }
    
    private void pressNickname() throws IOException {
        nickname = secondaryController.showDialog(secondaryControllerStage);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("what", "create");
        jsonObj.put("nick", nickname);
        send(jsonObj.toString());
    }
    
    public void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }
    
    private class ReadMsg extends Thread {
        
        @Override
        public void run() {
            String str;
            System.out.println("Hello from client " + nickname);
            
            try {
                while (true) {
                    str = in.readLine();
                    JSONObject jsonObj = new JSONObject(str);
                    
                    switch (jsonObj.getString("what")) {
                        case "getMessageStory":
                            
                            Platform.runLater(() -> {
                                JSONArray msgStory = jsonObj.getJSONArray("msgStory");
                                for (int i = 0; i < msgStory.length(); i++) {
                                    JSONObject msgStoryItem = msgStory.getJSONObject(i);
                                    primaryController.getChatStory().setText("[" + msgStoryItem.getString("date") + "] " + msgStoryItem.getString("nick") + ": " + msgStoryItem.getString("msg") + "\n" + primaryController.getChatStory().getText());
                                }
                            });
                            
                            break;
                        case "clientInvited":
                            
                            Platform.runLater(() -> {
                                ListView<String> chatsList = primaryController.getChatsList();
                                ObservableList<String> its = chatsList.getItems();
                                its.add(jsonObj.getString("nick"));
                                chatsList.setItems(its);
                            });
                            
                            break;
                        case "addClients":

                            Platform.runLater(() -> {
                                ListView<String> chatsList = primaryController.getChatsList();
                                ObservableList<String> its = chatsList.getItems();

                                JSONArray jsonArr = jsonObj.getJSONArray("clients");

                                for (int i = 0; i < jsonArr.length(); i++) {
                                    its.add(jsonArr.getString(i));
                                }

                                chatsList.setItems(its);
                            });
                            
                            break;
                        case "messageSent":

                            Platform.runLater(() -> {
                                TextArea chatStory = primaryController.getChatStory();

                                if (primaryController.getChatsList().getSelectionModel().getSelectedItem().equals("Общий чат") && jsonObj.getString("whom").equals("Общий чат"))
                                    chatStory.setText("[" + jsonObj.get("when") + "] " + jsonObj.getString("who") + ": " + jsonObj.getString("msg") + "\n" + chatStory.getText());
                                else if (primaryController.getChatsList().getSelectionModel().getSelectedItem().equals(jsonObj.getString("who")) && jsonObj.getString("whom").equals(nickname))
                                    chatStory.setText("[" + jsonObj.get("when") + "] " + jsonObj.getString("who") + ": " + jsonObj.getString("msg") + "\n" + chatStory.getText());
                            });
                            
                            break;
                        case "close":
                            
                            Platform.runLater(() -> {
                                ListView<String> chatsList = primaryController.getChatsList();
                                ObservableList<String> its = chatsList.getItems();
                                its.remove(jsonObj.getString("chat"));
                                chatsList.setItems(its);
                            });
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                    
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientSomthing.this.downService();
            }
        }
    }
    
    public void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }

    public Socket getSocket() {
        return socket;
    }

    public String getAddr() {
        return addr;
    }

    public BufferedReader getIn() {
        return in;
    }

    public String getNickname() {
        return nickname;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public int getPort() {
        return port;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setOut(BufferedWriter out) {
        this.out = out;
    }

    public void setPort(int port) {
        this.port = port;
    }
}


public class App extends Application {

    private static PrimaryController primaryController;
    private static Scene scene;
    public static String ipAddr = "localhost";
    public static int port = 8080;
    
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        primaryController = fxmlLoader.getController();
        
        ClientSomthing client = new ClientSomthing(ipAddr, port);
        PrimaryController.client = client;
        
        stage.setTitle(PrimaryController.client.getNickname());
        stage.show();
        
        primaryController.chatChanged();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("what", "close");
                client.send(jsonObj.toString());
                primaryController.client.downService();
                stage.close();
            }
        });
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }

    public static PrimaryController getPrimaryController() {
        return primaryController;
    }

}