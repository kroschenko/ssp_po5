package com.company;
import java.math.BigDecimal;

public class Car extends PassengerCarrier {
    public Car(int speed, BigDecimal pricePerKm) {
        super(speed, pricePerKm);
    }
    void printTypeOfTransport() {
        System.out.println("Car:");
    }
    void calculateMovement(int distance) {
        System.out.println("A trip by car will take " + distance/this.getSpeed()
                + " hours and will cost " +
                this.getPricePerKm().multiply(BigDecimal.valueOf(distance)));
    }
}