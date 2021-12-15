import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

class Lab2 extends JFrame {;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle by x (1-10) : Pi/");
        double n = sc.nextInt();
        System.out.print("ENter angle by y (1-10) : Pi/");
        double m = sc.nextInt();
        System.out.print("Enter recursion depth : "); // чем больше коэф. тем меньше шагов рекурсии
        int depth = sc.nextInt();

        JFrame window = new JFrame("Pythagoras tree");
        window.setSize(620, 600);
        window.setBackground(Color.BLACK);
        window.setContentPane(new PythagorasTree(n, m, depth));
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}