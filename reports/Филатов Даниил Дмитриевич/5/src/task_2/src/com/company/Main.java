package com.company;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PassengerCarrier> list = new ArrayList<>();
        list.add(new Airplane(980, new BigDecimal("0.2")));
        list.add(new Car(130, new BigDecimal("0.1")));
        list.add(new Train(90, new BigDecimal("0.07")));
        System.out.println("Print speed and price of transport:");
        list.forEach(transport -> {transport.printTypeOfTransport();
            transport.printPrice(); transport.printSpeed();});
        int distance = 1500;
        System.out.println("\nCalculate movement for each transport, distance = "+
                distance + "km");
        list.forEach(transport -> transport.calculateMovement(distance));
    }
}
