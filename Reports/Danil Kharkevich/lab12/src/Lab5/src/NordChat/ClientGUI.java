package NordChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JLabel label;               // For username/enter message

    private JTextField textField;

    private JTextField tfServer, tfPort;

    private JButton login, logout, whoIsIn;

    private JTextArea textArea;

    private boolean connected;

    private Client client;

    private int defaultPort;
    private String defaultHost;

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

        JPanel downPanel = new JPanel();
        downPanel.add(login);
        downPanel.add(logout);
        downPanel.add(whoIsIn);

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

    void connectionFailed() {
        login.setEnabled(true);
        logout.setEnabled(false);
        whoIsIn.setEnabled(false);

        label.setText("Enter your username");
        textField.setText("Guest");

        tfPort.setText("" + defaultPort);tfServer.setText(defaultHost);

        tfServer.setEditable(false);
        tfPort.setEditable(false);

        textField.removeActionListener(this);
        connected = false;
    }

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

        if (connected) {                 // Come from the JTextField
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

            textField.setText("");label.setText("Enter your message below");
            connected = true;

            login.setEnabled(false);

            logout.setEnabled(true);
            whoIsIn.setEnabled(true);

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
