package com.company;

import java.io.OutputStream;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.Gson;

public class GameButton extends JButton {
    public GameButton(int x, int y, OutputStream socketOut) {
        super("");
        m_x = x;
        m_y = y;
        m_socketOut = socketOut;

        addActionListener(new MoveActionListener());
    }

    public class MoveActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Gson gson = new Gson();

            Messages.Move moveMessage = new Messages.Move();
            moveMessage.x = m_x;
            moveMessage.y = m_y;

            Common.writeBytes(m_socketOut, gson.toJson(moveMessage));
        }
    }

    private int m_x, m_y;
    private OutputStream m_socketOut;
}

