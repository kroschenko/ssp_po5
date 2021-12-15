package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //объявляем массив на N элементов
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество элементов числовой последовательности: ");
        int N = in.nextInt();
        int array[] = new int[N];

        //вводим с клавиатуры элементы
        System.out.println("Введите элементы числовой последовательности: ");
        for (int i=0; i<N; i++){
            array[i] = in.nextInt();
        }

        //проверяем, равны ли элементы массива
        boolean equals = true;

        for (int i=1; i<N; i++){
            if (array[i-1] != array[i]){
                equals = false;
            }
        }

        //выводим результат работы программы на экран
        if (equals == true){
            System.out.println("Элементы числовой последовательности равны");
        }
        else {
            System.out.println("Элементы числовой последовательности не равны");
        }

    }
}
