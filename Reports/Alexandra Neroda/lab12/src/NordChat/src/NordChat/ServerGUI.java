package NordChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerGUI extends JFrame implements ActionListener, WindowListener {
    private static final long serialVersionUID = 1L;

    private JButton stopStart;
    private JTextArea chat, event;
    private JTextField tPortNumber;
    private Server server;

    ServerGUI(int port) {
        super("NordChat (Server)");
        server = null;

        JPanel nord = new JPanel();

        nord.add(new JLabel("Port: "));

        tPortNumber = new JTextField(" " + port);
        nord.add(tPortNumber);

        stopStart = new JButton("Start");
        stopStart.addActionListener(this);
        nord.add(stopStart);

        add(nord, BorderLayout.NORTH);                              // The event and chat room

        JPanel center = new JPanel(new GridLayout(2, 1));

        chat = new JTextArea(90, 90);
        chat.setEditable(false);
        appendRoom("Chating room\n");
        center.add(new JScrollPane(chat));

        event = new JTextArea(90, 90);
        event.setEditable(false);
        appendEvent("Events log.\n");

        center.add(new JScrollPane(event));
        add(center);

        addWindowListener(this);
        setSize(400, 500);
        setVisible(true);
    }

    void appendRoom(String str) {                   // Append a message to the two JTextAreas
        chat.append(str);
        chat.setCaretPosition(chat.getText().length() - 1);
    }

    void appendEvent(String str) {
        event.append(str);
        event.setCaretPosition(chat.getText().length() - 1);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (server != null) {
            server.stop();
            server = null;
            tPortNumber.setEditable(true);
            stopStart.setText("Starting");

            return;
        }

        int port = 0;
        try {
            port = Integer.parseInt(tPortNumber.getText().trim());
        }
        catch (Exception exception) {
            appendEvent("Invalid port number");

            return;
        }

        server = new Server(port, this);

        new ServerRunning().start();

        stopStart.setText("Stop");
        tPortNumber.setEditable(false);
    }

    public static void main(String[] arg) {             // Starting the server
        new ServerGUI(1200);
    }

    @Override
    public void windowClosing(WindowEvent event) {      // Closing by Windows event
        if (server != null) {
            try {
                server.stop();
            }
            catch (Exception eClose) {}
            server = null;
        }

        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent event) {}
    @Override
    public void windowOpened(WindowEvent event) {}
    @Override
    public void windowIconified(WindowEvent event) {}
    @Override
    public void windowDeiconified(WindowEvent event) {}
    @Override
    public void windowActivated(WindowEvent event) {}
    @Override
    public void windowDeactivated(WindowEvent event) {}

    class ServerRunning extends Thread {
        @Override
        public void run() {
            server.start();                         // Should executing until if fails

            stopStart.setText("Start");
            tPortNumber.setEditable(true);
            appendEvent("Server is stopped\n");
            server = null;
        }
    }
}
