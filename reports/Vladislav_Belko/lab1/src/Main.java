

package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n*********   Task 1   **********\n");
        task1();
        System.out.println("\n\n*********   Task 2   **********\n");
        task2();
        System.out.println("\n\n*********   Task 3   **********\n");
        task3();
    }
    public static void task1(){
        int max =0;
        int min = 101;
        int sum = 0;
        int pow = 1;
        int[] Arr = new int [6];
        for(int i=0; i<Arr.length; i++)
        {
            Arr[i]=(int)(Math.random()*100);
            System.out.print(Arr[i]+ "\t");
        }
        int x = 0, y = 0;
        for (int i = 0; i < Arr.length; i ++){
            if (Arr[i]>max){
                max = Arr[i];
                x = i;
            }
        }
        for (int i = 0; i < Arr.length; i ++){
            if (Arr[i]<min){
                min = Arr[i];
                y = i;
            }
        }
        for (int i = 0; i < Arr.length; i ++){
            sum = sum + Arr[i];
            pow = pow * Arr[i];
        }
        System.out.print("\n Max: " + max + "\n Min: " + min + "\n Sum " + sum + "\n Pow: " + Math.abs(pow));
    }

    public static void task2(){

        double[] a = {1.2, 2, 3, 4, 5, 6, 7, 8, 9};
        //Выводим изначальный массив в консоль
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + "\t");
        }
        System.out.println();

        int n = a.length;
        //Переменная, которая будет использоваться при обмене элементов
        double temp;

        for (int i = 0; i < n/2; i++) {
            temp = a[n-i-1];
            a[n-i-1] = a[i];
            a[i] = temp;
        }
        //Выводим конечный массив в консоль
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + "\t");
        }
    }

    public static void task3(){

        Main pn = new Main();
        Scanner in = new Scanner(System.in);
        System.out.print("line: ");
        String line = in.nextLine();
        if(pn.isPalindrome(line)){
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    public boolean isPalindrome(String original){
        int i = original.length()-1;
        int j=0;
        while(i > j) {
            if(original.charAt(i) != original.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}


