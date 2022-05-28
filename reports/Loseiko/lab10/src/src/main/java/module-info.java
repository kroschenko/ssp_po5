module com.example.lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.lab4 to javafx.fxml;
    exports com.example.lab4;
    exports com.example.lab4.Controllers;
    opens com.example.lab4.Controllers to javafx.fxml;
    exports com.example.lab4.Connector;
    opens com.example.lab4.Connector to javafx.fxml;
    exports com.example.lab4.Model;
    opens com.example.lab4.Model to javafx.fxml;
}