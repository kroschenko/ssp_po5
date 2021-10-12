import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Task 1");
        int N =Integer.parseInt(args[0]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num;
            num = Rand(1, 10000);
            arr[i] = num;
        }
        Num(arr);
        System.out.println("Task 2");
        int N2 = Integer.parseInt(args[1]);
        double[] arr2 = new double[N2];
        for (int i = 0; i < N2; i++) {
            int num2;
            num2=Rand(0, 100);
            arr2[i] = num2;
        }
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println("");
        int sh = Integer.parseInt(args[2]);
        shiftLeft(arr2, sh);
        System.out.println("");
        System.out.println("Task 3");
        String stroka1 = args[3];
        String stroka2 = args[4];
        xor(stroka1, stroka2);
    }

    public static void Num(int[] arr) {
        int kolv1, kolv2, kolv3, kolv4, kolv;
        kolv1 = 0;
        kolv2 = 0;
        kolv3 = 0;
        kolv4 = 0;
        kolv = 0;
        String str;
        int size;
        for (int i = 0; i < arr.length; i++) {
            str = String.valueOf(arr[i]);
            size = str.length();
            switch (size) {
                case 1:
                    kolv1++;
                    break;
                case 2:
                    kolv2++;
                    break;
                case 3:
                    kolv3++;
                    break;
                case 4:
                    kolv4++;
                    break;
                default:
                    kolv++;
                    break;
            }
        }
        System.out.println("One-digit numbers: " + kolv1);
        System.out.println("Two-digit numbers: " + kolv2);
        System.out.println("Three-digit numbers: " + kolv3);
        System.out.println("four-digit numbers: " + kolv4);
        System.out.println("The others: " + kolv);
    }

    public static void shiftLeft(double[] array, int shift) {
        if (shift > array.length) {
            System.out.println("Error. The offset is greater than the length of the array.");
        } else {
            double[] arr2 = new double[array.length];
            int k = 0;
            for (int i = shift; i < array.length; i++) {
                arr2[k] = array[i];
                k++;
            }
            for (int i = 0; i < shift; i++) {
                arr2[k] = array[i];
                k++;
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(arr2[i] + " ");
            }

        }
    }

    public static String xor(String str1, String str2) {
        String str = "";
        int size = Math.abs(str1.length() - str2.length());
        if (str1.length() < str2.length()) {
            for (int i = 0; i < size; i++) {
                str1 += " ";
            }
        } else {
            for (int i = 0; i < size; i++) {
                str2 += " ";
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            str += str1.charAt(i) ^ str2.charAt(i);
        }
        System.out.println(str);
        return str;
    }

    public static int Rand(int min, int max) {
        int res;
        double x = (Math.random() * ((max - min))) + min;
        res = (int) x;
        return res;
    }
}
