package main1;

import java.util.Scanner;
import java.util.stream.Collectors;


public class App2 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        var input = scanner.next();
        if (pangramEng(input)) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not pangram");
        }
    }

    public static boolean pangramEng(String str) {
        var alphabet = "abcdefghijklmnopqrstuvwxyz".chars().boxed().collect(Collectors.toSet());
        str.toLowerCase().chars().forEach(ch -> alphabet.removeIf(x -> x == ch));
        return alphabet.size() < 3;
    }
}
