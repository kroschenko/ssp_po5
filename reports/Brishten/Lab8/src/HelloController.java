package com.example.labs;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Thread thread;
    private Double result;
    private Integer i;
    private Long n;
    public Label messageText;
    public TextField valueText;
    final Object lock = new Object();
    boolean paused;

    @FXML
    protected void onStartButtonClick() {
        if (thread != null) {
            thread.interrupt();
        }
        try {
            n = Long.parseLong(valueText.getText());
            if (n < 0) {
                throw new NumberFormatException();
            }
            i = 0;
            result = 0.0;
            paused = false;
            thread = new Thread(() -> {
                while (i <= n) {
                    synchronized (lock) {
                        try {
                            Thread.sleep(1000);
                            if (paused) {
                                lock.wait();
                            } else {
                                result += 1 / Math.pow(2, i);
                                i += 1;
                            }
                            Platform.runLater(() -> messageText.setText(result.toString()));
                        } catch (InterruptedException ignored) {
                            break;
                        }
                    }
                }
            });
            thread.start();
        }
        catch (NumberFormatException e) {
            messageText.setText("Введите целое неотрицательное число!");
        }
    }

    @FXML
    protected void onPauseButtonClick() {
        messageText.setText(result.toString());
        paused = true;
    }

    @FXML
    protected void onContinueButtonClick() {
        if (!paused) {
            return;
        }
        synchronized (lock) {
            paused = false;
            lock.notify();
        }
    }

    @FXML
    protected void onStopButtonClick() {
        thread.interrupt();
    }
}