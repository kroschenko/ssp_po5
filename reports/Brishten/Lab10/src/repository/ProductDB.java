package com.company.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.Manufacturer;
import com.company.entity.Product;

public class ProductDB {
    private static Statement statement;
    private static Connection dbConnection;

    public ProductDB() {
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
        int ID, manID;
        String name;
        double price; 
        String selectTableSQL = "SELECT * FROM `products`";
        ResultSet rs = statement.executeQuery(selectTableSQL);
        List<Product> products = new ArrayList<Product>();

        while (rs.next()) {
            ID = rs.getInt(1);
            name = rs.getString("name");
            price = rs.getDouble(3);
            manID = rs.getInt("man_id");
            PreparedStatement pr = dbConnection.prepareStatement("SELECT " +
                    "man_id, name, establish_date FROM `manufacturers` where man_id=?");
            pr.setInt(1, manID);
            ResultSet rs2 = pr.executeQuery();
            Manufacturer manufacturer = null;
            if (rs2.next()) {
                manufacturer = new Manufacturer(rs2.getInt(1),
                        rs2.getString(2), rs2.getString(3));
            }
            products.add(new Product(ID, name, price, manufacturer));
        }
        return products;
    }

    public static void addProduct(String name, Double price, Manufacturer manufacturer) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("INSERT " +
                "`products`(name, price, man_id) VALUES (?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, price);
        preparedStatement.setInt(3, manufacturer.getID());
        preparedStatement.executeUpdate();
    }

    public static void editProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("UPDATE " +
                "`products` SET name=?, price=?, man_id=? WHERE pr_id=?");
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getManufacturer().getID());
        preparedStatement.setInt(4, product.getID());
        preparedStatement.executeUpdate();
    }

    public static void deleteProduct(int ID) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("DELETE " +
                "FROM `products` WHERE pr_id=?");
        preparedStatement.setInt(1, ID);
        preparedStatement.executeUpdate();
    }
}
