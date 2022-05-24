package com.spp.labs;


public class Lab1Ex3 {
    public static void main(String[] args) {
        char ch = args[0].charAt(0);
        
        System.out.println(repeat(ch, 5));
    }
    
    public static String repeat(char ch, int repeat) {
        String str = "";
        
        for (int i = 0; i < repeat; i++) {
            str += ch;
        }
        
        return str;
    }
}
