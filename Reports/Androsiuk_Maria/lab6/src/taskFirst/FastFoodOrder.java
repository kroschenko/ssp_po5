package taskFirst;

enum FastFoodOrderBurgerType {
    BEEF_BURGER,
    CHICKEN_BURGER,
    EGG_BURGER,
    CHEESEBURGER_WITH_BACON,
    BURGER_WITH_SALAMI,
    SPICY_BURGER
}

enum FastFoodOrderDrinkType {
    COCA_COLA,
    FANTA,
    SPRITE,
    FUZE_TEA,
    BONAQUA,
    TEA,
    COFFEE
}

enum FastFoodOrderSideType {
    FRENCH_FRIES,
    POTATO_WEDGES,
    CHICKEN_NUGGETS,
    MOZZARELLA_STICKS
}

enum FastFoodLocationType {
    IN_RESTAURANT,
    TAKEOUT,
    DELIVERY
}

class FastFoodOrder {

    private String orderer;

    private FastFoodOrderBurgerType burger;
    private FastFoodOrderDrinkType drink;
    private FastFoodOrderSideType side;
    private FastFoodLocationType location;

    private FastFoodOrder(String orderer) {
        this.orderer = orderer;
    }

    /* java.lang.Object */

    @Override
    public String toString() {
        return String.format(
            "<FastFoodOrder orderer=\"%s\" burger=%s drink=%s side=%s location=%s>",
            orderer, burger.name(), drink.name(), side.name(), location.name()
        );
    }

    /* builder */

    public static class Builder {

        private final FastFoodOrder order;

        public Builder(String orderer) {
            order = new FastFoodOrder(orderer);
            order.burger = null;
            order.drink = null;
            order.side = null;
            order.location = null;
        }

        private Builder(
            String orderer,
            FastFoodOrderBurgerType burger,
            FastFoodOrderDrinkType drink,
            FastFoodOrderSideType side,
            FastFoodLocationType location
        ) {
            order = new FastFoodOrder(orderer);
            order.burger = burger;
            order.drink = drink;
            order.side = side;
            order.location = location;
        }

        public Builder setOrderer(String orderer) {
            return new Builder(orderer, order.burger, order.drink, order.side, order.location);
        }

        public Builder setBurger(FastFoodOrderBurgerType burger) {
            return new Builder(order.orderer, burger, order.drink, order.side, order.location);
        }

        public Builder setDrink(FastFoodOrderDrinkType drink) {
            return new Builder(order.orderer, order.burger, drink, order.side, order.location);
        }

        public Builder setSide(FastFoodOrderSideType side) {
            return new Builder(order.orderer, order.burger, order.drink, side, order.location);
        }

        public Builder setLocation(FastFoodLocationType location) {
            return new Builder(order.orderer, order.burger, order.drink, order.side, location);
        }

        public FastFoodOrder build() {
            return order;
        }

    }

}
