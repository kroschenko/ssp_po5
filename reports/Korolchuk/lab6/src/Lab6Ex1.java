package com.spp.labs;

import java.util.*;

public class Lab6Ex1 {
    public static void main(String[] args) {
        ArrayList<CarsFactory> factoryList = new ArrayList<>();
        factoryList.add(new FordFactory());
        factoryList.add(new ToyotaFactory());
        factoryList.add(new AudiFactory());
        
        for (CarsFactory elem : factoryList) {
            elem.createCoupe();
        }
        
        factoryList.get(0).createMinivan();
    }
}

interface CarsFactory {
    Sedan createSedan();
    Coupe createCoupe();
    Minivan createMinivan();
}

class FordFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new  FordSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new FordCoupe();
    }
    
    @Override
    public Minivan createMinivan() {
        return new FordMinivan();
    }
}

class ToyotaFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new  ToyotaSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new ToyotaCoupe();
    }
    
    @Override
    public Minivan createMinivan() {
        return new ToyotaMinivan();
    }
}

class AudiFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new  AudiSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new AudiCoupe();
    }
    
    @Override
    public Minivan createMinivan() {
        return new AudiMinivan();
    }
}

interface Sedan {
    
}

interface Coupe {
    
}


interface Minivan {
    
}

class ToyotaCoupe implements Coupe {
    public ToyotaCoupe() {
        System.out.println("Create ToyotaCoupe");
    }
}

class ToyotaSedan implements Sedan {
    public ToyotaSedan() {
        System.out.println("Create ToyotaSedan");
    }
}

class ToyotaMinivan implements Minivan {
    public ToyotaMinivan() {
        System.out.println("Create ToyotaMinivan");
    }
}

class FordCoupe implements Coupe {
    public FordCoupe () {
        System.out.println("Create FordCoupe");
    }
}

class FordSedan implements Sedan {
    public FordSedan() {
        System.out.println("Create FordSedan");
    }
}

class FordMinivan implements Minivan {
    public FordMinivan() {
        System.out.println("Create FordMinivan");
    }
}

class AudiCoupe implements Coupe {
    public AudiCoupe() {
        System.out.println("Create AudiCoupe");
    }
}

class AudiSedan implements Sedan {
    public AudiSedan() {
        System.out.println("Create AudiSedan");
    }
}

class AudiMinivan implements Minivan {
    public AudiMinivan() {
        System.out.println("Create AudiMinivan");
    }
}
