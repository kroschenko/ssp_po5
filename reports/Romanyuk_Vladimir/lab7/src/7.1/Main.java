package com.company;

import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        javax.swing.JFrame frame = new JFrame("7.1"); //создание окна приложения
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);//событие закрытия окна
        frame.setBounds(0, 0, 1000, 500);
        frame.setContentPane(new MyPanel()); //заменяет панель содержимого JFrame
        frame.setVisible(true);
    }
}
class MyPanel extends javax.swing.JPanel {
    private AffineTransform transformer;
    private AffineTransform transformerrotate;
    private class MyTimerTask extends TimerTask {
        int i = 0;
        @Override
        public void run() {
            transformer = AffineTransform.getTranslateInstance(i*10,0); //смещение на 10 по оси икс (по y - 0)
            transformerrotate = AffineTransform.getRotateInstance(i* 0.1, 150, 150); //поворачивает координаты вокруг точки привязки на угол в i*0.1 радиан
            transformer.concatenate(transformerrotate); //объединение для выполнения комбинированного преобразования
            i++;
            repaint();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //фундаментальный класс для того, чтобы представить 2-мерные формы, текст и изображения
        g2.transform(transformer);
        BasicStroke pen = new BasicStroke(3);
        g2.setStroke(pen); //устанавливаем ширину пера в 3
        g2.draw(new Line2D.Float(150, 150, 50, 50)); //создает и инициализирует линию по указанным координатам
    }
    public MyPanel() {
        Timer t = new Timer();
        t.schedule(new MyTimerTask(), 100, 100); //до начала выполнения MyTimerTask() пройдёт 100 мс (задержка) и он будет выполняться с периодом в 100 мс
    }
}