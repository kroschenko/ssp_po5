package lab3_1;

import lab3_1.enums.BurgerType;
import lab3_1.enums.DrinkType;
import lab3_1.enums.LocationType;
import lab3_1.enums.SideType;

public class Builder {

    private final Order order;

    public Builder(String customer) {
        order = new Order(customer);
        order.burger = null;
        order.drink = null;
        order.side = null;
        order.location = null;
    }

    private Builder(
            String customer,
            BurgerType burger,
            DrinkType drink,
            SideType side,
            LocationType location)
    {
        order = new Order(customer);
        order.burger = burger;
        order.drink = drink;
        order.side = side;
        order.location = location;
    }

    public Builder setBurger(BurgerType burger) {
        return new Builder(order.customer, burger, order.drink, order.side, order.location);
    }

    public Builder setDrink(DrinkType drink) {
        return new Builder(order.customer, order.burger, drink, order.side, order.location);
    }

    public Builder setSide(SideType side) {
        return new Builder(order.customer, order.burger, order.drink, side, order.location);
    }

    public Builder setLocation(LocationType location) {
        return new Builder(order.customer, order.burger, order.drink, order.side, location);
    }

    public Order build() {
        return order;
    }

}
