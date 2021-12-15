package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите количество элементов массива: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double[] array = new double[N];

        System.out.println("Введите элементы массива: ");
        for (int i=0; i<N; i++){
            array[i] = in.nextInt();
        }

        System.out.println("Введите начальный индекс подмассива: ");
        int startIndex = in.nextInt();
        System.out.println("Введите конечный индекс подмассива: ");
        int endIndex = in.nextInt();

        double[] subarray = Arrays.copyOfRange(array, startIndex, endIndex);
        System.out.println("Элементы выделенного подмассива: ");
        for (int i = 0; i<array.length; i++){
            System.out.println(subarray[i]);
        }

    }
}
