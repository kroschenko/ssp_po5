package com.company;

class Potok extends Thread{

    private int x, n;

    public Potok(int x, int n) {
        this.x=x;
        this.n=n;
    }

    public void run(){
        System.out.println(function(x, n));
    }

    private double function(int x, int n) {
        double result, k = 0;
        int it = 1;

        for (int i = 0; i < n; i++) {
            k = x / it + Math.pow(-1, n) * (Math.pow(x, (2 * n + 1)) / (2 * n + 1));
            it = it + 2;
        }

        result = (3.14 / 2) - k;
        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            // int x = Integer.parseInt(args[0]);
             //int n = Integer.parseInt(args[1]);
            int n = 2;
            int x = 3;

            Potok th = new Potok(x, n);
            th.start();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
