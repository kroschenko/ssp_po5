package com.labs.spp.lab12_spp_server;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


class ServerSomthing extends Thread {
    
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String nickName;
    
    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        start();
    }
    
    @Override
    public void run() {
        String jsonStr;
        JSONObject jsonObj;
        
        try {
            try {
                while (true) {
                    jsonStr = in.readLine();
                    jsonObj = new JSONObject(jsonStr);
                    
                    switch (jsonObj.getString("what")) {
                        case "create":
                            this.nickName = jsonObj.getString("nick");
                            
                            jsonObj = new JSONObject();
                            JSONObject jsonObj2 = new JSONObject();
                            JSONArray jsonArr2 = new JSONArray();
                            
                            jsonObj.put("what", "clientInvited");
                            jsonObj.put("nick", this.nickName);
                            
                            for (ServerSomthing vr : Server.serverList) {
                                if (vr != this) {
                                    jsonArr2.put(vr.nickName);
                                    vr.send(jsonObj.toString());
                                }
                            }
                            
                            jsonObj2.put("what", "addClients");
                            jsonObj2.put("clients", jsonArr2);

                            send(jsonObj2.toString());
                            
                            break;
                        case "messageSent":
                            
                            Statement statement = Server.conn.createStatement();
                            String sqlCommand = "INSERT INTO msgInfo (sendingDate, sender, receiver, msg) VALUES ('" + jsonObj.getString("when") + "', '" + nickName + "', '" + jsonObj.getString("whom") + "', '" + jsonObj.getString("msg") + "')";
                            statement.execute(sqlCommand);
                            
                            jsonObj2 = new JSONObject();
                            jsonObj2.put("what", "messageSent");
                            jsonObj2.put("who", this.nickName);
                            jsonObj2.put("whom", jsonObj.getString("whom"));
                            jsonObj2.put("when", jsonObj.getString("when"));
                            jsonObj2.put("msg", jsonObj.getString("msg"));
                            
                            if (jsonObj.getString("whom").equals("Общий чат")) {
                                for (ServerSomthing vr : Server.serverList) {
                                    if (vr != this) {
                                        vr.send(jsonObj2.toString());
                                    }
                                }
                            }
                            else {
                                for (ServerSomthing vr : Server.serverList) {
                                    if (vr.nickName.equals(jsonObj.getString("whom"))) {
                                        vr.send(jsonObj2.toString());
                                    }
                                }
                            }
                            
                            break;
                        case "chatChanged":
                            
                            statement = Server.conn.createStatement();
                            if (jsonObj.getString("chat").equals("Общий чат"))
                                sqlCommand = "SELECT sendingDate, sender, msg FROM msgInfo WHERE receiver = '" + jsonObj.getString("chat") + "' ORDER BY sendingDate ASC";
                            else
                                sqlCommand = "SELECT sendingDate, sender, msg FROM msgInfo WHERE (sender = '" + nickName + "'AND receiver = '" + jsonObj.getString("chat") + "') OR (sender = '" + jsonObj.getString("chat") + "' AND receiver = '" + nickName + "') ORDER BY sendingDate ASC";
                            ResultSet resultSet = statement.executeQuery(sqlCommand);
                            
                            JSONArray msgStoryItems = new JSONArray();
                            
                            while (resultSet.next()) {
                                JSONObject msgStoryItem = new JSONObject();
                                
                                msgStoryItem.put("date", resultSet.getTimestamp(1).toLocalDateTime().format(Server.formatter));
                                msgStoryItem.put("nick", resultSet.getString(2));
                                msgStoryItem.put("msg", resultSet.getString(3));
                                
                                msgStoryItems.put(msgStoryItem);
                            }
                            
                            JSONObject msgStory = new JSONObject();
                            msgStory.put("what", "getMessageStory");
                            msgStory.put("msgStory", msgStoryItems);
                            
                            send(msgStory.toString());
                            
                            break;
                        case "close":
                            
                            jsonObj = new JSONObject();
                            jsonObj.put("what", "close");
                            jsonObj.put("chat", nickName);
                            
                            for (ServerSomthing vr : Server.serverList) {
                                if (vr != this) {
                                    vr.send(jsonObj.toString());
                                }
                            }
                            
                            downService();
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            } catch (NullPointerException ignored) {} catch (SQLException ex) {
                Logger.getLogger(ServerSomthing.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            this.downService();
        }
    }
    
    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }
    
    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                
                for (ServerSomthing vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}

public class Server {

    public static Connection conn;
    public static final int PORT = 8080;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
    
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/lab12_spp";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url, username, password);

            ServerSocket server = new ServerSocket(PORT, 5);
            System.out.println("Server Started");

            try {
                while (true) {
                    Socket socket = server.accept();
                    
                    try {
                        serverList.add(new ServerSomthing(socket));
                    } catch (IOException e) {
                        socket.close();
                    }
                }
            } finally {
                server.close();
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException | SQLException ex) {}
    }
}
