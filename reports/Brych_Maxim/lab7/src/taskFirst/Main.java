package taskFirst;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(350, 350);
        DrawPanel panel = new DrawPanel();
        window.add(panel);
        window.setVisible(true);
    }
}