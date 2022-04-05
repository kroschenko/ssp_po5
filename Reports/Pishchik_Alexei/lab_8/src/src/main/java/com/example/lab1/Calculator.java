package com.example.lab1;

import static java.lang.Math.pow;

public class Calculator extends Thread {
    private int n;
    private final HelloController controller;

    public Calculator(int n, HelloController controller) {
        this.n = n;
        this.controller = controller;
    }

    @Override
    public void run() {
        int k = 1;
        double sum = 0;
        try {
            while (k < n && !isInterrupted()) {
                controller.updateResult(sum);
                double s = pow(-1, k - 1) * 1 / pow(k, 2);
                sum += s;
                k++;
                controller.updateResult(sum);

                sleep(300);
            }
        } catch (InterruptedException exception) {
            System.out.println("Interrupted");
        }
    }
}
