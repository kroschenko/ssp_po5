package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Text sceneTitle = new Text("Calculate function");
    Label labelForN = new Label("Enter n value:");
    Label labelForResult = new Label("Value is not given");
    TextField textFieldN = new TextField();
    HBox hbox = new HBox();
    Button calcResult = new Button("Calculate result");

    private double sum = 0, fac = 1, current = 0;
    private int counter = 1, i = 0;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Lab 8");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.add(labelForN, 0, 1);
        grid.add(textFieldN, 1, 1);
        grid.add(labelForResult, 1, 2);
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().addAll(calcResult);
        grid.add(hbox, 1, 4);
        Scene scene = new Scene(grid, 800, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        calcResult.setOnAction(e -> {
            startTask();
        });
    }

    public void startTask() {
        try {
            counter = Integer.parseInt(textFieldN.getText());
            work();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("Information Alert");
            String s = "Incorrect number format";
            alert.setContentText(s);
            alert.show();
        }
    }

    private void done() {
        this.sum = 0;
        this.counter = 0;
        this.i = 0;
        this.current = 0;
        this.fac = 1;
        this.textFieldN.setText("");
    }

    private void work() {
        while (i < counter) {
            if (i % 2 == 0) {
                current = 1 / fac;
            } else {
                current = -1 / fac;
            }
            fac *= (i + 1);

            sum += current;

            i++;
        }
        final String status = "pos = " + i + ", sum = " + sum;
        Platform.runLater(() -> labelForResult.setText(status));
        done();
    }
}
