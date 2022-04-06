package com.company.tcp_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

public class TcpServer {

    public static void main(String[] args) {

        int port = DEFAULT_PORT;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Порт занят: " + port);
            System.exit(-1);
        }

        try {
            Player players[] = new Player[2];

            for (int i = 0; i < 2; ++i) {
                players[i] = new Player();
                players[i].waitConnection(serverSocket);
            }

            System.out.println("Game started...\n");

            GameBoard gameboard = new GameBoard();
            generateRandomTypes(players);

            while (true) {
                System.out.println("Gameboard on server: " + gameboard.toString() + "\n");

                for (int i = 0; i < 2; ++i) {
                    players[i].send(gameboard);
                }

                if (gameboard.getWinner() != '_')
                    break;

                Messages.Move move = null;
                for (int i = 0; i < 2; ++i) {
                    Messages.Move currentMove = players[i].readMoveIfActive(gameboard.currentMove());
                    if (currentMove == null)
                        continue;
                    move = currentMove;
                }
                gameboard.process(move);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    static void generateRandomTypes(Player[] players) {
        Random rnd = new Random();
        int value = rnd.nextInt(1);

        if (value == 0) {
            players[0].set_type('x');
            players[1].set_type('o');
        }
        else {
            players[0].set_type('o');
            players[1].set_type('x');
        }
    }

    private static final int DEFAULT_PORT = 11122;
}
