package com.example.spplab1;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField xText;
    @FXML
    private TextField cycleText;
    @FXML
    private Button Pause;
    @FXML
    private Button Resume;
    @FXML
    private Button Interrupt;

    private Thread thread;
    private double n;
    private double nprev;
    private Double result;
    private int x;
    private int cycle;
    final Object lock = new Object();
    boolean paused;
    boolean thisprocessing;


    @FXML
    protected void initialize() {
    Pause.setDisable(true);
    Resume.setDisable(true);
    Interrupt.setDisable(true);
    }
    @FXML
    protected void onStartButtonClick() {

        try {
            x = Integer.parseInt(xText.getText());

            if (x < 0) {
                throw new IllegalArgumentException();
            }

            cycle = Integer.parseInt(cycleText.getText());

            if (cycle < 0) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            Platform.runLater(() -> welcomeText.setText("Invalid input"));

            return;
        }
        thread = new Thread(() -> {

            Pause.setDisable(false);
            Interrupt.setDisable(false);

            thisprocessing = true;
            n = 1.0;
            nprev = 1.0;
            result = 1.0;
                while (n < cycle + 1 && thisprocessing == true) {

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ignored) {
                    }

                    synchronized (lock) {
                        if (paused) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                break;
                            }
                        } else {
                            result += (Math.pow(x, n) / (n * nprev));
                            nprev *= n;
                            n++;
                        }
                        Platform.runLater(() -> welcomeText.setText(result.toString()));
                    }
                }


            Platform.runLater(() -> welcomeText.setText("finish = " + result.toString()));
        });

        thread.start();
    }

    @FXML
    protected void onPauseButtonClick() {
        Resume.setDisable(false);
        welcomeText.setText(result.toString());
        paused = true;
    }

    @FXML
    protected void onResumeButtonClick() {
        Resume.setDisable(true);
        synchronized (lock) {
            paused = false;
            lock.notify();
        }
    }

    @FXML
    protected void onInterruptButtonClick() {
        thisprocessing= false;
    }
}
