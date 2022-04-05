package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    double res;
    Text sum = new Text("");
    TextField inputN = new TextField();
    TextField inputX= new TextField();
    Thread backgroundThread;
    Button start = new Button();
    GridPane grid;

    @Override
    public void init() {
        start.setText("Start");
        Button pause = new Button();
        pause.setText("Pause");
        Button stop = new Button();
        stop.setText("Stop");
        start.setOnAction(actionEvent -> startTh());
        pause.setOnAction(actionEvent -> {
            start.setDisable(false);
            backgroundThread.stop();
        });
        stop.setOnAction(actionEvent -> {
            start.setDisable(false);
            stop();
        });
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text text = new Text("Result: ");
        grid.add(text, 0, 0, 1, 1);
        grid.add(sum, 1, 0, 1, 1);
        Label labelN = new Label("N:");
        grid.add(labelN, 0, 1, 1, 1);
        Label labelX = new Label("X:");
        grid.add(labelX,0, 2, 1, 1 );
        grid.add(inputN, 1, 1, 1, 1);
        grid.add(inputX, 1, 2,1,1);
        grid.add(start, 0, 3);
        grid.add(pause, 1, 3);
        grid.add(stop, 2, 3);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LAB2");
        Scene scene = new Scene(grid, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double function(int x, int n) throws InterruptedException {
        double result, k = 0;
        int it = 1;
        for (int i = 0; i < n; i++) {
            k += Math.pow(-1, n) * Math.pow(x, it) / it;
            it = it + 2;
            Thread.sleep(1000);
        }
        result = (3.14 / 2) - k;
        return result;
    }

    public void startTh() {
        sum.setText("");
        Thread task = new Thread(() -> {
            try {
                int N = Integer.parseInt(inputN.getText());
                int X = Integer.parseInt(inputX.getText());
                start.setDisable(true);

                try {
                    res=function(X, N);
                    sum.setText(Double.toString(res));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start.setDisable(false);
            } catch (NumberFormatException e) {
                sum.setText("Error");
            }
        });
        backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }
    public void stop() {
        backgroundThread.stop();
        this.res=0;
        this.sum.setText("");
        inputN.setText("");
        inputX.setText("");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
