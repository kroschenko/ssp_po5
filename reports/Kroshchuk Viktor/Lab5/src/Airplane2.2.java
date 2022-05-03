package com.company;
import java.math.BigDecimal;

public class Airplane extends PassengerCarrier {
    public Airplane(int speed, BigDecimal pricePerKm) {
        super(speed, pricePerKm);
    }
    @Override
    void printTypeOfTransport() {
        System.out.println("Самолет:");
    }
    @Override
    void calculateMovement(int distance) {
        System.out.println("Поездка на самолете займет " + distance / this.getSpeed() + 
                " час(ов) и будет стоить " + this.getPricePerKm().multiply(BigDecimal.valueOf(distance)) + "$");
    }
}
