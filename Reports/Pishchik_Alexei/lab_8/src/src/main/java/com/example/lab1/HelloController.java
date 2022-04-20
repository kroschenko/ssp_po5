package com.example.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class HelloController {
    private Thread calculator;
    boolean isRunning;

    @FXML
    public TextField textFildN;

    @FXML
    public Button calc;

    @FXML
    public Button resume;

    @FXML
    public Button pause;

    @FXML
    public Button stop;

    @FXML
    private Text result;

    @FXML
    public Text message;

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
            pause.setDisable(true);
            isRunning = false;
        }
    }

    public void resumeClick(ActionEvent actionEvent) {

        if (!isRunning) {
            message.setText("calculating");
            calculator.resume();
            resume.setDisable(true);
            pause.setDisable(false);
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