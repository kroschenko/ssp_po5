package com.spp.labs;

import java.util.*;

public class Lab5Ex2 {
    public static void main(String[] args) {
        ArrayList<GardenTree> mass = new ArrayList<>();
        
        AppleTree apple1 = new AppleTree(2, 0.6);
        AppleTree apple2 = new AppleTree(7, 0.3);
        PearTree pear1 = new PearTree(1, 0.3);
        CherryTree cherry1 = new CherryTree(15, 0);
        
        mass.add(apple1);
        mass.add(apple2);
        mass.add(pear1);
        mass.add(cherry1);
        
        mass.forEach(elem -> {
            elem.needsTransplantation();
        });
    }
}

abstract class GardenTree {
    int age;
    double fruiting;
    
    GardenTree(int age, double fruiting) {
        this.age = age;
        
        if (fruiting >= 0 && fruiting <= 1) {
            this.fruiting = fruiting;
        }
        else {
            System.out.println("Incorrect value. Try something [0.0, 1.0]");
        }
    }
    
    int get_age() {
        return this.age;
    }
    
    double get_fruiting() {
        return this.fruiting;
    }
    
    void set_age(int age) {
        this.age = age;
    }
    
    void set_fruiting(double fruiting) {
        if (fruiting >= 0 && fruiting <= 1) {
            this.fruiting = fruiting;
        }
        else {
            System.out.println("Incorrect value. Try something [0.0, 1.0]");
        }
    }
    
    void needsTransplantation() {
    }
}

class AppleTree extends GardenTree {
    static int number = 0;
    int itsNumber;
    
    AppleTree(int age, double fruiting) {
        super(age, fruiting);
        this.itsNumber = ++AppleTree.number;
    }
    
    void print() {
        System.out.println("Apple-tree №" + this.itsNumber + " has:\n"
                + "Age: " + this.age + "\n"
                + "Fruiting: " + this.fruiting);
    }
    
    @Override
    void needsTransplantation() {
        if (this.age < 4 && this.fruiting > 0.5) {
            System.out.println("Apple tree №" + this.itsNumber + " doesn't need transplantation");
        }
        else {
            System.out.println("Apple tree №" + this.itsNumber + " needs transplantation");
        }
    }
}

class PearTree extends GardenTree {
    static int number;
    int itsNumber;
    
    PearTree(int age, double fruiting) {
        super(age, fruiting);
        this.itsNumber = ++PearTree.number;
    }
    
    void print() {
        System.out.println("Pear-tree №" + this.itsNumber + " has:\n"
                + "Age: " + this.age + "\n"
                + "Fruiting: " + this.fruiting);
    }
    
    @Override
    void needsTransplantation() {
        if (this.age < 6 && this.fruiting > 0.4) {
            System.out.println("Pear tree №" + this.itsNumber + " doesn't need transplantation");
        }
        else {
            System.out.println("Pear tree №" + this.itsNumber + " needs transplantation");
        }
    }
}

class CherryTree extends GardenTree {
    static int number;
    int itsNumber;
    
    CherryTree(int age, double fruiting) {
        super(age, fruiting);
        this.itsNumber = ++CherryTree.number;
    }
    
    void print() {
        System.out.println("Cherry-tree №" + this.itsNumber + " has:\n"
                + "Age: " + this.age + "\n"
                + "Fruiting: " + this.fruiting);
    }
    
    @Override
    void needsTransplantation() {
        if (this.age < 5 && this.fruiting > 0.7) {
            System.out.println("Cherry tree №" + this.itsNumber + " doesn't need transplantation");
        }
        else {
            System.out.println("Cherry tree №" + this.itsNumber + " needs transplantation");
        }
    }
}
