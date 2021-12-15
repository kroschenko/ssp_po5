package com.spp.labs;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Lab7Ex1 extends JFrame {

    public Lab7Ex1() {
        setSize(800, 600);
        setTitle("Ex1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        MyAnimation panel = new MyAnimation();
        add(panel);
    }
    
    public static void main(String[] args) {
        new Lab7Ex1().setVisible(true);
    }
}

class MyAnimation extends JPanel {
    int x = 0;
    int step = -1;
    int y1_line = 100;
    int y2_line = 400;
    int degree = 1;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D ellipse = new Ellipse2D.Double(x, 250, 5, 5);
        g2.fill(ellipse);
        Line2D line = new Line2D.Double(ellipse.getCenterX(), y1_line, ellipse.getCenterX(), y2_line);
        g2.rotate(Math.toRadians(degree), ellipse.getCenterX(), ellipse.getCenterY());
        g2.draw(line);
        g2.dispose();
        degree++;
        if (x == 800 || x == 0) {
            step = -step;
        }
        x += step;
        repaint();
    }
}