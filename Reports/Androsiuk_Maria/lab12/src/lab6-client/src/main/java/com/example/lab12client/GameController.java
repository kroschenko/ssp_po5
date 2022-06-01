package com.example.lab12client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;

public class GameController {
    @FXML
    private Label result;
    @FXML
    private Label command;
    @FXML
    private TextField numberInput;
    @FXML
    private Button enterButton;

    private BufferedWriter writer;
    private boolean isGuesser;

    public GameController() {
        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 8080);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {
                    String str = reader.readLine();

                    if (str.equals("Угадайте число")) {
                        isGuesser = true;
                    }

                    if (str.equals("Выберите число") || str.equals("Угадайте число")) {
                        Platform.runLater(() -> command.setText(str));
                        Platform.runLater(() -> enterButton.setDisable(false));
                        continue;
                    }

                    Platform.runLater(() -> result.setText(str));

                    if (!str.startsWith("Попытка")) {
                        Thread.sleep(5000);
                        isGuesser = false;
                        Platform.runLater(() -> result.setText(""));
                    }
                }
            } catch (IOException | InterruptedException ignored) { }
        }).start();
    }

    @FXML
    protected void onClick() throws IOException {
        List<Character> characters = numberInput.getText().chars().mapToObj(character -> (char) character).toList();
        if (characters.size() != 4 || new HashSet<>(characters).size() != 4 || !characters.stream().allMatch(Character::isDigit)) {
            command.setText("Неверный ввод. Попробуйте еще раз");
            return;
        }

        writer.write(numberInput.getText() + "\n");
        writer.flush();

        if (!isGuesser) {
            command.setText("");
            enterButton.setDisable(true);
            return;
        }

        command.setText("Угадайте число");
    }
}