package com.company;

import java.io.*;

class Lab2Task1 {

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
            int digitCount = 0;

            while((str = bfr.readLine()) != null) {
                char[] strChar;
                strChar = str.toCharArray();
                for (int i = 0; i < strChar.length; i++) {
                    if (strChar[i] == '0' ||
                            strChar[i] == '1' ||
                            strChar[i] == '2' ||
                            strChar[i] == '3' ||
                            strChar[i] == '4' ||
                            strChar[i] == '5' ||
                            strChar[i] == '6' ||
                            strChar[i] == '7' ||
                            strChar[i] == '8' ||
                            strChar[i] == '9')
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
                char[] strChar;
                strChar = str.toCharArray();
                for (int i = 0; i < strChar.length; i++) {
                    if (strChar[i] == '0' ||
                            strChar[i] == '1' ||
                            strChar[i] == '2' ||
                            strChar[i] == '3' ||
                            strChar[i] == '4' ||
                            strChar[i] == '5' ||
                            strChar[i] == '6' ||
                            strChar[i] == '7' ||
                            strChar[i] == '8' ||
                            strChar[i] == '9')
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
