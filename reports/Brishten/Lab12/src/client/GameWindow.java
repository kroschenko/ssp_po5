package com.company;

import java.awt.Dimension;
import java.io.OutputStream;
import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(OutputStream socketOut) {
        super("Game Window");
        createGUI(socketOut);
    }

    private void createGUI(OutputStream socketOut) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel gridPanel = new JPanel(new GridLayout(Size, Size, 2, 2));
        gridPanel.setBackground(Color.orange);

        m_message = new JLabel("Ожидайте подключения противника...");
        m_message.setPreferredSize(new Dimension(600, 40));
        m_message.setMinimumSize(new Dimension(100, 20));

        gridPanel.setPreferredSize(new Dimension(600, 600));

        mainPanel.add(m_message, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.SOUTH);

        m_buttons = new GameButton[3][];
        for (int i = 0; i < 3; i++) {
            m_buttons[i] = new GameButton[3];
            for (int j = 0; j < 3; j++) {
                m_buttons[i][j] = new GameButton(i, j, socketOut);
                m_buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
                m_buttons[i][j].setEnabled(false);

                gridPanel.add(m_buttons[i][j]);
            }
        }
        setSize(600, 600);
    }

    public void load(Messages.Board boardMessage) {
        boolean isActive = boardMessage.move == boardMessage.your_type;

        if (isActive == true) {
            m_message.setText("Ваша фигура: " + boardMessage.your_type + ". Ваш ход");
        }
        else {
            m_message.setText("Ваша фигура: " + boardMessage.your_type + ". Ждите. Ходит противник");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = boardMessage.gameboard.charAt(i*Size + j);
                if (c == '_')
                    c = ' ';
                m_buttons[i][j].setText("" + c);
                m_buttons[i][j].setEnabled(isActive);
            }
        }

        if (boardMessage.winner != '_') {
            if (boardMessage.winner == boardMessage.your_type)
                m_message.setText("Конец игры. Вы выиграли");
            else {
                m_message.setText("Конец игры. Вы проиграли");
            }
            return;
        }
    }

    private GameButton[][] m_buttons;
    private JLabel m_message;
    public final int Size = 3;
}
