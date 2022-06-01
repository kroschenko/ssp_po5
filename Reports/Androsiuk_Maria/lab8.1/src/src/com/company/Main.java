package com.company;

import java.util.Scanner;

public class Main {

    private static Thread thread;
    private static Double result;
    private final static Object lock = new Object();
    private static boolean paused;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String valueStr = in.nextLine();

            if (valueStr.equals("Pause")) {
                pause();
                continue;
            }

            if (valueStr.equals("Resume")) {
                resume();
                continue;
            }

            if (valueStr.equals("Stop")) {
                stop();
                continue;
            }

            int value;

            try {
                value = Integer.parseInt(valueStr);

                if (value < 0) {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input");
                return;
            }

            calculate(value);
        }
    }

    private static void calculate(int value) {
        if (thread != null) {
            thread.interrupt();
        }

        result = 0.0;
        paused = false;

        System.out.println("Started");

        thread = new Thread(() -> {
            double previousTerm = 1.0;

            for (int i = 0; i <= value; i++) {
                synchronized (lock) {
                    try {
                        Thread.sleep(10000);

                        if (paused) {
                            lock.wait();
                        }

                        previousTerm = i == 0 ? 1.0 : previousTerm / i;
                        result += previousTerm;

                        System.out.println(result);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });

        thread.start();
    }

    protected static void pause() {
        if (thread != null && thread.isAlive()) {
            paused = true;
            System.out.println("Paused");
        }
    }

    protected static void resume() {
        if (paused && thread != null && thread.isAlive()) {
            synchronized (lock) {
                paused = false;
                lock.notify();
                System.out.println("Resumed");
            }
        }
    }

    protected static void stop() {
        if (thread != null) {
            thread.interrupt();
            System.out.println("Stopped");
        }
    }
}
