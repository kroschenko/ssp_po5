package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final ArrayList<String> strings = new ArrayList<String>();
        strings.add("Задать движение по экрану строк");
        strings.add("(одна за другой)");
        strings.add("из массива строк");
        strings.add("направление движения по апплету");
        strings.add("и значение каждой строки");
        strings.add("выбирается случайным образом");

        final JFrame frame = new JFrame("Движение по экрану строк");
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setVisible(true);
        frame.setLayout(null);
        final JLabel lbl = new JLabel();
        lbl.setLocation(-1, 0);
        lbl.setSize(300, 20);
        frame.add(lbl);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        Timer timer = new Timer(50, new ActionListener() {
            int speedX, speedY;
            Random rnd = new Random();
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Point loc = lbl.getLocation();
                if (loc.x > frame.getWidth() || loc.y > frame.getHeight() || loc.x < 0
                        || loc.y < 0) {
                    lbl.setLocation(frame.getWidth()/2, frame.getHeight()/2);
                            speedX = -5+rnd.nextInt(10);
                    speedY = -5+rnd.nextInt(10);
                    lbl.setText(strings.get(rnd.nextInt(strings.size()-1)));
                } else {
                    lbl.setLocation(loc.x + speedX, loc.y + speedY);
                }
            }});
        timer.start();
    }
}