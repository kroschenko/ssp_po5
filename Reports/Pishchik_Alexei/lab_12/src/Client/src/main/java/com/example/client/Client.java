package com.example.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;
    private int countWand;

    private ClientGUI clientGUI;
    private boolean isRun;


    public Client(Socket socket, String username, ClientGUI clientGUI) {
        try {
            this.clientGUI = clientGUI;
            this.socket = socket;
            this.username = username;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.countWand = 20;
            this.isRun = false;
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    public void sendName() {
        try {
            while (socket.isConnected()) {
                bufferedWriter.write(username);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                return;
            }
        } catch (IOException e) {}
    }

    public void send(boolean isResult) {
        try {
            while (socket.isConnected()) {

                if(isResult) {
                    return;
                }
                else {
                    String messageToSend = clientGUI.textNum.getText();
                    bufferedWriter.write(username + ": " + messageToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    int sendValue = Integer.parseInt(messageToSend.substring(messageToSend.length() - 1));

                    if(isRun && sendValue > 0 && sendValue < 4) {
                        countWand -= sendValue;
                        String place = "";
                        for (int i = 0; i < countWand; i++) {
                            place += "| ";
                        }
                        clientGUI.place.setText(place);
                        clientGUI.size.setText(String.valueOf(countWand));

                        if(countWand < 1) {
                            return;
                        }
                        clientGUI.result.setText("Left " + countWand + " wands");
                    }
                    clientGUI.textNum.clear();
                    return;
                }
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGame;
                while (socket.isConnected()) {
                    try {

                        //GUI
                        clientGUI.textIp.setDisable(true);
                        clientGUI.textPort.setDisable(true);
                        clientGUI.connected.setDisable(true);
                        clientGUI.name.setDisable(true);

                        msgFromGame = bufferedReader.readLine();

                        if(msgFromGame.equals("server fill")) {
                            isRun = false;
                            socket.close();
                            clientGUI.result.setText("Server is Fill!");
                            //GUI
                            clientGUI.textIp.setDisable(false);
                            clientGUI.textPort.setDisable(false);
                            clientGUI.connected.setDisable(false);
                            clientGUI.name.setDisable(false);
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }

                        if(msgFromGame.equals("Next step You")) {
                            clientGUI.take.setDisable(false);
                            clientGUI.textNum.setDisable(false);
                        }
                        if(msgFromGame.equals("Next step Enemy")) {
                            clientGUI.take.setDisable(true);
                            clientGUI.textNum.setDisable(true);
                        }

                        try {
                            if(msgFromGame.substring(0,6).equals("SERVER")) msgFromGame = "";

                        } catch (Exception e) {}


                        if(msgFromGame.equals("S-R: You Lose!!!")) {
                            isRun = false;
                            socket.close();
                            clientGUI.result.setText(msgFromGame);
                            //GUI
                            clientGUI.textIp.setDisable(false);
                            clientGUI.textPort.setDisable(false);
                            clientGUI.connected.setDisable(false);
                            clientGUI.name.setDisable(false);
                            clientGUI.take.setDisable(false);
                            clientGUI.textNum.setDisable(false);
                            clientGUI.size.setText("20");
                            String place = "";
                            for (int i = 0; i < 20; i++) {
                                place += "| ";
                            }
                            clientGUI.place.setText(place);
                            countWand = 20;
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }

                        if(msgFromGame.equals("S-R: You Winner!!!")) {
                            isRun = false;
                            socket.close();
                            clientGUI.result.setText(msgFromGame);
                            //GUI
                            clientGUI.textIp.setDisable(false);
                            clientGUI.textPort.setDisable(false);
                            clientGUI.connected.setDisable(false);
                            clientGUI.name.setDisable(false);
                            clientGUI.take.setDisable(false);
                            clientGUI.textNum.setDisable(false);
                            clientGUI.size.setText("20");
                            String place = "";
                            for (int i = 0; i < 20; i++) {
                                place += "| ";
                            }
                            clientGUI.place.setText(place);
                            countWand = 20;
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }
                        clientGUI.result.setText(msgFromGame);

                        if(msgFromGame.contains("Server say:")) {
                            isRun = false;
                            socket.close();
                            clientGUI.result.setText("S-R: You Winner!!!");
                            //GUI
                            clientGUI.textIp.setDisable(false);
                            clientGUI.textPort.setDisable(false);
                            clientGUI.connected.setDisable(false);
                            clientGUI.name.setDisable(false);
                            clientGUI.take.setDisable(false);
                            clientGUI.textNum.setDisable(false);
                            clientGUI.size.setText("20");
                            String place = "";
                            for (int i = 0; i < 20; i++) {
                                place += "| ";
                            }
                            clientGUI.place.setText(place);
                            countWand = 20;
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }

                        if(isRun && !msgFromGame.equals("") && !msgFromGame.contains("left the game")
                        && !msgFromGame.contains("Next step You") && !msgFromGame.contains("Next step Enemy")
                        && !msgFromGame.equals("server fill")) {
                            String EnemyName = msgFromGame.substring(0,msgFromGame.length() - 3);
                            int minusValue = Integer.parseInt(msgFromGame.substring(msgFromGame.length() - 1));
                            clientGUI.result.setText(EnemyName + " take " + minusValue + " wands");
                            countWand -= minusValue;
                            String place = "";
                            for (int i = 0; i < countWand; i++) {
                                place += "| ";
                            }
                            //GUI
                            clientGUI.place.setText(place);
                            clientGUI.size.setText(String.valueOf(countWand));
                            clientGUI.result.setText("Left " + countWand + " wands");
                        }

                        try {
                            if(msgFromGame.substring(0, 6).equals("Starts")) isRun = true;
                        } catch (Exception e) {}


                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
            if(bufferedWriter != null) {
                bufferedWriter.close();
            }
            if(socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
