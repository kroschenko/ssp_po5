package com.spplab9.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/lab9spp";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public Connection getConnection() {return connection;}
    public void setConnection(Connection connection) {this.connection = connection;}

    public DBWorker(){

        try{

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

