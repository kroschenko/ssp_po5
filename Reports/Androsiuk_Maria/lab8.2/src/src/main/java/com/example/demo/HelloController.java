package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label resultText;
    @FXML
    private Label messageText;
    @FXML
    private TextField valueText;

    int value;

    @FXML
    protected void onStartButtonClick() {
        resultText.setText("");

        try {
            value = Integer.parseInt(valueText.getText());

            if (value < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            messageText.setText("Invalid input");

            return;
        }

        double result = 0.0;
        double previousTerm = 1.0;
        ArrayList<Double> results = new ArrayList<>();

        for (int i = 0; i <= value; i++) {
            previousTerm = i == 0 ? 1.0 : previousTerm / i;
            result += previousTerm;
            results.add(result);
        }

        for (int i = results.size() - 1; i >= 0; i--) {
            resultText.setText(resultText.getText() + "\n" + results.get(i));
        }
    }
}