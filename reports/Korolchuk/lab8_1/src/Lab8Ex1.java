package com.spp.labs;

import java.util.logging.Level;
import java.util.logging.Logger;

class JThread extends Thread {
    
    int n;
    double x;
      
    JThread(String name, int n, double x){
        super(name);
        this.n = n;
        this.x = x;
    }
    
    public static double countExample(int n, double x) {
        double value = x;
        
        for (int k = 1; k <= n; k++) {
            System.out.println("Промежуточное значение: " + value);
            
            value *= ((x * x) * (2 * k - 1) / (2 * k + 1));
        }
        
        return value;
    }
      
    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        
        double result = countExample(n, x);
        System.out.println("Конечный результат: " + result);
        
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class Lab8Ex1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = Double.parseDouble(args[1]);
        
        System.out.println("Main thread started...");
        Thread thread = new JThread("JThread", n, x);
        
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lab8Ex1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Main thread finished...");
    }
}
