package com.spp.labs;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Lab7Ex2 extends JFrame {

    public Lab7Ex2() {
        setSize(800, 600);
        setTitle("Ex2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        MyAnimation2 panel = new MyAnimation2();
        add(panel);
    }
    
    public static void main(String[] args) {
        new Lab7Ex2().setVisible(true);
    }
}

class MyAnimation2 extends JPanel {
    
    int height;
    int width;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        height = this.getHeight() - this.getHeight()/4;
        width = this.getWidth();
        int xStart = width/2 - height/2;
        drawSnowFlake(g2, 0, xStart, height);
    }
    
    private void drawSnowFlake(Graphics g, int lev, int xStart, int height) {
        drawSnow(g, lev, xStart + 20, height - 20, xStart + height - 20, height - 20);
        drawSnow(g, lev, xStart + height - 20, height - 20, xStart + height/2, 20);
        drawSnow(g, lev, xStart + height/2, 20, xStart + 20, height - 20);
    }
    
    private void drawSnow(Graphics g, int lev, int x1, int y1, int x5, int y5){
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (lev == 0){
            g.drawLine(x1, y1, x5, y5);
        }
        else{
            deltaX = x5 - x1;
            deltaY = y5 - y1;

            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;

            x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
            y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);

            x4 = x1 + 2 * deltaX /3;
            y4 = y1 + 2 * deltaY /3;

            drawSnow (g,lev-1, x1, y1, x2, y2);
            drawSnow (g,lev-1, x2, y2, x3, y3);
            drawSnow (g,lev-1, x3, y3, x4, y4);
            drawSnow (g,lev-1, x4, y4, x5, y5);
        }
    }
}