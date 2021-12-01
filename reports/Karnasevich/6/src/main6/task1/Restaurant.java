package main6.task1;

import main6.task1.burger.Burger;
import main6.task1.drink.Drink;
import main6.task1.pack.Package;
import java.util.stream.Stream;


public final class Restaurant {

    public Long makeAnOrder(Order order) {
        return order.totalPrice();
    }

}
