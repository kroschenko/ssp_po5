package com.spp.labs;

import java.util.HashSet;
import java.util.Arrays;

public class Lab3Ex1 {
    public static void main(String[] args) {
        char[] mass = {'a', 'b', 'c'};
        Symbols obj1 = new Symbols(mass);
        
        Symbols obj2 = new Symbols(mass);
        
        Symbols obj3 = new Symbols(5);
        
        System.out.println(obj1.equals(obj2));
        
        obj2.add('d');
        obj2.remove('a');
        
        obj2.print();
        System.out.println(obj2);
        System.out.println(obj2.toString());
        
        System.out.println(obj2.contains('c'));
        System.out.println(obj2.contains('x'));
        
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        
        obj2.append(obj1);
        
        System.out.println(obj1);
        System.out.println(obj2);
        
        char[] mass2 = {'x', 'y', 'z'};
        
        obj1.setCharSet(mass2);
        
        System.out.println(obj1);
        
        
    }
}

class Symbols {
    
    private char[] charSet;
    
    public Symbols(int length) {
        this.charSet = new char[length];
    }
    
    public Symbols(char[] charSet) {
        HashSet<Character> charHashSet = new HashSet<>();
        
        for (int i = 0; i < charSet.length; i++) {
            charHashSet.add(charSet[i]);
        }
        
        this.charSet = new char[charHashSet.size()];
        
        int count = 0;
        for (char i : charHashSet) {
            this.charSet[count] = i;
            count++;
        }
    }
    
    public char[] getCharSet() {
        return this.charSet;
    }
    
    public void setCharSet(char[] charSet) {
        HashSet<Character> charHashSet = new HashSet<>();
        
        for (int i = 0; i < charSet.length; i++) {
            charHashSet.add(charSet[i]);
        }
        
        this.charSet = new char[charHashSet.size()];
        
        int count = 0;
        for (char i : charHashSet) {
            this.charSet[count] = i;
            count++;
        }
    }
    
    @Override
    public String toString() {
        return Arrays.toString(this.charSet);
    }
    
    public boolean equals(Symbols obj) {
        return Arrays.equals(this.charSet, obj.charSet);
    }
    
    public void append(Symbols obj) {
        HashSet<Character> charHashSet = new HashSet<>();
        
        for (int i = 0; i < this.charSet.length; i++) {
            charHashSet.add(this.charSet[i]);
        }
        
        for (int i = 0; i < obj.charSet.length; i++) {
            charHashSet.add(obj.charSet[i]);
        }
        
        this.charSet = new char[charHashSet.size()];
        
        int count = 0;
        for (char i : charHashSet) {
            this.charSet[count] = i;
            count++;
        }
    }
    
    public void print() {
        System.out.print("[ ");
        
        for (char i : this.charSet) {
            System.out.print("'" + i + "' ");
        }
        
        System.out.println("]");
    }
    
    public boolean contains(char symbol) {
        boolean hasSymbol = false;
        
        for (char i : this.charSet) {
            if (i == symbol) {
                hasSymbol = true;
                break;
            }
        }
        
        return hasSymbol;
    }
    
    public void add(char symbol) {
        HashSet<Character> charHashSet = new HashSet<>();
        
        for (int i = 0; i < this.charSet.length; i++) {
            charHashSet.add(this.charSet[i]);
        }
        
        charHashSet.add(symbol);
        
        this.charSet = new char[charHashSet.size()];
        
        int count = 0;
        for (char i : charHashSet) {
            this.charSet[count] = i;
            count++;
        }
    }
    
    public void remove(char symbol) {
        HashSet<Character> charHashSet = new HashSet<>();
        
        for (int i = 0; i < this.charSet.length; i++) {
            charHashSet.add(this.charSet[i]);
        }
        
        charHashSet.remove(symbol);
        
        this.charSet = new char[charHashSet.size()];
        
        int count = 0;
        for (char i : charHashSet) {
            this.charSet[count] = i;
            count++;
        }
    }
}
