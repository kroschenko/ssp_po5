package lab_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SSP_lab_1 {

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double single(int size) {
        int[][] mass = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) mass[i][j] = 1;
                else mass[i][j] = generateRandomIntIntRange(1, 100);
                System.out.print(mass[i][j] + "  ");
            }
            System.out.print('\n');
        }
        return size;  
    }

    public static String capitalize(String str) {
        String result_str = null;
        for (int i = 0; i < str.length(); i++) {
            if((str.charAt(0) > 'a') && (str.charAt(0) < 'z')) {
                String s1 = str.substring(0, 1).toUpperCase();
                result_str = s1 + str.substring(1);
            }
            else result_str = str;
        }
        return result_str;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("TASK 1");
        double sum = 0;
        int count = 0, maxsize;
        System.out.println("Enter maxsize numbers");
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
        String sMax = enter.readLine();
        maxsize = Integer.parseInt(sMax);
        int[] mass = new int[maxsize];
        System.out.println("Enter numbers");
        for (int i = 0; i < maxsize; i++) {
            mass[i] = generateRandomIntIntRange(1, 100);
            sum += mass[i];
            System.out.println("Numbers: " + mass[i]);
        }
        double middle = sum/maxsize;
        for (int i = 0; i < maxsize; i++) {
            if(mass[i] > middle) count++;
        }
        double result = count*100/maxsize;
        System.out.println("Sum numbers = " + sum);
        System.out.println("Middle = " + middle);
        System.out.println("Procet = " + result);
        System.out.println("TASK 2");
        int size = 0;
        System.out.println("Enter size matrix");
        BufferedReader size_matrix = new BufferedReader(new InputStreamReader(System.in));
        String sSize = size_matrix.readLine();
        size = Integer.parseInt(sSize);
        single(size);
        System.out.println("TASK 3");
        System.out.println("Enter string");
        BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
        String str = string.readLine();
        System.out.println(capitalize(str));
    }
}
