package com.company;

import java.util.Scanner;
import java.math.*;

class lab1 {

    static int N = 10;
    static int i = 0;
    static double sum = 0;

    static class Tread extends Thread {

        double current = 0, fac = 1;

        Tread(String name){
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Поток " + Thread.currentThread().getName() + " стартовал...");

            while(i != N) {
                if(i % 2 == 0){
                    current = 1 / fac;
                }else {
                    current = -1 / fac;
                }
                fac *= (i + 1);

                sum += current;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
                }
                i++;
            }

            System.out.println("\nПоток " + Thread.currentThread().getName() + "  завершил работу...");
        }
    }

    static class Print extends Thread {

        Print(String name){
            super(name);
        }

        @Override
        public void run(){

            System.out.println("Поток " + Thread.currentThread().getName() + " стартовал..." + '\n');

            while (i < N) {
                System.out.println("pos = " + i + "     sum = " + sum); // вывод
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
                }
            }

            System.out.println("\nИтоговая сумма равна = " + sum + '\n');
            System.out.println("Поток " + Thread.currentThread().getName() + "  завершил работу...");
        }
    }

    public static class Main {

        public static void main(String[] args) throws InterruptedException {

            System.out.println("Поток Main стартовал...");
            Tread t = new Tread("culc");
            t.start();

            Tread.sleep(100);
            Print p = new Print("print");
            p.start();

            try {
                t.join();
                p.join();
            }
            catch(InterruptedException e) {
                System.out.println("Поток " + t.getName() + " был прерван");
            }

            System.out.println("Поток Main завершил работу...");
            System.out.println();
        }
    }
}