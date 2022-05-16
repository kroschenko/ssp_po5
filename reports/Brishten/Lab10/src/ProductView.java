package com.company;

import com.company.repository.*;
import com.company.entity.*;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductView extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws SQLException {
        ProductDB productDB = new ProductDB();
        ManufacturerDB manufacturerDB = new ManufacturerDB();

        List<Product> products = productDB.selectFromTable();
        List<Manufacturer> manufacturers = manufacturerDB.selectFromTable();
        List<String> manufacturersNames = new ArrayList<>();

        for (Manufacturer manufacturer : manufacturers) {
            manufacturersNames.add(manufacturer.getName());
        }

        ObservableList<Product> productObservableList = FXCollections.observableArrayList(products);
        ObservableList<String> manufacturersList = FXCollections.observableArrayList(manufacturersNames);
                
        TableView<Product> table = new TableView<Product>(productObservableList);

        table.setMinWidth(600);
        table.setEditable(true);
        Label label = new Label();
        label.setText("Selected: ");
        label.setMinWidth(520);

        TableColumn<Product, Integer> productIdColumn = new TableColumn<Product, Integer>("ProdID");
        productIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ID"));
        productIdColumn.setEditable(false);

        TableColumn<Product, String> productName = new TableColumn<Product, String>("Name");
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productName.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        productName.setOnEditCommit((TableColumn.CellEditEvent<Product, String> event) -> {
            TablePosition<Product, String> position = event.getTablePosition();
            String name = event.getNewValue();
            if (!name.equals("")) {
                int row = position.getRow();
                Product product = event.getTableView().getItems().get(row);
                product.setName(name);
                try {
                    ProductDB.editProduct(product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        TableColumn<Product, Double> price = new TableColumn<Product, Double>("Price");
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        price.setCellFactory(TextFieldTableCell.<Product, Double>forTableColumn(new DoubleStringConverter()));
        price.setOnEditCommit((TableColumn.CellEditEvent<Product, Double> event) ->
        {
            TablePosition<Product, Double> position = event.getTablePosition();
            Double productPrice = event.getNewValue();
            if (productPrice >= 0.0) {
                int row = position.getRow();
                Product product = event.getTableView().getItems().get(row);
                product.setPrice(productPrice);
                try {
                    ProductDB.editProduct(product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        
        TableColumn<Product, String> manufacturerName = new TableColumn<Product, String>("Manufacturer");
        manufacturerName.setCellValueFactory(param -> {
            Product product = param.getValue();
            Manufacturer manufacturer = product.getManufacturer();
            return new SimpleObjectProperty<String>(manufacturer.getName());
        });
        manufacturerName.setCellFactory(ComboBoxTableCell.forTableColumn(manufacturersList));
        manufacturerName.setOnEditCommit((TableColumn.CellEditEvent<Product, String>
                                            event) -> {
            TablePosition<Product, String> position = event.getTablePosition();
            String newRenter = event.getNewValue();
            int manufacturerIdInList = 0;
            for (int i = 0; i < manufacturersNames.size(); i++) {
                if (newRenter.equals(manufacturersNames.get(i))) {
                    manufacturerIdInList = i;
                    break;
                }
            }
            Manufacturer manufacturer = manufacturers.get(manufacturerIdInList);

            int row = position.getRow();
            Product product = event.getTableView().getItems().get(row);
            product.setManufacturer(manufacturer);
            try {
                ProductDB.editProduct(product);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        table.getColumns().addAll(productIdColumn, productName, price, manufacturerName);

        final ComboBox<String> manufacturerComboBox = new ComboBox<>(manufacturersList);
        manufacturerComboBox.setValue("Choose");
        final Button addButton = new Button("Add");
        final Button deleteButton = new Button("Delete");

        TableView.TableViewSelectionModel<Product> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, oldProduct, newProduct) -> {
            if (newProduct != null) {
                label.setText("Selected: " + newProduct.getName());
                deleteButton.setDisable(false);
            }
        });

        final TextField addName = new TextField();
        final TextField addPrice = new TextField();
        addName.setPromptText("Product Name");
        addName.setMaxWidth(productName.getPrefWidth());
        addPrice.setPromptText("Price");
        addPrice.setMaxWidth(price.getPrefWidth());
        addButton.setOnAction(e -> {
            if (!addName.getText().isEmpty() && !manufacturerComboBox.getValue().equals("Choose") &&
            !addPrice.getText().isEmpty() && Double.parseDouble(addPrice.getText()) >= 0.0) {
                try {
                    String newManufacturer = manufacturerComboBox.getValue();
                    int manufacturerIdInList = 0;
                    for (int i = 0; i < manufacturersNames.size(); i++) {
                        if (newManufacturer.equals(manufacturersNames.get(i))) {
                            manufacturerIdInList = i;
                            break;
                        }
                    }
                    Manufacturer manufacturer = manufacturers.get(manufacturerIdInList);
                    ProductDB.addProduct(addName.getText(), Double.valueOf(addPrice.getText()), manufacturer);
                    start(primaryStage);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.setDisable(true);
        deleteButton.setOnAction(actionEvent -> {
            if (table.getSelectionModel().getSelectedItem() != null) {
                Product selectedItem = table.getSelectionModel().getSelectedItem();
                try {
                    ProductDB.deleteProduct(selectedItem.getID());
                    start(primaryStage);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        VBox root = new VBox();
        HBox deleteBox = new HBox();
        HBox addBox = new HBox();
        root.setPadding(new Insets(5));
        root.setSpacing(10);
        root.getChildren().addAll(deleteBox, table, addBox);
        deleteBox.setPadding(new Insets(5));
        deleteBox.setSpacing(10);
        deleteBox.getChildren().addAll(label, deleteButton);
        addBox.setPadding(new Insets(5));
        addBox.setSpacing(10);
        addBox.getChildren().addAll(addName, addPrice, manufacturerComboBox, addButton);
        primaryStage.setTitle("Products");
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
