package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import com.google.gson.*;

public class TcpClient {
    public static void main(String[] args) {
        String host = DEFAULT_HOST;
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            host = args[0];
        }
        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        try {
            Socket socket = new Socket(host, port);

            System.out.println("connected.\n");

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            GameWindow gamewindow = new GameWindow(out);
            gamewindow.pack();
            gamewindow.setVisible(true);

            while (true) {
                String fromServer = Common.readBytes(in);
                Gson gson = new Gson();

                Messages.Board boardMessage = gson.fromJson(fromServer, Messages.Board.class);

                if (boardMessage == null)
                    break;

                gamewindow.load(boardMessage);

                if (boardMessage.winner != '_')
                    break;
            }
        } catch (UnknownHostException e) {
            System.out.println("Неизвестный хост: " + host);
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Ошибка при подключении, сервер занят");
           // e.printStackTrace();
            System.exit(-1);
        }
    }

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 11122;
}
