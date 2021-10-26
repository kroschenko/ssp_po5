package com.spp.labs;


public class Lab1Ex2 {
    public static void main(String[] args) {
        double [] mass = new double [args.length];
        
        for (int i = 0; i < args.length; i++) {
            mass[i] = Double.parseDouble(args[i].trim());
        }
        
        mass = add(mass, 3, 4.0).clone();
        
        for(double elem : mass) {
            System.out.print(elem + " ");
        }
    }
    
    public static double [] add(double [] array, int index, double element) {
        double [] newArray = new double [array.length + 1];
        
        for (int i = 0, j = 0; i < newArray.length; i++, j++) {
            if (i == index) {
                newArray[i] = element;
                j--;
                continue;
            }
            newArray[i] = array[j];
        }
        
        return newArray;
    }
}
