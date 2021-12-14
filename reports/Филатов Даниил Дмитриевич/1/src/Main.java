package com.company;
import java.util.Random;

public class Main {
    public void printMatrix(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public double[] randomPerturbations (double[] matrix) {
        double[] perturbate = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            perturbate[i] = matrix[i];

        Random rnd = new Random();

        for (int i = perturbate.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            double temp = perturbate[index];
            perturbate[index] = perturbate[i];
            perturbate[i] = temp;
        }
        return perturbate;
    }

    public double[][] randomPerturbations (double[][] matrix) {
        double[][] perturbate = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            perturbate[i] = randomPerturbations(matrix[i]);
        }
        return perturbate;
    }

    static boolean isAllLowerCase(String cs) {
        char ch;
        ch = cs.charAt(0);
        for (int i = 0; i < cs.length(); i++) {
            ch = cs.charAt(i);
            return (Character.isLowerCase(ch));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Task 1");
        int[] array = {1, 3, 3, 2, 3, 5, 5, 8};
        int n = array.length;
        for(int element: array){
            System.out.print(element + " ");
        }
        System.out.println();
        for(int i = 0, m = 0; i != n; i++, n = m) {
            for (int j = m = i + 1; j != n; j++) {
                if (array[j] != array[i]) {
                    if ( m != j )
                        array[m] = array[j];
                    m++;
                }
            }
        }
        if ( n!= array.length ) {
            int[] new_array = new int[n];
            for(int i = 0; i < n; i++)
                new_array[i] = array[i];
            array = new_array;
        }
        for(int elements: array){
            System.out.print( elements + " ");
        }


        System.out.println("\nTask 2");
        Main contr = new Main();
        if (args.length < 2)
            return;

        int N, M;
        N = Integer.parseInt(args[0]);
        M = Integer.parseInt(args[1]);

        double[][] matrix = new double[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                matrix[i][j] = ((double) Math.round(Math.random() * 50));
            }
        }

        System.out.println("Matrix: ");
        contr.printMatrix(matrix);
        System.out.println("PerturbatedMatrix: ");
        contr.printMatrix(contr.randomPerturbations(matrix));


        System.out.println("Task 3");
        System.out.print(isAllLowerCase("QWrtub"));
    }
}
