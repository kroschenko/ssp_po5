package main7.task2;

import javax.swing.*;
import java.awt.*;


public class Test {

    public static void main(String[] args) {
        JFrame f = new SierpinskiTriangle();
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

class SierpinskiTriangle extends JFrame {

    public SierpinskiTriangle() {
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        SierpinskiPanel sie = new SierpinskiPanel();
        add(sie);
        sie.setOrder(10);
    }

    private static class SierpinskiPanel extends JPanel {

        private int order = 0;

        private static void displayTriangles(Graphics g, int order,
                                             Point p1, Point p2, Point p3) {
            if (order == 0) {
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                g.drawLine(p1.x, p1.y, p3.x, p3.y);
                g.drawLine(p2.x, p2.y, p3.x, p3.y);
            } else {
                Point p12 = midPoint(p1, p2);
                Point p23 = midPoint(p2, p3);
                Point p31 = midPoint(p3, p1);
                displayTriangles(g, order - 1, p1, p12, p31);
                displayTriangles(g, order - 1, p12, p2, p23);
                displayTriangles(g, order - 1, p31, p23, p3);
            }
        }

        private static Point midPoint(Point p1, Point p2) {
            return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        }

        public void setOrder(int order) {
            this.order = order;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point p1 = new Point(getWidth() / 2, 10);
            Point p2 = new Point(getWidth() - 10, getHeight() - 10);
            Point p3 = new Point(10, getHeight() - 10);
            displayTriangles(g, order, p1, p2, p3);
        }
    }
}