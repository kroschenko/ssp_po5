package com.company.three_task;

import java.util.Scanner;


/**
 * A test client.
 */
public class StackClient {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String item = scanner.next();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.println(s.pop() + " ");
            }
        }

        System.out.println(s.size());
    }
}
