package com.company;
import java.math.BigDecimal;

public class Train extends PassengerCarrier {
    public Train(int speed, BigDecimal pricePerKm) {
        super(speed, pricePerKm);
    }
    void printTypeOfTransport() {
        System.out.println("Train:");
    }
    void calculateMovement(int distance) {
        System.out.println("A trip by train will take " + distance/this.getSpeed()
                + " hours and will cost " +
                this.getPricePerKm().multiply(BigDecimal.valueOf(distance)));
    }
}