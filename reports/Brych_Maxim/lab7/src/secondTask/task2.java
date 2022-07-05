package secondTask;

import java.awt.*;
import javax.swing.JPanel;

public class task2 extends JPanel {
    private static int numberLevelsOfRecursion;

    public task2(int numLevels) {
        numberLevelsOfRecursion = numLevels;
    }

    public void paintComponent(Graphics computerScreen) {
        super.paintComponent(computerScreen);
        Point top = new Point(250, 50);
        Point left = new Point(50, 450);
        Point right = new Point(450, 450);
        drawTriangle(computerScreen, numberLevelsOfRecursion, top, left, right);
    }

    public static void drawTriangle(Graphics g, int levels, Point top, Point left, Point right) {
        Point p1 = top;
        Point p2 = left;
        Point p3 = right;
        if (levels <= 2) {
            // base case: simple triangle
            Polygon tri = new Polygon();
            tri.addPoint(p1.x, p1.y);
            tri.addPoint(p2.x, p2.y);
            tri.addPoint(p3.x, p3.y);
            g.setColor(Color.BLACK);
            g.fillPolygon(tri);
        } else {
            // Get the midpoint on each edge in the triangle
            Point p12 = midpoint(p1, p2);
            Point p23 = midpoint(p2, p3);
            Point p31 = midpoint(p3, p1);
            // recurse on 3 triangular areas
            drawTriangle(g, levels - 1, p1, p12, p31);
            drawTriangle(g, levels - 1, p12, p2, p23);
            drawTriangle(g, levels - 1, p31, p23, p3);
        }
    }

    private static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}