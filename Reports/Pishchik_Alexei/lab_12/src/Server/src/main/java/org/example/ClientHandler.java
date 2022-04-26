package org.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>(2);
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    private int countWand;
    private boolean isFlag;

    private int startedPlayer;
    private int secondPlayer;

    int currentWands;


    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            this.countWand = 20;
            this.isFlag = false;
            this.startedPlayer = 2;
            this.secondPlayer = 2;
            clientHandlers.add(this);
            if(clientHandlers.size() > 2) {
                broadcastMessageToOnePlayers(clientHandlers.get(2), "server fill");
                clientHandlers.remove(2);
                return;
            }
            System.out.println(clientHandlers.size() + "/2 players");
            broadcastAllPlayers ("Server: " + clientUsername + " has entered the game!");
            if(clientHandlers.size() == 2) {
                System.out.println("NEW GAME INIT*******************************************************");
                int started = Random();
                int second;
                broadcastAllPlayers("Starts the game " + clientHandlers.get(started).clientUsername);
                clientHandlers.get(started).isFlag = true;
                for (ClientHandler clientHand : clientHandlers) {
                    if(started == 0) second = 1;
                    else second = 0;
                    broadcastMessageToOnePlayers(clientHandlers.get(second), "Next step Enemy");

                    clientHand.startedPlayer = started;
                    clientHand.secondPlayer = second;
                }
            }

        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while(socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();

                if(messageFromClient == null) {
                    removeClientHandler();
                    return;
                }
                else broadcastMessage(messageFromClient);

            } catch (IOException e) {}
        }
    }

    public void broadcastAllPlayers(String Message) {
        try {
            for (ClientHandler clientHandler : clientHandlers) {
                clientHandler.bufferedWriter.write(Message);
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            }
        } catch (IOException e) {}
        System.out.println(Message);
    }

    public void minusValue(String messageToSend) {
        for (ClientHandler clientHand : clientHandlers) {
            switch (messageToSend.substring(messageToSend.length() - 1)) {
                case "1":
                    clientHand.countWand -= 1;
                    break;
                case "2":
                    clientHand.countWand -= 2;
                    break;
                case "3":
                    clientHand.countWand -= 3;
                    break;
                default:
                    currentWands = clientHand.countWand;
                    clientHand.countWand = 999;
            }
        }
    }

    public int send(ClientHandler clientHandler, ClientHandler sec, String currentName, String messageToSend) {

        if(clientHandler.countWand == 999) {
            clientHandler.countWand = currentWands;
            sec.countWand = currentWands;
            return 0;
        }
        if(clientHandler.countWand == 1) {
            try {
                clientHandler.bufferedWriter.write("S-R: You Lose!!!");
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();

                sec.bufferedWriter.write("S-R: You Winner!!!");
                sec.bufferedWriter.newLine();
                sec.bufferedWriter.flush();
            }  catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
            System.out.println(clientHandler.clientUsername + " Lose!!!");
            clientHandlers.clear();
            System.out.println("Server clean!");
            return 2;
        }

        if(clientHandler.countWand < 1) {
            try {
                sec.bufferedWriter.write("S-R: You Lose!!!");
                sec.bufferedWriter.newLine();
                sec.bufferedWriter.flush();

                clientHandler.bufferedWriter.write("S-R: You Winner!!!");
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            }  catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
            System.out.println(sec.clientUsername + " Lose!!!");
            clientHandlers.clear();
            System.out.println("Server clean!");
            return 2;
        }
        else {
            try {
                clientHandler.bufferedWriter.write(currentName + ": " + messageToSend.substring(messageToSend.length() - 1));
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }

            System.out.println("Left " + clientHandler.countWand + " wands");
            return 1;
        }
    }


    public void broadcastMessageToOnePlayers(ClientHandler clientHandler, String Message) {
        try {
            clientHandler.bufferedWriter.write(Message);
            clientHandler.bufferedWriter.newLine();
            clientHandler.bufferedWriter.flush();
        } catch (IOException e) {}
    }


    public void broadcastMessage(String messageToSend) {

        try {
            if(messageToSend == null) {
                return;
            }
            System.out.println(messageToSend); // out in server
            if(clientHandlers.size() == 2) {
                String currentName = messageToSend.substring(0,messageToSend.length() - 3);
                ClientHandler clientHandler; // revievPlayer
                ClientHandler sender; // senderPlayer
                if(clientHandlers.get(startedPlayer).isFlag && currentName.equals(clientHandlers.get(startedPlayer).clientUsername)) {
                    int result;
                    minusValue(messageToSend);
                    sender = clientHandlers.get(startedPlayer);
                    clientHandler = clientHandlers.get(secondPlayer);

                    result = send(clientHandler, sender, currentName, messageToSend);
                    if(result == 1) {
                        System.out.println(currentName + " sends " + clientHandler.clientUsername);

                        broadcastMessageToOnePlayers(clientHandler, "Next step You");
                        broadcastMessageToOnePlayers(sender, "Next step Enemy");

                        clientHandlers.get(startedPlayer).isFlag = false;
                        clientHandlers.get(secondPlayer).isFlag = true;
                    }
                    if(result == 2) {
                        removeClientHandler();
                    }
                }
                if(clientHandlers.get(secondPlayer).isFlag && currentName.equals(clientHandlers.get(secondPlayer).clientUsername)) {
                    int result;
                    minusValue(messageToSend);
                    sender = clientHandlers.get(secondPlayer);
                    clientHandler = clientHandlers.get(startedPlayer);

                    result = send(clientHandler, sender, currentName, messageToSend);
                    if(result == 1) {
                        System.out.println(currentName + " sends " + clientHandler.clientUsername);

                        broadcastMessageToOnePlayers(clientHandler, "Next step You");
                        broadcastMessageToOnePlayers(sender, "Next step Enemy");

                        clientHandlers.get(secondPlayer).isFlag = false;
                        clientHandlers.get(startedPlayer).isFlag = true;
                    }
                    if(result == 2) {
                        removeClientHandler();
                    }
                }
            }
        } catch (Exception e) {}
    }

    public void removeClientHandler() {
        int n = clientHandlers.size();
        clientHandlers.remove(this);
        if(n != clientHandlers.size()) broadcastAllPlayers("Server say: " + clientUsername + " has left the game!");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
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

        } catch (IOException e) {}
    }

    private int Random() {
        return new Random().nextInt(2);
    }
}
