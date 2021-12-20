
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.Timer;
 
public class Ball extends JPanel implements ActionListener {
    
    Timer timer = new Timer(10,this);
    int x=100;
    int y=150;
    int z=100;
    int c=100;
    int a = 0, b = 0;
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.red);
        g.fillOval(x, y, z, c);
        timer.start();
        if (a == 120)
        {
            b =+ 38;
            a = 0 - b;
        }
    }
    
    public static void main(String[] args) {
        Ball java = new Ball();
        JFrame frame = new JFrame("Bull");
        frame.setSize(500, 500);
        frame.add(java);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (a <= 40)
        {
            x++; y++; z--;
            z--; c--; c--; 
        }
        else 
        {
            x--; y--; z++;
            z++; c++; c++;
        }
        a++;
        repaint();
    }
 
    
}