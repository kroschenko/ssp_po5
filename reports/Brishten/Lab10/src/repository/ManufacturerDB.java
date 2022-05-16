package com.company.repository;

import com.company.entity.Manufacturer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDB {
    private Connection dbConnection;
    private Statement statement;

    public ManufacturerDB() {
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getDBConnection() {
        final String DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD;
        DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/java";
        DB_USER = "root";
        DB_PASSWORD = "";
        Connection dbconnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            dbconnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbconnection;
    }

    public List selectFromTable() throws SQLException {
        int ID;
        String name, establishDate;
        String selectTableSQL = "SELECT * FROM `manufacturers`";
        ResultSet rs = statement.executeQuery(selectTableSQL);
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        
        while (rs.next()) {
            ID = rs.getInt(1);
            name = rs.getString("name");
            establishDate = rs.getString(3);
            manufacturers.add(new Manufacturer(ID, name, establishDate));
        }
        return manufacturers;
    }
}
