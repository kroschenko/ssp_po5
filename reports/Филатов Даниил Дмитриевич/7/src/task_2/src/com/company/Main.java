package com.company;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main
{
    public static void main(String[] args) {
        JFrame window = new JFrame("Dragons");
        window.setSize(600, 600);
        System.out.println("Enter number of iterations: ");
        window.setContentPane(new DragonView(new Scanner(System.in).nextInt()));
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
        System.out.println("привет");
    }
}
