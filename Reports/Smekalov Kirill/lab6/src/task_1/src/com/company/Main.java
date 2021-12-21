package com.company;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Factory chipsFactory = new ChipsFactory();
        chipsFactory.createProduct().printInformation();
        Factory chocolateBarsFactory = new ChocolateBarsFactory();
        chocolateBarsFactory.createProduct().printInformation();
        Factory packagedJuicesFactory = new PackagedJuicesFactory();
        packagedJuicesFactory.createProduct().printInformation();
    }
}

abstract class Product {
    private BigDecimal price;
    private double weight;
    public Product() {
    }
    public Product(BigDecimal price, double weight) {
        this.price = price;
        this.weight = weight;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }
    public abstract void printInformation();
}

class Chips extends Product {
    public Chips() {
        super(new BigDecimal("3.25"), 130);
    }
    @Override
    public void printInformation() {
        System.out.println("Chips: " + super.getWeight() + "г., " + super.getPrice() +
                "p.");
    }
}

class ChocolateBars extends Product {
    public ChocolateBars() {
        super(new BigDecimal("3.19"), 80);
    }
    @Override
    public void printInformation() {
        System.out.println("Chocolate bars: " + super.getWeight() + "г., " +
                super.getPrice() + "p.");
    }
}

class PackagedJuices extends Product {
    public PackagedJuices() {
        super(new BigDecimal("0.79"), 150);
    }
    @Override
    public void printInformation() {
        System.out.println("Packaged juices: " + super.getWeight() + "г., " +
                super.getPrice() + "p.");
    }
}

interface Factory {
    Product createProduct();
}

class ChipsFactory implements Factory {
    @Override
    public Chips createProduct() {
        return new Chips();
    }
}

class ChocolateBarsFactory implements Factory {
    @Override
    public ChocolateBars createProduct() {
        return new ChocolateBars();
    }
}

class PackagedJuicesFactory implements Factory {
    @Override
    public PackagedJuices createProduct() {
        return new PackagedJuices();
    }
}