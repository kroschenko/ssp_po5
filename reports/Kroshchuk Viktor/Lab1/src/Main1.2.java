package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк и столбцов матрицы");
        n = scanner.nextInt();
        System.out.println("Введите массив");
        double arr[][] = new double[n][n];//Обявленние двумерного массива

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextFloat();//Присвоение числа в ячейку массива
            }
        }

        // часть 2 - выводит на экран начальную матрицу
        System.out.println("Введенная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");//Вывод ячейки на экран
            }
            System.out.println();
        }

        // часть 3 - транспонирование матрицы
                for (int i = 0; i < n; i++) {
                    for (int j = i+1; j < n; j++) {
                        double temp = arr[i][j];
                        arr[i][j] = arr[j][i];
                        arr[j][i] = temp;
                    }
                }

                // часть 4 - выводит на экран транспонированную матрицу
                System.out.println();
                System.out.println("Новая транспонированная матрица");
                System.out.println("");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }
            }
        }