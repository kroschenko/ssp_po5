package com.company;
import java.math.BigDecimal;

public abstract class PassengerCarrier {
    private int speed;
    private BigDecimal pricePerKm;
    public PassengerCarrier(int speed, BigDecimal pricePerKm) {
        this.speed = speed;
        this.pricePerKm = pricePerKm;
    }
    abstract void printTypeOfTransport();
    abstract void calculateMovement(int distance);
    public void printSpeed() {
        System.out.println("\tSpeed = " + speed + "km per hour");
    }
    public void printPrice() {
        System.out.println("\tPrice = " + pricePerKm + "$ per km");
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }
    public void setPricePerKm(BigDecimal pricePerKm) {
        this.pricePerKm = pricePerKm;
    }
}