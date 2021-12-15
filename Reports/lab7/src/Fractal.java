import javax.swing.*;
import java.awt.*;
import java.util.Random;

class PythagorasTree extends JPanel {
    private double __n;
    private double __m;
    private int __depth; 

    PythagorasTree(double n, double m, int depth) {
        __n = n;
        __m = m;
        __depth = depth;
    }
    
    public void setColor(Graphics g){
        Random rand = new Random();
        int randNum = rand.nextInt(5);
        if(randNum == 0){
            g.setColor(Color.RED);
        }
        else if(randNum == 1){
            g.setColor(Color.MAGENTA);
        }
        else if(randNum == 2){
            g.setColor(Color.GREEN);
        }
        else if(randNum == 3){
            g.setColor(Color.BLUE);
        }
        else if(randNum == 4){
            g.setColor(Color.YELLOW);
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        drawTree(320, 460, 200, Math.PI/2, g); 
    }

    private void drawTree(double x, double y, double L, double a, Graphics g) {
        setColor(g);
        if(L > __depth) {
            L = L * 0.7;
            g.drawLine((int)x, (int)y, (int)(x + L * Math.cos(a)), (int)(y - L * Math.sin(a)));
            x = x + L * Math.cos(a);
            y = y - L * Math.sin(a);   

            drawTree(x, y, L, a + Math.PI / __n, g);
            drawTree(x, y, L, a - Math.PI / __m, g);
        }
    }

}