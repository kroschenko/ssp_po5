module com.example.lab9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires j.text.utils;


    opens com.example.lab9 to javafx.fxml;
    exports com.example.lab9;
}