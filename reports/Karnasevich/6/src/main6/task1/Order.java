package main6.task1;

import main6.task1.burger.Burger;
import main6.task1.drink.Drink;
import main6.task1.pack.OnSide;
import main6.task1.pack.Package;
import java.util.*;
import java.util.stream.Stream;


public class Order {

    private final List<Burger> burgers;

    private final List<Drink> drinks;

    private final Package packages;

    private Order(List<Burger> burgers, List<Drink> drinks, Package packages) {
        this.burgers = burgers;
        this.drinks = drinks;
        this.packages = packages;
    }

    public Long totalPrice(){
        return Stream.of(burgers, drinks, List.of(packages))
                .flatMap(Collection::stream)
                .map(Position::price)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {

        private final List<Burger> burgers = new ArrayList<>();

        private final List<Drink> drinks = new ArrayList<>();

        private Package pack;

        public OrderBuilder addBugrer(Burger burger){
            burgers.add(burger);
            return this;
        }

        public OrderBuilder addDrink(Drink drink){
            drinks.add(drink);
            return this;
        }

        public OrderBuilder withPackage(Package pack){
            this.pack = pack;
            return this;
        }

        public Order build(){
            if (pack == null){
                pack = new OnSide();
            }
            return new Order(burgers, drinks, pack);
        }
    }
}
