package NordChat;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Optional;

public class ClientGUI extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    private JLabel label;               // For username/enter message
    private JTextField textField;
    private JTextField tfServer, tfPort;
    private JButton login, logout, whoIsIn, private_chat;
    private JTextArea textArea;
    private boolean connected;
    private Client client;
    private int defaultPort;
    private String defaultHost;
    private boolean private_message = false;
    private int recipientId = 0;

    private String[] arrayData;
    private java.util.List<String> dialogData;
    private ChoiceDialog<String> dialog;
    JFXPanel fxPanel = new JFXPanel();
    private  boolean temp = true;

            ClientGUI(String host, int port) {                  // Receive a socket number
        super("Chat Client");
        defaultPort = port;
        defaultHost = host;

        JPanel nordPanel = new JPanel(new GridLayout(3,1));

        JPanel serverAndPort = new JPanel(new GridLayout(1,5, 1, 3));

        tfServer = new JTextField(host);
        tfPort = new JTextField("" + port);
        tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

        serverAndPort.add(new JLabel("Address: "));
        serverAndPort.add(tfServer);

        serverAndPort.add(new JLabel("Port: "));
        serverAndPort.add(tfPort);

        serverAndPort.add(new JLabel(""));

        nordPanel.add(serverAndPort);

        label = new JLabel("Enter your username ", SwingConstants.CENTER);
        nordPanel.add(label);

        textField = new JTextField("Guest");
        textField.setBackground(Color.WHITE);
        nordPanel.add(textField);

        add(nordPanel, BorderLayout.NORTH);

        textArea = new JTextArea("Welcome to the chat room\n", 70, 70);
        JPanel centralPanel = new JPanel(new GridLayout(1,1));
        centralPanel.add(new JScrollPane(textArea));

        textArea.setEditable(false);
        add(centralPanel, BorderLayout.CENTER);

        login = new JButton("Login");
        login.addActionListener(this);

        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setEnabled(false);

        whoIsIn = new JButton("Who is in");
        whoIsIn.addActionListener(this);
        whoIsIn.setEnabled(false);

        private_chat = new JButton("Private chat");
        private_chat.addActionListener(this);
        private_chat.setEnabled(false);

        JPanel downPanel = new JPanel();
        downPanel.add(login);
        downPanel.add(logout);
        downPanel.add(whoIsIn);
        downPanel.add(private_chat);

        add(downPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 400);
        setVisible(true);

        textField.requestFocus();
    }

    void append(String str) {           // Appending the text in the TextArea
        textArea.append(str);
        textArea.setCaretPosition(textArea.getText().length() - 1);
    }

    void setDlgDate(String str) {
        arrayData = str.split(";");
    }

    void connectionFailed() {
        login.setEnabled(true);
        logout.setEnabled(false);
        whoIsIn.setEnabled(false);
        private_chat.setEnabled(false);

        label.setText("Enter your username");
        textField.setText("Guest");

        tfPort.setText("" + defaultPort);tfServer.setText(defaultHost);

        tfServer.setEditable(true);
        tfPort.setEditable(true);

        textField.removeActionListener(this);
        connected = false;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object tempObject = event.getSource();

        if (tempObject == logout) {
            connectionFailed();
            client.sendMessage(new Message(Message.LOGOUT, ""));
            return;
        }

        if (tempObject == whoIsIn) {
            client.sendMessage(new Message(Message.WHOISIN, ""));
            return;
        }

        if (tempObject == private_chat) {
            if (private_chat.getText().equals("Public chat")) {
                System.out.println("Public chat");
                private_message = false;
                private_chat.setText("Private chat");
                label.setText("Enter your message below");

//                thread.stop();
            } else {
                System.out.println("Private chat");
                client.sendMessage(new Message(Message.WHO_IS_IN_TO_PRIVATE, ""));

                SwingUtilities.invokeLater(()->{
                    new JFXPanel();
                    System.out.println("invokeLater");
                    Runnable runnable = () -> {
                        dialogData = Arrays.asList(arrayData);
                        System.out.println(dialogData);
                        if (temp)
                            dialog = new ChoiceDialog<>(dialogData.get(0), dialogData);
                        dialog.setTitle("Private message");
                        dialog.setHeaderText("Select your interlocutor");
                        System.out.println("Platform");
                        Optional<String> result = dialog.showAndWait();
                        String selected;
                        if (result.isPresent()) {
                            selected = result.get();
                            label.setText("Enter your message below for " + selected.substring(3));
                            private_message = true;
                            recipientId = Integer.parseInt(selected.substring(0, 1)) - 1;
                            private_chat.setText("Public chat");
//                            temp = false;
                        }
                    };
                    System.out.println("runLater");
                    Platform.runLater(runnable);
                });
//                Task<Void> task = new Task<Void>() {
//                    @Override
//                    protected Void call() throws Exception {
//                        System.out.println("task");
//                        if (dialog == null) {
//                            System.out.println("task dlg null");
//                            return null;
//                        }
//                        dialogData = Arrays.asList(arrayData);
//                        System.out.println(dialogData);
//
//                        Platform.startup(() ->{
//
//                            ChoiceDialog<String> dialog = new ChoiceDialog<>(dialogData.get(0), dialogData);
//                            dialog.setTitle("Private message");
//                            dialog.setHeaderText("Select your interlocutor");
//                            Optional<String> result = dialog.showAndWait();
//                            String selected;
//                            if (result.isPresent()) {
//                                selected = result.get();
//                                label.setText("Enter your message below for " + selected.substring(3));
//                                private_message = true;
//                                recipientId = Integer.parseInt(selected.substring(0, 1)) - 1;
//                                private_chat.setText("Public chat");
//                            }
//                        });
//                        return null;
//                    }
//                };
//                if (!temp) {
//                    System.out.println("task start");
//                    new Thread(task).start();
//                }
//                Platform.runLater(() -> {
//                    dialogData = Arrays.asList(arrayData);
//                    System.out.println(dialogData);
//                    dialog = new ChoiceDialog<>(dialogData.get(0), dialogData);
//                    dialog.setTitle("Private message");
//                    dialog.setHeaderText("Select your interlocutor");
//                    System.out.println("Platform");
//                    Optional<String> result = dialog.showAndWait();
//                    String selected;
//                    if (result.isPresent()) {
//                        selected = result.get();
//                        label.setText("Enter your message below for " + selected.substring(3));
//                        private_message = true;
//                        recipientId = Integer.parseInt(selected.substring(0, 1)) - 1;
//                        private_chat.setText("Public chat");
//                        temp = false;
//                    }
//                });


//                thread.setDaemon(true);
//                thread.start();

            }

            return;
        }

        if (connected) {                 // Come from the JTextField
            if (private_message)
                client.sendMessage(new Message(Message.PRIVATE_MESSAGE, textField.getText(), recipientId));
            else
                client.sendMessage(new Message(Message.MESSAGE, textField.getText()));
            textField.setText("");
            return;
        }

        if (tempObject == login) {
            String username = textField.getText().trim();           // A connection request

            if (username.length() == 0)
                return;

            String server = tfServer.getText().trim();
            if (server.length() == 0)
                return;

            String portNumber = tfPort.getText().trim();
            if (portNumber.length() == 0)
                return;

            int port = 0;
            try {
                port = Integer.parseInt(portNumber);
            }
            catch(Exception exception) {
                return;
            }

            client = new Client(server, port, username, this);

            if (!client.start())
                return;

            client.sendMessage(new Message(Message.WHO_IS_IN_TO_PRIVATE, ""));
            textField.setText("");
            label.setText("Enter your message below");
            connected = true;

            login.setEnabled(false);

            logout.setEnabled(true);
            whoIsIn.setEnabled(true);
            private_chat.setEnabled(true);

            tfServer.setEditable(false);
            tfPort.setEditable(false);

            textField.addActionListener(this);      // Action listener for when the user enter a message
        }
    }

    public static void main(String[] args) {
        new ClientGUI("localhost", 1200);
    }    // Start the whole server
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }
}

