module lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens FacultyCompany to javafx.fxml;
    opens FacultyCompany.Entities to javafx.base;
    opens FacultyCompany.ViewModels to javafx.base;
    exports FacultyCompany;
}