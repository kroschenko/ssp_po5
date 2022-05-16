package com.company.tcp_server;

import java.net.Socket;
import com.google.gson.Gson;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Player {
    Player() {
        m_clientSocket = null;
        m_in = null;
        m_out = null;
        m_playerType = '_';
    }

    void waitConnection(ServerSocket serverSocket) throws IOException {
        m_clientSocket = serverSocket.accept();
        System.out.print("Connection accepted.\n");

        m_in = m_clientSocket.getInputStream();
        m_out = m_clientSocket.getOutputStream();
    }

    void send(GameBoard board) {
        Gson gson = new Gson();

        Messages.Board boardMessage = new Messages.Board();
        boardMessage.gameboard = board.toString();

        boardMessage.your_type = m_playerType;
        boardMessage.move = board.currentMove();
        boardMessage.winner = board.getWinner();

        Common.writeBytes(m_out, gson.toJson(boardMessage));
    }

    void set_type(char type) {
        m_playerType = type;
    }

    Messages.Move readMoveIfActive(char currentPlayerType) {
        if (m_playerType != currentPlayerType)
            return null;

        String buffer = Common.readBytes(m_in);

        Gson gson = new Gson();
        return gson.fromJson(buffer, Messages.Move.class);
    }

    private OutputStream m_out;
    private InputStream m_in;
    private Socket m_clientSocket;
    private char m_playerType;
}
