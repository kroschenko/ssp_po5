package main6.task1;

import main6.task1.burger.*;
import main6.task1.drink.Cola;
import main6.task1.drink.Tea;
import main6.task1.pack.OnSide;
import main6.task1.pack.OutSide;
import java.util.List;


public final class Main {

    public static void main(String[] args) {
        var rest = new Restaurant();
        var prices = List.of(
                rest.makeAnOrder(Order.builder()
                        .addBugrer(new VeganBurger())
                        .addDrink(new Cola())
                        .build()),
                rest.makeAnOrder(Order.builder()
                        .addBugrer(new PorkBurger())
                        .addDrink(new Tea())
                        .withPackage(new OutSide())
                        .build())
        );
        System.out.println(prices);
    }
}
