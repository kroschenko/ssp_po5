package com.example.lab1;

import javafx.application.Platform;

public class Calculator extends Thread {
    private int n;
    private Double sum = 0.0;
    private final HelloController controller;

    public Calculator(int n, HelloController controller) {
        this.n = n;
        this.controller = controller;
    }

    @Override
    public void run() {
        int k = 1;
        try {
            while (k < n && !isInterrupted()) {
                Platform.runLater(() -> controller.updateResult(sum));
                double s = Math.pow(-1, k - 1) * 1 / Math.pow(k, 2);
                sum += s;
                k++;
                Platform.runLater(() -> controller.updateResult(sum));

                sleep(10);

                if(k == n) {
                    controller.pause.setDisable(true);
                    controller.resume.setDisable(true);
                    controller.stop.setDisable(true);
                    controller.isRunning = false;
                    controller.textFildN.setText("Enter n");
                    controller.calc.setDisable(false);
                }
            }
        } catch (InterruptedException exception) {
            System.out.println("Interrupted");
        }
    }
}


