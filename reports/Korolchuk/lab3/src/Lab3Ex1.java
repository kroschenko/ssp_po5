package com.spp.labs;

import java.util.HashSet;
import java.util.Arrays;

public class Lab3Ex1 {
    public static void main(String[] args) {
        char[] mass = {'a', 'b', 'c'};
        Symbols obj1 = new Symbols(mass, mass.length);
        
        Symbols obj2 = new Symbols(mass, 3);
        
        Symbols obj3 = new Symbols(5);
        
        System.out.println(obj1.equals(obj2));
        
        obj2.remove('a');
        obj2.add('d');
        obj1.add('b');
        
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
    private int maxSize;
    
    public Symbols(int length) {
        this.maxSize = length;
        this.charSet = new char[0];
    }
    
    public Symbols(char[] charSet, int length) {
        HashSet<Character> charHashSet = convertHash(charSet);

        if (charHashSet.size() <= length) {
            this.maxSize = length;
            this.charSet = new char[charHashSet.size()];

            int count = 0;
            for (char i : charHashSet) {
                this.charSet[count] = i;
                count++;
            }
        }
        else {
            System.out.println("Длина множества превышает указанный максимум");
            this.maxSize = length;
            this.charSet = new char[0];
        }
    }
    
    public HashSet<Character> convertHash(char[] charSet) {
        HashSet<Character> charHashSet = new HashSet<>();

        for (int i = 0; i < charSet.length; i++) {
            charHashSet.add(charSet[i]);
        }
        
        return charHashSet;
    }
    
    public char[] getCharSet() {
        return this.charSet;
    }
    
    public void setCharSet(char[] charSet) {
        HashSet<Character> charHashSet = convertHash(charSet);
            
        if (charHashSet.size() <= this.maxSize) {
            this.charSet = new char[charHashSet.size()];

            int count = 0;
            for (char i : charHashSet) {
                this.charSet[count] = i;
                count++;
            }
        }
        else {
            System.out.println("Недопустимая длина множества, превышен максимум");
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
        HashSet<Character> charHashSet = convertHash(charSet);

        for (int i = 0; i < obj.charSet.length; i++) {
            charHashSet.add(obj.charSet[i]);
        }
            
        if (charHashSet.size() <= this.maxSize) {
            this.charSet = new char[charHashSet.size()];

            int count = 0;
            for (char i : charHashSet) {
                this.charSet[count] = i;
                count++;
            }
        }
        else {
            System.out.println("Множество, получаемое в результате объединения, имеет длину, превышающую максимальную");
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
        HashSet<Character> charHashSet = convertHash(charSet);

        charHashSet.add(symbol);

        if (charHashSet.size() <= this.maxSize) {
            this.charSet = new char[charHashSet.size()];

            int count = 0;
            for (char i : charHashSet) {
                this.charSet[count] = i;
                count++;
            }
        }
        else {
            System.out.println("Множество достигло максимальной длины");
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
