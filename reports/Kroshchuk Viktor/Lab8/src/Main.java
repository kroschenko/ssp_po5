package com.company;

import java.util.Scanner;

class Tred extends Thread{

    Scanner in = new Scanner(System.in);

    Tred(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Поток " + Thread.currentThread().getName() + " стартовал..." + '\n');
        System.out.print("Введите степень k: ");
        int k = in.nextInt() + 1;
        System.out.print("Введите число х: ");
        int x = in.nextInt();
        System.out.print("Введите число a: ");
        int a = in.nextInt();
        int i = 0;
        double sum = 0;
        while(i != k){
            sum += Math.pow(x * Math.log(a), i) / factorial(i);
            System.out.println("sum = " + sum);
            try{
                System.out.println("stop on 1s");
                Thread.sleep(1);
            }
            catch(InterruptedException e){
                System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
            }
            i++;
        }
        System.out.println("Итоговая сумма равна = " + sum + '\n');
        System.out.println("Поток " + Thread.currentThread().getName() + " завершил работу...");
    }

    public double factorial(int num){
        if(num == 0 || num == 1)
            return 1;
        int sum = 1;
        for(int i = 2; i <= num; i++)
            return sum *= i;
        return sum;
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println("Поток Main стартовал...");
        Tred t = new Tred("Treddy");
        t.start(); // Treddy
        try{
            t.join();
        }
        catch(InterruptedException e){
            System.out.println("Поток " + t.getName() + " был прерван");
        }
        System.out.println("Поток Main завершил работу...");
        System.out.println();
    }
}
