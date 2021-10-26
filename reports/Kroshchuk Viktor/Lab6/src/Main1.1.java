package com.company;

public class Main {

    public static void main(String[] args) {
        FastFoodOrder order = new FastFoodOrder.Builder("Крощук В.В.")
                .setBurger(FastFoodOrderBurgerType.CHEESEBURGER_WITH_BACON)
                .setDrink(FastFoodOrderDrinkType.SPRITE)
                .setSide(FastFoodOrderSideType.MOZZARELLA_STICKS)
                .setLocation(FastFoodLocationType.IN_RESTAURANT)
                .build();
        System.out.println(order.toString());

        System.out.println("-------------------------------------");

        FastFoodOrder order2 = new FastFoodOrder.Builder("Цуман В.А.")
                .setBurger(FastFoodOrderBurgerType.BEEF_BURGER)
                .setDrink(FastFoodOrderDrinkType.COCA_COLA)
                .setSide(FastFoodOrderSideType.FRENCH_FRIES)
                .setLocation(FastFoodLocationType.DELIVERY)
                .build();
        System.out.println(order2.toString());

        System.out.println("-------------------------------------");

        FastFoodOrder order3 = new FastFoodOrder.Builder("Ляшевич Т.А.")
                .setBurger(FastFoodOrderBurgerType.EGG_BURGER)
                .setDrink(FastFoodOrderDrinkType.FANTA)
                .setSide(FastFoodOrderSideType.POTATO_WEDGES)
                .setLocation(FastFoodLocationType.TAKEOUT)
                .build();
        System.out.println(order3.toString());
    }
}
