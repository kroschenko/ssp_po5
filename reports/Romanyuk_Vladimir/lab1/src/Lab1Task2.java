package com.company;

public class Lab1Task2 {
    public static void main(String[] args) {
        double [] mass = new double [args.length];

        for (int i = 0; i < args.length; i++) {
            mass[i] = Double.parseDouble(args[i].trim());
        }

        mass = add(mass, 10, 4.0).clone();

        for(double elem : mass) {
            System.out.print(elem + " ");
        }
    }

    public static double [] add(double [] array, int index, double element) {
        if (index < 0 || index > array.length) {
            System.out.println("Некорректный индекс");
            return array;
        }

        double [] newArray = new double [array.length + 1];

        for (int i = 0, j = 0; i < newArray.length; i++, j++) {
            if (i == index) {
                newArray[i] = element;
                j--;
                continue;
            }
            newArray[i] = array[j];
        }

        return newArray;
    }
}