package lab3_1;

import lab3_1.enums.LocationType;
import lab3_1.enums.BurgerType;
import lab3_1.enums.DrinkType;
import lab3_1.enums.SideType;

public class Lab6_1 {

    public static void main(String[] args) {
        Order order = new Builder("Пищик А.В.")
            .setBurger(BurgerType.BURGER_WITH_SALAMI)
            .setDrink(DrinkType.TEA)
            .setSide(SideType.MOZZARELLA_STICKS)
            .setLocation(LocationType.IN_RESTAURANT)
            .build();

        Order order2 = new Builder("Брич М.Н.")
            .setBurger(BurgerType.BEEF_BURGER)
            .setDrink(DrinkType.COFFEE)
            .setSide(SideType.FRENCH_FRIES)
            .setLocation(LocationType.DELIVERY)
            .build();

        Order order3 = new Builder("Нерода А.А.")
            .setBurger(BurgerType.CHICKEN_BURGER)
            .setDrink(DrinkType.COCA_COLA)
            .setSide(SideType.CHICKEN_NUGGETS)
            .setLocation(LocationType.TAKEOUT)
            .build();

        order.show();
        order2.show();
        order3.show();
    }
}
