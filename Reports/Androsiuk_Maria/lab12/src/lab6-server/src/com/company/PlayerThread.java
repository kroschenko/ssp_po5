package com.company;

import java.io.*;
import java.net.Socket;

public class PlayerThread extends Thread {

    private final BufferedReader reader;
    private final BufferedWriter writer;
    private MessageListener messageListener;

    public PlayerThread(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void setMessageListener(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @Override
    public void run() {
        try {
            while (true) {
                messageListener.processMessage(reader.readLine());
            }
        } catch (IOException ignored) {}
    }

    public void sendMessage(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException ignored) {}
    }
}
