package com.example.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class HelloController {
    private Thread calculator;
    boolean isRunning;

    @FXML
    private TextField textFildN;

    @FXML
    private Button calc;

    @FXML
    private Button resume;

    @FXML
    private Button pause;

    @FXML
    private Button stop;

    @FXML
    private Text result;

    @FXML
    private Text message;

    @FXML
    void initialize() {

    }

    public void calcClick(ActionEvent actionEvent) {

        try {
            int n = Integer.parseInt(textFildN.getText());

            calculator = new Calculator(n, this);

            calculator.start();
            isRunning = true;

            message.setText("calculating");
            pause.setDisable(false);
            calc.setDisable(true);
            resume.setDisable(true);

        } catch (NumberFormatException e) {
            message.setText("enter the number");
        }
    }

    public void pauseClick(ActionEvent actionEvent) throws InterruptedException {

        if (isRunning) {
            calculator.suspend();
            message.setText("pause");
            calc.setDisable(true);
            resume.setDisable(false);
            isRunning = false;
        }
    }

    public void resumeClick(ActionEvent actionEvent) {

        if (!isRunning) {
            message.setText("calculating");
            calculator.resume();
            isRunning = true;
        }
    }

    public void stopClick(ActionEvent actionEvent) {

        calculator.interrupt();
        message.setText("stopped");
        textFildN.setText("Enter n");
        calc.setDisable(false);
        pause.setDisable(true);
        resume.setDisable(true);
    }

    public void updateResult(double sum) {
        result.setText(String.valueOf(sum));
    }
}