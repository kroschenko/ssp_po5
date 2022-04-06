package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();
        final Button productButton = new Button("Product");
        productButton.setMinWidth(290);
        productButton.setOnAction(actionEvent -> {
            try {
                stage.close();
                ProductView productView = new ProductView();
                productView.start(stage);
            } catch (SQLException e) {

                e.printStackTrace();
            }
        });

        final Button manufacturerButton = new Button("Manufacturer");
        manufacturerButton.setMinWidth(290);
        manufacturerButton.setOnAction(actionEvent -> {
            try {
                stage.close();
                ManufacturerView manufacturerView = new ManufacturerView();
                manufacturerView.start(stage);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(productButton, manufacturerButton);
        primaryStage.setTitle("Menu");
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

