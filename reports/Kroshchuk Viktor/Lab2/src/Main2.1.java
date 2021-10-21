package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> text = getLines();

        for (String line : text) {
            sb.append(shuffle(line)).append(" ").append("\n");

        }
        System.out.println(sb.toString());
    }

    public static ArrayList<String> getLines() throws IOException {
        String path = "C:\\Users\\Viktor\\Desktop\\5sem\\SPP\\lab2\\Lab2.1\\src\\com\\company\\lab2.txt";
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> lines = new ArrayList<String>();

        while (br.ready()) {
            lines.add(br.readLine());
        }
        return lines;
    }

    public static String shuffle(String string) {
        List<String> words = Arrays.asList(string.split("[!:,.?!''(+)-]"));

        String[] shuff = new String[words.size()];
        words.toArray(shuff);

        Random rnd = new Random();
        for (int j = 0; j < 20; j++) {
            for (int i = shuff.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                String temp = shuff[index];
                shuff[index] = shuff[i];
                shuff[i] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String word : shuff)
            sb.append(word);
        return sb.toString();
    }
}