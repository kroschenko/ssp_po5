package com.example.lab8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class HelloApplication extends Application {
    Double currentValue;
    Double tempValue = 1.0;
    int currentIteration = 0;
    Text sum = new Text("");
    TextField inputCount = new TextField();
    Thread backgroundThread;
    Button start = new Button();
    Button pause = new Button();
    Button stop = new Button();
    GridPane grid;
    long count;
    long i;

    final Object lock = new Object();

    @Override
    public void init() {
        start.setText("Start");
        pause.setText("Pause");
        stop.setText("Stop");
        pause.setDisable(true);
        stop.setDisable(true);
        start.setOnAction(actionEvent -> startCalculate());
        pause.setOnAction(actionEvent -> {

            start.setDisable(false);
            backgroundThread.suspend();
        });
        stop.setOnAction(actionEvent -> {
            pause.setDisable(true);
            stop.setDisable(true);
            start.setDisable(false);
            stopCalculate();
        });
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text text = new Text("Текущая сумма: ");
        grid.add(text, 0, 0, 1, 1);
        grid.add(sum, 1, 0, 1, 1);
        Label labelCount = new Label("N:");
        grid.add(labelCount, 0, 1, 1, 1);
        grid.add(inputCount, 1, 1, 1, 1);
        grid.add(start, 0, 3);
        grid.add(pause, 1, 3);
        grid.add(stop, 2, 3);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Function");
        Scene scene = new Scene(grid, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startCalculate() {
        start.setDisable(true);
        pause.setDisable(false);
        stop.setDisable(false);
        if (backgroundThread != null) {
            backgroundThread.interrupt();
        }
        try {
            count = Long.parseLong(inputCount.getText());
            if (count < 0) {
                throw new NumberFormatException();
            }
            i = 0;
            currentValue = 0.0;
//            paused = false;
            backgroundThread = new Thread(() -> {
                while (i <= count) {
                    synchronized (lock) {
                        try {
                            Thread.sleep(1);
//                            if (paused) {
//                                lock.wait();
//                            } else {
                                currentValue += 1 / Math.pow(2, i);
                                i += 1;
//                            }
                            Platform.runLater(() -> sum.setText(currentValue.toString() + " Итерация: " + (i - 1) ));
                        } catch (InterruptedException ignored) {
                            break;
                        }
                    }
                }
                start.setDisable(false);
                pause.setDisable(true);
                stop.setDisable(true);
            });
            backgroundThread.start();
        }
        catch (NumberFormatException e) {
            sum.setText("Введите целое неотрицательное число!");
        }
    }


    public void stopCalculate() {
        backgroundThread.stop();
        this.currentValue = (double) 0;
        this.currentIteration = 0;
        backgroundThread = null;
        this.sum.setText("");
        inputCount.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}