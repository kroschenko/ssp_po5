package SecondTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static final int N = 3;
    public static final int M = 2;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[][] array = new double[N][M];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                double d = 0;
                try {
                    d = Double.parseDouble(reader.readLine());
                }
                catch (IOException e) { }
                array[i][j]=d;
            }
        }
        System.out.println();
        for(double[] i: array) {
            for (double j : i) {
                System.out.printf("%7.2f ", j);
            }
            System.out.println();
        }
        System.out.println();
        double[] arr = flatten(array);
        for(double a : arr)
            System.out.printf("%7.2f ",a);
    }
    public static double[] flatten(double[][] array)
    {
        int size = 0;
        int n = array.length;
        List<Double> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
                size +=array[i].length;

        int k = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
                k++;
            }
        }
        Collections.sort(list);
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
