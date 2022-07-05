package secondTask;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(500, 500);
        task2 panel = new task2(6);
        window.add(panel);
        window.setVisible(true);
    }
}