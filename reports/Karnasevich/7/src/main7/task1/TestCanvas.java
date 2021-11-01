package main7.task1;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static java.lang.Math.*;


public final class TestCanvas extends Canvas {

    private final double angle = 0.001;

    private final AffineTransform affineTransform = new AffineTransform(
            cos(angle),
            sin(angle),
            -sin(angle),
            cos(angle),
            200 - 200 * cos(angle) + 200 * sin(angle),
            200 - 200 * cos(angle) - 200 * sin(angle));

    private Shape rectangle = new Rectangle(100, 100, 200, 200);

    @Override
    public void paint(Graphics g) {
        while (true) {
            var g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.clearRect(0, 0, getWidth(), getHeight());
            rectangle = affineTransform.createTransformedShape(rectangle);
            g2d.setColor(Color.black);
            g2d.fill(rectangle);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
