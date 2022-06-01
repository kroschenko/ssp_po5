package FacultyCompany.Core;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connection {

    public java.sql.Connection GetConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/lab2";
        final String USER = "root";
        final String PASSWORD = "user";

        var connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}


