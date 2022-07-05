module lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens lab10 to javafx.fxml;
    opens lab10.entities to javafx.base;
    opens lab10.viewModels to javafx.base;
    exports lab10;
}