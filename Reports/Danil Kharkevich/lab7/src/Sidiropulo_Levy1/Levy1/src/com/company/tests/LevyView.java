package com.company.tests;

import javax.swing.*;
import java.awt.*;

public class LevyView extends JPanel {
    private int iterations;
    private Color color;
    LevyView(int n, Color col) {
        iterations = n;
        color = col;
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        drawLevy(150, 350, 450, 350, iterations, color, g);//25-количество итераций
    }
    private void drawLevy(int x1, int y1, int x2, int y2, int n, Color color, Graphics g ) {//Основная рекурсивная функция
        g.setColor(color);
        if (n == 0) g.drawLine(x1, y1, x2, y2);
        else {
            int xx = (x1 + x2) / 2 + (y2 - y1) / 2;//Находим точки для дальнейшего разбиения и поворота
            int yy = (y1 + y2) / 2 - (x2 - x1) / 2;
            drawLevy(x1, y1, xx, yy, n - 1, color, g);
            drawLevy(xx, yy, x2, y2, n - 1, color, g);
        }
    }
}

