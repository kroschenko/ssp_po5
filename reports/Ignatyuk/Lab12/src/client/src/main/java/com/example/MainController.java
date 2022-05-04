package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class MainController implements Initializable {
    @FXML
    private Button connectButton = new Button();

    @FXML
    private TextField serverAddressTextField = new TextField();
    @FXML
    private TextField serverPortTextField = new TextField();
    @FXML
    private TextField playerTextField = new TextField();
    @FXML
    private TextField statusTextField = new TextField();

    @FXML
    private Button button0 = new Button();
    @FXML
    private Button button1 = new Button();
    @FXML
    private Button button2 = new Button();
    @FXML
    private Button button3 = new Button();
    @FXML
    private Button button4 = new Button();
    @FXML
    private Button button5 = new Button();
    @FXML
    private Button button6 = new Button();
    @FXML
    private Button button7 = new Button();
    @FXML
    private Button button8 = new Button();

    private Button currentButton = null;

    private final static String GREETING_RESPONSE = "GREETING";
    private final static String START_RESPONSE = "START";
    private final static String MOVE_RESPONSE = "MOVE";
    private final static String WIN_RESPONSE = "WIN";
    private final static String LOSE_RESPONSE = "LOSE";
    private final static String DRAW_RESPONSE = "DRAW";

    private final static String WAINTING_STATUS = "Wait opponent...";
    private final static String YOUR_TURN_STATUS = "It's your turn!";
    private final static String WIN_STATUS = "You won!";
    private final static String LOSE_STATUS = "You lost!";
    private final static String DRAW_STATUS = "Draw!";

    private final static String ROLE_X = "X";
    private final static String ROLE_0 = "0";

    private String myRole = "";
    private String opponentRole = "";

    private Image myImage;
    private Image opponentImage;

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    @Override
    public final void initialize(final URL arg0, final ResourceBundle arg1) {
        try {
            if (this.serverAddressTextField.getText().equals("")
                    || this.serverPortTextField.getText().equals("")) {
                return;
            }

            this.button0.setDisable(false);
            this.button1.setDisable(false);
            this.button2.setDisable(false);
            this.button3.setDisable(false);
            this.button4.setDisable(false);
            this.button5.setDisable(false);
            this.button6.setDisable(false);
            this.button7.setDisable(false);
            this.button8.setDisable(false);

            this.button0.setGraphic(null);
            this.button1.setGraphic(null);
            this.button2.setGraphic(null);
            this.button3.setGraphic(null);
            this.button4.setGraphic(null);
            this.button5.setGraphic(null);
            this.button6.setGraphic(null);
            this.button7.setGraphic(null);
            this.button8.setGraphic(null);

            this.myRole = "";
            this.opponentRole = "";

            this.statusTextField.setText(MainController.WAINTING_STATUS);
            this.playerTextField.setText(null);

            this.socket = new Socket(this.serverAddressTextField.getText(),
                    Integer.parseInt(this.serverPortTextField.getText()));

            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = new PrintWriter(this.socket.getOutputStream(), true);

            String response = this.input.readLine();

            if (!response.startsWith(MainController.GREETING_RESPONSE)) {
                this.statusTextField.setText("Cannot connect!");
                return;
            }

            this.myRole += response.charAt(MainController.GREETING_RESPONSE.length());
            this.opponentRole += response.charAt(MainController.GREETING_RESPONSE.length() + 1);
            this.playerTextField.setText(this.myRole);

            this.myImage = new Image(getClass().getResourceAsStream(this.myRole + ".gif"));
            this.opponentImage = new Image(getClass().getResourceAsStream(this.opponentRole + ".gif"));

            EventHandler<ActionEvent> onButtonAction = new EventHandler<ActionEvent>() {
                @Override
                public final void handle(ActionEvent event) {
                    if (statusTextField.getText().equals(MainController.WAINTING_STATUS)
                            || statusTextField.getText().equals(MainController.WIN_STATUS)
                            || statusTextField.getText().equals(MainController.LOSE_STATUS)
                            || statusTextField.getText().equals(MainController.DRAW_STATUS)) {
                        return;
                    }

                    statusTextField.setText(MainController.WAINTING_STATUS);

                    Button button = (Button) event.getSource();
                    String buttonId = button.getId();
                    button.setDisable(true);
                    button.setGraphic(new ImageView(myImage));
                    output.println("MOVE" + buttonId.charAt(buttonId.length() - 1));

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public final void run() {
                            waitForOpponent();
                        }
                    });

                    thread.start();
                }
            };

            this.button0.setOnAction(onButtonAction);
            this.button1.setOnAction(onButtonAction);
            this.button2.setOnAction(onButtonAction);
            this.button3.setOnAction(onButtonAction);
            this.button4.setOnAction(onButtonAction);
            this.button5.setOnAction(onButtonAction);
            this.button6.setOnAction(onButtonAction);
            this.button7.setOnAction(onButtonAction);
            this.button8.setOnAction(onButtonAction);

            Thread thread = new Thread(new Runnable() {
                @Override
                public final void run() {
                    waitForOpponent();
                }
            });

            thread.start();
            Thread.sleep(500);
        } catch (final UnknownHostException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final IOException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    @FXML
    private final void connect() {
        if (this.statusTextField.getText().equals(MainController.WAINTING_STATUS)
                || this.statusTextField.getText().equals(MainController.YOUR_TURN_STATUS)) {
            return;
        }

        if (this.output != null) {
            this.output.close();
        }

        if (this.input != null) {
            try {
                this.input.close();
            } catch (final IOException exception) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
            }
        }

        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (final IOException exception) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
            }
        }

        this.initialize(null, null);
    }

    private final void waitForOpponent() {
        try {
            while (true) {
                String response = this.input.readLine();

                if (response == null || response.equals("")) {
                    continue;
                }

                if (response.startsWith(MainController.START_RESPONSE)) {
                    if (this.myRole.equals(MainController.ROLE_X)) {
                        this.statusTextField.setText(MainController.YOUR_TURN_STATUS);
                        return;
                    }

                    continue;
                }

                Integer boxNumber = null;

                if (response.startsWith(MainController.MOVE_RESPONSE)) {
                    Platform.runLater(() -> {
                        this.statusTextField.setText(MainController.YOUR_TURN_STATUS);
                    });

                    boxNumber = response.charAt(MOVE_RESPONSE.length()) - '0';
                }

                if (response.startsWith(MainController.WIN_RESPONSE)) {
                    Platform.runLater(() -> {
                        this.statusTextField.setText(MainController.WIN_STATUS);
                    });

                    boxNumber = response.charAt(WIN_RESPONSE.length()) - '0';
                }

                if (response.startsWith(MainController.LOSE_RESPONSE)) {
                    Platform.runLater(() -> {
                        this.statusTextField.setText(MainController.LOSE_STATUS);
                    });

                    boxNumber = response.charAt(LOSE_RESPONSE.length()) - '0';
                }

                if (response.startsWith(MainController.DRAW_RESPONSE)) {
                    Platform.runLater(() -> {
                        this.statusTextField.setText(MainController.DRAW_STATUS);
                    });

                    boxNumber = response.charAt(DRAW_RESPONSE.length()) - '0';
                }

                if (boxNumber == null) {
                    return;
                }

                switch (boxNumber) {
                    case 0:
                        this.currentButton = this.button0;
                        break;
                    case 1:
                        this.currentButton = this.button1;
                        break;
                    case 2:
                        this.currentButton = this.button2;
                        break;
                    case 3:
                        this.currentButton = this.button3;
                        break;
                    case 4:
                        this.currentButton = this.button4;
                        break;
                    case 5:
                        this.currentButton = this.button5;
                        break;
                    case 6:
                        this.currentButton = this.button6;
                        break;
                    case 7:
                        this.currentButton = this.button7;
                        break;
                    case 8:
                        this.currentButton = this.button8;
                        break;

                }

                Platform.runLater(() -> {
                    if (this.currentButton.isDisable()) {
                        return;
                    }

                    this.currentButton.setDisable(true);
                    this.currentButton.setGraphic(new ImageView(this.opponentImage));
                });
            }
        } catch (final IOException exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        } catch (final Exception exception) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
};
