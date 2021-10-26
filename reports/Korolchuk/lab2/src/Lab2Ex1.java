package com.spp.labs;

import java.io.*;

class Lab2Ex1 {
    
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                if (args.length == 0) {
                    System.out.println("Не указан аргумент.");
                    System.exit(0);
                }
                else {
                    System.out.println("Указано больше 1 аргумента.");
                    System.exit(0);
                }
            }
            
            BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
            String str = "";
            String[] subStrings;
            int digitCount = 0;
            
            while((str = bfr.readLine()) != null) {
                subStrings = str.split(" ");
                for (String elem : subStrings) {
                    if (elem.equals("0") ||
                        elem.equals("1") ||
                        elem.equals("2") ||
                        elem.equals("3") ||
                        elem.equals("4") ||
                        elem.equals("5") ||
                        elem.equals("6") ||
                        elem.equals("7") ||
                        elem.equals("8") ||
                        elem.equals("9"))
                    {
                        digitCount++;
                    }
                }
            }
            
            bfr.close();
            int index = 0;
            
            if (digitCount != 0) {
                index = digitCount / 2;
            }
            else {
                System.out.println("Цифры не найдены.");
                System.exit(0);
            }
            
            digitCount = 0;
            bfr = new BufferedReader(new FileReader(args[0]));
            
            while((str = bfr.readLine()) != null) {
                subStrings = str.split(" ");
                for (String elem : subStrings) {
                    if (elem.equals("0") ||
                        elem.equals("1") ||
                        elem.equals("2") ||
                        elem.equals("3") ||
                        elem.equals("4") ||
                        elem.equals("5") ||
                        elem.equals("6") ||
                        elem.equals("7") ||
                        elem.equals("8") ||
                        elem.equals("9"))
                    {
                        digitCount++;
                        if (digitCount == index) {
                            System.out.println(str);
                            bfr.close();
                            System.exit(0);
                        }
                    }
                }
            }
        }
        catch(IOException e) {
            System.out.println("Ошибка!\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
