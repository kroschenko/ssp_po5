package taskFirst;

import javax.swing.JComponent;
import java.awt.geom.Rectangle2D;
import java.awt.*;

public class DrawPanel extends JComponent implements Runnable {
    private static final int WEIGHT = 200;
    private static final int HEIGHT = 70;
    private static final int X = 160;
    private static final int Y = 175;
    private long t = System.nanoTime();
    private Rectangle2D rectangle2D = new Rectangle2D.Double(X, Y, WEIGHT, HEIGHT);
    private Double x = 0.0;
    private Double y = 0.0;
    private Double centerOfGravityX;
    private Double centerOfGravityY;

    /**
     * Instantiates a new Draw panel.
     */
    public DrawPanel() {
        super();
        centerOfGravityX = X * 0.5 + (WEIGHT + X) * 0.5;
        centerOfGravityY = Y * 0.5 + (HEIGHT + Y) * 0.5;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        long tm = System.nanoTime() - t;
        double angle = tm / 300000000.0;
        rectangle2D.setFrame(X, Y, WEIGHT, HEIGHT);
        g2d.rotate(angle, centerOfGravityX, centerOfGravityY);
        g2d.draw(rectangle2D);
    }
}