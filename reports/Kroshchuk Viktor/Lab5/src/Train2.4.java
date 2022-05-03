package com.company;
import java.math.BigDecimal;

public class Train extends PassengerCarrier {
    public Train(int speed, BigDecimal pricePerKm) {
        super(speed, pricePerKm);
    }
    @Override
    void printTypeOfTransport() {
        System.out.println("Поезд:");
    }
    @Override
    void calculateMovement(int distance) {
        System.out.println("Поездка на поезде займет " + distance/this.getSpeed()
                + " час(ов) и будет стоить " +
                this.getPricePerKm().multiply(BigDecimal.valueOf(distance)) + "$");
    }
}
