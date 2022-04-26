package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;
    private int countWand;
    private boolean isRun;


    public Client(Socket socket, String username) {
        try {
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

    public void send(boolean isResult) {
        try {

            while (socket.isConnected()) {

                if(isResult) {
                    return;
                }
                else {
                    bufferedWriter.write(username);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    Scanner scanner = new Scanner(System.in);
                    String messageToSend = scanner.nextLine();
                    bufferedWriter.write(username + ": " + messageToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    int sendValue = Integer.parseInt(messageToSend.substring(messageToSend.length() - 1));

                    if(isRun && sendValue > 0 && sendValue < 4) {
                        countWand -= sendValue;
                        if(countWand < 1) {
                            return;
                        }
                        System.out.println("Left " + countWand + " wands");
                    }
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
                        msgFromGame = bufferedReader.readLine();

                        try {
                            if(msgFromGame.substring(0,6).equals("SERVER")) msgFromGame = "";

                        } catch (Exception e) {}


                        if(msgFromGame.equals("S-R: You Lose!!!")) {
                            isRun = false;
                            socket.close();
                            System.out.println(msgFromGame);
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }

                        if(msgFromGame.equals("S-R: You Winner!!!")) {
                            isRun = false;
                            socket.close();
                            System.out.println(msgFromGame);
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }

                        System.out.println(msgFromGame);

                        if(msgFromGame.contains("Server say:")) {
                            System.out.println("S-R: You Winner!!!");
                            isRun = false;
                            socket.close();
                            System.out.println(msgFromGame);
                            Thread.currentThread().stop();
                            send(true);
                            return;
                        }

                        if(isRun && !msgFromGame.equals("") && !msgFromGame.contains("left the game")) {
                            String EnemyName = msgFromGame.substring(0,msgFromGame.length() - 3);
                            int minusValue = Integer.parseInt(msgFromGame.substring(msgFromGame.length() - 1));
                            System.out.println(EnemyName + " take " + minusValue + " wands");

                            countWand -= minusValue;
                            System.out.println("Left " + countWand + " wands");
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

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for game: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 4004);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.send(false);
    }

}
