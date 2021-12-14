package com.company;

public class Lab1Task1 {
    public static void main(String[] args) {
        double[] numbs = new double[args.length];

        for (int i = 0; i < args.length; i++) {
            numbs[i] = Double.parseDouble(args[i]);
        }

        boolean isSorted = false;
        double buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < numbs.length-1; i++) {
                if(numbs[i] > numbs[i+1]){
                    isSorted = false;

                    buf = numbs[i];
                    numbs[i] = numbs[i+1];
                    numbs[i+1] = buf;
                }
            }
        }

        double median = 0;

        if (numbs.length % 2 == 0) {
            median = numbs[numbs.length / 2] + numbs[numbs.length / 2 - 1];
            median /= 2;
        }
        else {
            median = numbs[numbs.length / 2];
        }

        System.out.println("Медиана: " + median);
    }
}