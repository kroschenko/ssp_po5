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
        System.out.print("Введите число: ");
        int N = in.nextInt();
        int i = 1;
        double sum = 0;
        while(i != N){
            sum += ((2 * i - 1) / (Math.pow(2, i)));
            System.out.println("sum = " + sum);
            try{
                System.out.println("stop on 1s");
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
            }
            i++;
        }
        System.out.println("Итоговая сумма равна = " + sum + '\n');
        System.out.println("Поток " + Thread.currentThread().getName() + " завершил работу...");
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