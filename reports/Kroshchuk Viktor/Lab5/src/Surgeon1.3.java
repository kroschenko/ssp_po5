package com.company;
public class Surgeon implements Doctor {
    @Override
    public void printPost() {
        System.out.println("Хирург");
    }
}