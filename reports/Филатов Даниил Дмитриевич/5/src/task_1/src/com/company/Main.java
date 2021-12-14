package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(new Surgeon());
        doctorList.add(new Neurosurgeon());
        doctorList.add(new Surgeon());
        doctorList.add(new Neurosurgeon());
        doctorList.add(new Surgeon());
        doctorList.add(new Surgeon());
        doctorList.forEach(Doctor::printPost);
    }
}
