package NordChat;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * This server can be run as a console application or as a GUI
 * To run as a console application just:
 * > java Server
 * > java Server portNumber
 * If the port number is not specified 1200-port is used
 */

public class Server {
    private static int uniqueId;                // An unique ID-code for each connection

    private ArrayList<ClientThread> clients;    // The list of the Clients

    private ServerGUI serverAsGUI;              // An object of ServerGUI (for gui running)

    private SimpleDateFormat simpleDateFormat;
    private int port;

    private boolean isRunning;                  // The state of the server (running/is stop)

    public Server(int port) {                   // For a console running
        this(port, null);
    }

    public Server(int port, ServerGUI serverAsGUI) {
        this.serverAsGUI = serverAsGUI;
        this.port = port;
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        clients = new ArrayList<ClientThread>();
    }

    public void start() {
        isRunning = true;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (isRunning) {
                display("Server is waiting for Guests on the " + port + " port.");
                Socket socket = serverSocket.accept();            // Accept the connection

                if (!isRunning)
                    break;

                ClientThread thread = new ClientThread(socket);  // Make a thread for it
                clients.add(thread);                             // Saving in the Clients list
                thread.start();
            }

            try {
                serverSocket.close();

                for (int i = 0; i < clients.size(); ++i) {
                    ClientThread clientThread = clients.get(i);
                    try {
                        clientThread.sInput.close();
                        clientThread.sOutput.close();
                        clientThread.socket.close();
                    }
                    catch (IOException ioException) {}
                }
            }
            catch (Exception exception) {
                display("Exception closing the server and guests: " + exception);
            }
        }

        catch (IOException ioException) {
            String message = simpleDateFormat.format(new Date())
                    + " IOException on the new ServerSocket: " + ioException + "\n";
            display(message);
        }
    }

    protected void stop() {
        isRunning = false;

        try {
            new Socket("localhost", port);
        }
        catch (Exception exception) {}
    }

    private void display(String message) {                  // Displaying the event
        String time = simpleDateFormat.format(new Date()) + " " + message;
        if (serverAsGUI == null)
            System.out.println(time);
        else
            serverAsGUI.appendEvent(time + "\n");
    }

    private synchronized void broadcast(String message) {
        String time = simpleDateFormat.format(new Date());
        String messageLf = time + " " + message + "\n";

        if (serverAsGUI == null)
            System.out.print(messageLf);
        else
            serverAsGUI.appendRoom(messageLf);          // Append in the room window

        for (int i = clients.size(); --i >= 0; ) {      // The loop in the reverse order because of the opportunity
                                                        // to deleting disconected guest
            ClientThread clientThread = clients.get(i);

            if (!clientThread.writeMessage(messageLf)) {
                clients.remove(i);
                display("Disconnected Guest " + clientThread.username);
            }
        }
    }

    synchronized void remove(int id) {
        for (int i = 0; i < clients.size(); ++i) {
            ClientThread clientThread = clients.get(i);

            if (clientThread.id == id) {
                clients.remove(i);
                return;
            }
        }
    }

    // ----

    public static void main(String[] args) {
        int portNumber = 1200;
        switch (args.length) {
            case 1:
                try {
                    portNumber = Integer.parseInt(args[0]);
                }
                catch (Exception exception) {
                    System.out.println("Invalid port number.");
                    System.out.println("Usage is: > java Server [portNumber]");
                    return;
                }
            case 0:
                break;
            default:
                System.out.println("Usage is: > java Server [portNumber]");
                return;
        }

        Server server = new Server(portNumber);
        server.start();
    }

    class ClientThread extends Thread {
        Socket socket;

        ObjectInputStream sInput;
        ObjectOutputStream sOutput;

        int id;
        String username;
        Message clientMessage;
        String currentDate;

        ClientThread(Socket socket) {
            id = ++uniqueId;
            this.socket = socket;

            System.out.println("Thread trying to create Object Input/Output Streams");
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());

                username = (String) sInput.readObject();
                display(username + " is connected.");
            }
            catch (IOException exception) {
                display("Exception creating new Input/output Streams: " + exception);
                return;
            }
            catch (ClassNotFoundException exception) {
            }

            currentDate = new Date().toString() + "\n";
        }

        public void run() {
            boolean keepGoing = true;
            while (keepGoing) {
                try {
                    clientMessage = (Message) sInput.readObject();
                }
                catch (IOException exception) {
                    display(username + " Exception reading Streams: " + exception);
                    break;
                }
                catch (ClassNotFoundException exception) {
                    break;
                }

                String message = clientMessage.getMessage();            // The message part

                switch (clientMessage.getType()) {                      // Switcher of the types
                    case Message.MESSAGE:
                        broadcast(username + ": " + message);
                        break;
                    case Message.LOGOUT:
                        display(username + " disconnected with a LOGOUT message.");
                        keepGoing = false;
                        break;
                    case Message.WHOISIN:
                        writeMessage("List of the guests connected at " + simpleDateFormat.format(new
                                Date()) + "\n");

                        for (int i = 0; i < clients.size(); ++i) {
                            ClientThread clientThread = clients.get(i);
                            writeMessage((i + 1) + ") " + clientThread.username + " since " +
                                    clientThread.currentDate);
                        }
                        break;
                }
            }

            remove(id);             // Removing adm-id
            close();
        }

        private void close() {
            try {
                if (sOutput != null)
                    sOutput.close();
            }
            catch (Exception exception) {}

            try {
                if (sInput != null)
                    sInput.close();
            }
            catch (Exception exception) {}

            try {
                if (socket != null)
                    socket.close();
            }
            catch (Exception exception) {}
        }

        private boolean writeMessage(String message) {
            if (!socket.isConnected()) {
                close();
                return false;
            }

            try {
                sOutput.writeObject(message);
            }
            catch (IOException exception) {
                display("Error sending message to " + username);
                display(exception.toString());
            }

            return true;
        }
    }
}
