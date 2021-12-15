import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

class Circle extends JFrame {
    private int __x;
    private int __y;
    private int __windowX;
    private int __windowY;
    private int __diameter;
    private boolean __moveDown;
    
    public Circle(int windowX, int windowY, int diameter) {
        super("circle");
        setSize(windowX, windowY);
        setVisible(true);
        setResizable(false);
        
        __diameter = diameter;
        __windowX = windowX;
        __windowY = windowY;
        __x = 0;
        __y = __windowY - diameter;
        __moveDown = false;
    }
    
    public void paint(Graphics g) {
        g.fillRect(0, 0, __windowX, __windowY);
        g.setColor(Color.BLUE);
        g.drawOval(__x, __y, __diameter, __diameter);
    }

    public void run(){        
        while(true){   
            if(__x >= __windowX - __diameter | __y <= 0){
                __moveDown = true;
            }
            if(__x <= 0 || __y >= __windowY - __diameter){
                __moveDown = false;
            }
            
            if(!__moveDown){
                ++__x;
                --__y;
            } else {
                --__x;
                ++__y;
            }
            
            repaint();
            
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException e){
            }
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width : ");
        int windowX = sc.nextInt();
        System.out.print("Enter height : ");
        int windowY = sc.nextInt();
        System.out.print("Enter diameter : "); 
        int diameter = sc.nextInt();
        sc.close();

        Circle app = new Circle(windowX, windowY, diameter);
        app.run();
    }
}
