package com.spp.labs;

public class Lab6Ex3 {
    public static void main(String[] args) {
        Printing p1 = new Printing(new LaserPrinter());
        p1.printing("My name is Artyom.\nI'm 19.");
        
        Printing p2 = new Printing(new InkjetPrinter());
        p2.printing("I love oranges.");
    }
}

abstract class Printer {
    public abstract void printing(String text);
}

class InkjetPrinter extends Printer {
    public void printing(String text) {
        System.out.println("Inkjet printer printed the following text");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
        System.out.println(text);
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|\n");
    }
}

class LaserPrinter extends Printer {
    public void printing(String text) {
        System.out.println("Laser printer printed the following text");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
        System.out.println(text);
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|\n");
    }
}

class PhotonPrinter extends Printer {
    public void printing(String text) {
        System.out.println("Photon printer printed the following text");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|\n");
        System.out.println(text);
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
    }
}

class Printing {
    private Printer p;
    
    Printing(Printer p) {
        this.p = p;
    }
    
    void printing(String text) {
        this.p.printing(text);
    }
}
