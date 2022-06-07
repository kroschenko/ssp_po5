package com.company.database;

import java.sql.*;

public final class Connection {

    public java.sql.Connection GetConnection() throws SQLException {
        String connectionURL = "jdbc:mysql://localhost:3306/mysql";
        String connectionUser = "root";
        String connectionPassword = "root";

        java.sql.Connection connection = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
        return connection;
    }
}
