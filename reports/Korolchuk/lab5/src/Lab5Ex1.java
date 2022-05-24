package com.spp.labs;

public class Lab5Ex1 {
    public static void main(String[] args) {
        AircraftCarrier ship1 = new AircraftCarrier("X-24");
        ship1.print();
        ship1.swim();
        ship1.arrive();
        
        AircraftCarrier ship2 = new AircraftCarrier("R4-BEE");
        ship2.set_name("JEN'SHEN'");
        ship2.print();
    }
}

interface Ship {
    void print();
    void set_name(String name);
    String get_name();
    String get_type();
    void swim();
    void arrive();
}

abstract class MilitaryShip implements Ship {
    String name;
    String type;
    
    MilitaryShip(String name) {
        this.type = "Military Ship";
        this.name = name;
    }
    
    @Override
    public void set_name(String name) {
        this.name = name;
    }
    
    @Override
    public String get_name() {
        return this.name;
    }
    
    @Override
    public String get_type() {
        return this.type;
    }
    
    @Override
    public void swim() {
        System.out.println(this.type + " \"" + this.name + "\" is swimming now");
    }
    
    @Override
    public void arrive() {
        System.out.println(this.type + " \"" + this.name + "\" arrived");
    }
    
    @Override
    public void print() {
        System.out.println("Ship's type: \"" + this.type + "\"\nShip's name: \"" + this.name + "\"");
    }
}

class AircraftCarrier extends MilitaryShip {
    AircraftCarrier(String name) {
        super(name);
        this.type = "Aircraft Carrier";
    }
}
