package com.company.tests;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter iterations: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Choose color: 1-red, 2-cyan, 3-pink, 4-blue");
        Color color;
        switch (sc.nextInt()) {
            case 1: color = Color.RED; break;
            case 2: color = Color.CYAN; break;
            case 3: color = Color.MAGENTA; break;
            case 4: color = Color.BLUE; break;
            default: color = Color.WHITE;
        }
        JFrame window = new JFrame("Levy");
        window.setSize(615, 605);
        window.setBackground(Color.BLACK);
        window.setContentPane(new LevyView(n, color));
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
