package lab10.core;

import lab10.config.ConfigurationConstants;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connection {

    public java.sql.Connection GetConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        var connectionURL = ConfigurationConstants.URL;
        var connectionUser = ConfigurationConstants.USER;
        var connectionPassword = ConfigurationConstants.PASSWORD;
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
    }
}
