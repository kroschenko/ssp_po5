
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Figure extends JFrame {

    private int[] xPoints = new int[]{0, 50, 110};
    private int[] yPoints = new int[]{90, 0, 100};

    double angle = 0f;

    public Figure() {
        super("Triangle rotation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawTrianglePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawTrianglePanel extends JPanel {

        private Point clickPoint;
        private long t = System.nanoTime();

        public DrawTrianglePanel() {
            clickPoint = new Point(100, 100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 250);
        }

        protected Dimension getTriangleSize() {

            int maxX = 0;
            int maxY = 0;
            for (int index = 0; index < xPoints.length; index++) {
                maxX = Math.max(maxX, xPoints[index]);
            }
            for (int index = 0; index < yPoints.length; index++) {
                maxY = Math.max(maxY, yPoints[index]);
            }
            return new Dimension(maxX, maxY);
        }

        /**
         * Drawing the triangle.
         *
         * @param g the g
         * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            AffineTransform at = new AffineTransform();
            Dimension size = getTriangleSize();
            int x = clickPoint.x - (size.width / 2);
            int y = clickPoint.y - (size.height / 2);
            at.translate(x, y);
            at.rotate(Math.toRadians(angle), clickPoint.x - x, clickPoint.y - y);
            g2d.setTransform(at);
            g2d.drawPolygon(xPoints, yPoints, 3);

            g2d.setColor(Color.RED);
            g2d.drawLine(size.width / 2 - 5, 0, size.width / 2, size.height / 2);
            g2d.dispose();
            
            long tm = System.nanoTime() - t;
            double Angle = tm / 300000000.0;            
            double sn = Math.cos(Angle);
            double cs = Math.sin(Angle);
            int x1 = (int) (75 * cs + 130);
            int y1 = (int) (75 * sn + 120);
            angle = -Math.toDegrees(Math.atan2(x1 - clickPoint.x, y1 - clickPoint.x)) + 180;
            repaint();
        }

    }
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                new Figure();
            }
            });
        }
}