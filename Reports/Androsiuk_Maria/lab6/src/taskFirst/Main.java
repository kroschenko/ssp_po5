package taskFirst;

public class Main {

    public static void main(String[] args) {
        FastFoodOrder order = new FastFoodOrder.Builder("Bydyakov V.V.")
            .setBurger(FastFoodOrderBurgerType.CHICKEN_BURGER)
            .setDrink(FastFoodOrderDrinkType.FUZE_TEA)
            .setSide(FastFoodOrderSideType.POTATO_WEDGES)
            .setLocation(FastFoodLocationType.DELIVERY)
            .build();

        System.out.println(order.toString());
    }

}
