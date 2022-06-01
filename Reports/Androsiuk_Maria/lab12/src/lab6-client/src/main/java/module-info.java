module com.example.lab12client {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab12client to javafx.fxml;
    exports com.example.lab12client;
}