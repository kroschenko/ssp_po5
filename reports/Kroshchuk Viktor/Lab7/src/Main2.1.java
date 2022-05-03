package com.company;

import javax.swing.*;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Dragons");
        window.setSize(600, 600);
        for(int i = 0; i < 5; i++){
            System.out.print("Enter number of iterations: ");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            window.setContentPane(new DragonView(n));
            window.setResizable(false);
            window.setDefaultCloseOperation(EXIT_ON_CLOSE);
            window.setVisible(true);
        }
        System.out.println("End");
    }
}
