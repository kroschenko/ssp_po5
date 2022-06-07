package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder text= new StringBuilder();
        FileReader reader = new FileReader("D:\\Study\\5 sem\\SPP\\2\\lab2\\src\\file.txt");
        BufferedReader br = new BufferedReader(reader);
        String line;
        String standart = "стих";
        while((line = br.readLine())!=null){
            text.append(line);
        }
        br.close();
        System.out.println(text);
        String[] words = text.toString().split("[?!., ]");
        System.out.print(standart + ": ");

        for(String word: words) {
            int line_length = 0;
            if (word.length()/2 > standart.length()) {
                line_length = standart.length();
            } else line_length = word.length()/2;
            if (standart.substring(0, line_length).equals(word.toLowerCase().substring(0, line_length)) && word.length()>2) {
                System.out.print(word + " ");
            }
        }
    }
}
