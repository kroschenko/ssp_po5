package com.company;
import java.math.BigDecimal;

public class Airplane extends PassengerCarrier {
    public Airplane(int speed, BigDecimal pricePerKm) {
        super(speed, pricePerKm);
    }
    void printTypeOfTransport() {
        System.out.println("Airplane");
    }
    void calculateMovement(int distance) {
        System.out.println("Flight by plane will take " + distance / this.getSpeed()
                + " hours and will cost " +
                this.getPricePerKm().multiply(BigDecimal.valueOf(distance)));
    }
}