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

    public static void shiftRightNative(double[] array, int shift) {
        System.arraycopy(array, 0, array, shift, array.length - shift);
        Arrays.fill(array, 0, shift, 0);
    }

    public static void shiftRight(double[] array, int shift) {
        for (int i = array.length - 1; i >= shift; i--) {
            array[i] = array[i - shift];
        }
        for (int i = 0; i < shift; i++) {
            array[i] = 0;
        }
    }
}
