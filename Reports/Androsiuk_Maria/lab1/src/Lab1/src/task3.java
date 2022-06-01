package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            System.out.println("Введите строку: ");
            String str = in.nextLine();

            System.out.print("Ваша строка: ");
            System.out.println(str);

            char arrayStr[] = str.toCharArray();
            System.out.println("Введите количество позиций для сдвига: ");
            int shift = in.nextInt();
                if(shift > arrayStr.length){
                    shift = shift - arrayStr.length;
                }
                if(arrayStr.length==1){
                    System.out.println(arrayStr);
                }
                else{
                    char temp;
                    for(int i=0; i<arrayStr.length; i++){
                    temp = arrayStr[arrayStr.length-shift];
                    arrayStr[arrayStr.length-shift] = arrayStr[i];
                    arrayStr[i] = temp;
                        System.out.print(arrayStr[i]);
                    }

                }

            }
    }

