package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Заполните массив (10 элементов):");
        int numbers[] = new int[10];//создаем  массив размером 10
        for (int k = 0; k < numbers.length; k++) {
            numbers[k] = input.nextInt();}// заполняем массив с клавиатуры

        //int[] numbers = {1, 1, 20, 1, 3, 4, 5, 6, 6, 1, 2, 9, 9};
            int x = numbers.length;
            int[] unique = new int[x];
            int p = 0;
            for (int i = 0; i < x; i++) {
                int temp = numbers[i];
                int b = 0;
                for (int y = 0; y < x; y++) {
                    if (unique[y] != temp) {
                        b++;
                    }
                }
                if (b == x) {
                    unique[p] = temp;
                    p++;
                }
            }
        System.out.println("Полученный уникальный массив:");
            for (int a = 0; a < p; a++) {
                System.out.print(unique[a]);
                if (a < p - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

