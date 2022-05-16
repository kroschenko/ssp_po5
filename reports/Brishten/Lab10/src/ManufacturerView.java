package com.company;

import com.company.repository.*;
import com.company.entity.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class ManufacturerView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {
        ManufacturerDB manufacturerDB = new ManufacturerDB();
        List<Manufacturer> manufacturers = manufacturerDB.selectFromTable();
        ObservableList<Manufacturer> manufacturerObservableList = FXCollections.observableArrayList(manufacturers);
        TableView<Manufacturer> table = new TableView<Manufacturer>(manufacturerObservableList);
        table.setMinWidth(500);
        table.setEditable(false);

        TableColumn<Manufacturer, Integer> manufacturerIdColumn = new TableColumn<Manufacturer, Integer>("ManID");
        manufacturerIdColumn.setCellValueFactory(new PropertyValueFactory<Manufacturer, Integer>("ID"));
        manufacturerIdColumn.setEditable(false);

        TableColumn<Manufacturer, String> manufacturerName = new TableColumn<Manufacturer, String>("Name");
        manufacturerName.setCellValueFactory(new PropertyValueFactory<Manufacturer, String>("name"));
        manufacturerName.setCellFactory(TextFieldTableCell.<Manufacturer>forTableColumn());

        TableColumn<Manufacturer, String> establishDate = new TableColumn<Manufacturer, String>("Date");
        establishDate.setCellValueFactory(new PropertyValueFactory<Manufacturer, String>("establishDate"));
        establishDate.setCellFactory(TextFieldTableCell.<Manufacturer>forTableColumn());

        table.getColumns().addAll(manufacturerIdColumn, manufacturerName, establishDate);

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(10);
        root.getChildren().addAll(table);
        primaryStage.setTitle("Manufacturers");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
