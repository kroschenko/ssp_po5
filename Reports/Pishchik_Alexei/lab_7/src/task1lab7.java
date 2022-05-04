import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class task1lab7 extends JFrame {
    public task1lab7() {
        add(new Rectangle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Rotate");
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new task1lab7();
    }
}

class Rectangle extends JComponent implements Runnable {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 120;
    private static final int X = 250;
    private static final int Y = 250;
    private long time = System.nanoTime();

    private Rectangle2D rectangle2D = new Rectangle2D.Double(X, Y, WIDTH, HEIGHT);
    private Double rotatePointX;
    private Double rotatePointY;

    public Rectangle() {
        super();
        rotatePointX = X * 1.0;
        rotatePointY = Y * 1.0;
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
        long tm = System.nanoTime() - time;
        double angle = tm / 300000000.0;
        rectangle2D.setFrame(X, Y, WIDTH, HEIGHT);
        g2d.rotate(angle, rotatePointX, rotatePointY);
        g2d.setColor(Color.PINK);
        g2d.fill(rectangle2D);
        g2d.draw(rectangle2D);
    }
}
