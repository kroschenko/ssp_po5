package main6.task1;

import main6.task1.burger.ClassicBurger;
import main6.task1.burger.VeganBurger;
import main6.task1.drink.Cola;
import main6.task1.drink.Tea;
import main6.task1.pack.OnSide;
import main6.task1.pack.OutSide;
import java.util.List;


public final class Main {

    public static void main(String[] args) {
        var rest = new Restaurant();
        var prices = List.of(
                rest.makeAnOrder(new VeganBurger(), new Cola(), new OnSide()),
                rest.makeAnOrder(new ClassicBurger(), new Tea(), new OutSide())
        );
        System.out.println(prices);
    }
}
