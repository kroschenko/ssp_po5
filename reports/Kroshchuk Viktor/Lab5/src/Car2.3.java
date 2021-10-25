package com.company;
import java.math.BigDecimal;

public class Car extends PassengerCarrier {
    public Car(int speed, BigDecimal pricePerKm) {
        super(speed, pricePerKm);
    }
    @Override
    void printTypeOfTransport() {
        System.out.println("Машина:");
    }
    @Override
    void calculateMovement(int distance) {
        System.out.println("Поездка на машине займет " + distance/this.getSpeed()
                + " час(ов) и будет стоить " + this.getPricePerKm().multiply(BigDecimal.valueOf(distance)) + "$");
    }
}
