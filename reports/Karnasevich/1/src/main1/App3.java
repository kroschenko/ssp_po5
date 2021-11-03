package main1;

import java.util.Arrays;
import java.util.Scanner;


public class App3 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter the array:");
        var values = new Scanner(System.in).nextLine().split(" ");
        var array = Arrays.stream(values).map(Double::parseDouble).mapToDouble(Double::doubleValue).toArray();
        System.out.println("Enter the shift:");
        var shift = scanner.nextInt();
        shiftRight(array, shift);
        System.out.println(Arrays.toString(array));
    }

    public static void shiftRight(double[] array, int shift) {
        shift = shift % array.length;
        var buffer = new double[shift];
        System.arraycopy(array, array.length - shift, buffer, 0, shift);
        System.arraycopy(array, 0, array, shift, array.length - shift);
        System.arraycopy(buffer, 0, array, 0, shift);
    }
}
