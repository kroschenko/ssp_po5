package main6.task1;

import main6.task1.burger.Burger;
import main6.task1.drink.Drink;
import main6.task1.pack.Package;
import java.util.stream.Stream;


public final class Restaurant {

    public Long makeAnOrder(Burger burger, Drink drink, Package pack) {
        return Stream.of(burger, drink, pack)
                .map(Position::price)
                .mapToLong(Long::valueOf)
                .sum();
    }
}
