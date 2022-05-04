package NordChat;

import java.net.*;
import java.io.*;
import java.util.*;

/*
 * To start the Client-part in console mode use one of the following command
 * > java Client
 * > java Client username
 * > java Client username portNumber
 * > java Client username portNumber serverAddress
 * at the console prompt
 * If the portNumber is not specified 1200 is used
 * If the serverAddress is not specified "localHost" is used
 * If the username is not specified "Guest" is used
 * > java Client
 * > java Client Anonymous 1200 localhost
 */

public class Client {
    private ObjectInputStream sInput;               // To read from the socket
    private ObjectOutputStream sOutput;             // To write to the socket

    private Socket socket;

    private ClientGUI clientGUI;

    private String server, username;
    private int port;

    Client(String server, int port, String username) {
        this(server, port, username, null);
    }

    Client(String server, int port, String username, ClientGUI clientGUI) {
        if (clientGUI != null) {
            this.clientGUI = clientGUI;
        }
        this.server = server;
        this.port = port;
        this.username = username;
    }

    public boolean start() {
        try {
            socket = new Socket(server, port);
        }

        catch (Exception exception) {
            display("Error connectiong to server:" + exception);
            return false;
        }

        String message = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        display(message);

        try {
            sInput = new ObjectInputStream(socket.getInputStream());        // Creating data streams
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException IOException) {
            display("Exception creating new Input/output Streams: " + IOException);
            return false;
        }

        new ListenFromServer().start();                 // Create the thread to listen from the server

        try {
            sOutput.writeObject(username);
        }
        catch (IOException IOException) {
            display("Exception doing login : " + IOException);
            disconnect();
            return false;
        }

        return true;
    }

    private void display(String message) {          // To send a message to the console or to the GUI
        if (clientGUI == null)
            System.out.println(message);            // Console mode
        else {
            if (message.startsWith("DLG:"))
                clientGUI.setDlgDate(message.substring(4));
            else {

                clientGUI.append(message + "\n");       // ClientGUI JTextArea
            }
        }
    }

    void sendMessage(Message message) {             // Send to the server
        try {
            sOutput.writeObject(message);
        }
        catch (IOException exception) {
            display("Exception writing to server: " + exception);
        }
    }

    private void disconnect() {
        try {
            if (sInput != null) sInput.close();
        }
        catch (Exception exception) {}
        try {
            if (sOutput != null) sOutput.close();
        } catch (Exception exception) {
        }
        try {
            if (socket != null) socket.close();
        }
        catch (Exception exception) {}

        if (clientGUI != null)                          // Inform the GUI-part
            clientGUI.connectionFailed();
    }

    public static void main(String[] args) {
        int portNumber = 1200;
        String serverAddress = "localhost";
        String userName = "Guest";

        switch (args.length) {
            case 3:
                serverAddress = args[2];
            case 2:
                try {
                    portNumber = Integer.parseInt(args[1]);
                }
                catch (Exception exception) {
                    System.out.println("Invalid port number.");
                    System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
                    return;
                }
            case 1:
                userName = args[0];
            case 0:
                break;
            default:
                System.out.println("Usage is: > java Client [username] [portNumber] {serverAddress]");
                return;
            }

            Client client = new Client(serverAddress, portNumber, userName);

            if (!client.start())
                return;

            Scanner scan = new Scanner(System.in);      // Waiting for messages from the user

            while (true) {
                System.out.print("> ");

                String message = scan.nextLine();           // Reading the message

                if (message.equalsIgnoreCase("LOGOUT")) {
                    client.sendMessage(new Message(Message.LOGOUT, ""));
                    break;
                }
                else if (message.equalsIgnoreCase("WHOISIN")) {
                    client.sendMessage(new Message(Message.WHOISIN, ""));
                }
                else {
                    client.sendMessage(new Message(Message.MESSAGE, message));
                }
            }

            client.disconnect();
        }

    class ListenFromServer extends Thread {     // Waits for the message from the server and append them to the
                                                // JTextArea or to the console mode
        public void run() {
            while (true) {
                try {
                    String message = (String) sInput.readObject();
                    if (clientGUI == null) {
                        System.out.println(message);
                        System.out.print("> ");
                    }
                    else {
                        if (message.startsWith("DLG:"))
                            clientGUI.setDlgDate(message.substring(4));
                        else
                            clientGUI.append(message);
                    }
                }
                catch (IOException exception) {
                    display("Server has close the connection: " + exception);
                    if (clientGUI != null)
                        clientGUI.connectionFailed();
                    break;
                }
                catch (ClassNotFoundException exception) {}
            }
        }
    }
}

