package build;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        Order.Builder v_Builder = Order.Builder.f_new_instance();
        v_Builder.f_set_dish(new Burger(12.99, "Chicken Burger", 400.0, Burger.BurgerType.CHICKEN));
        v_Builder.f_set_drink(new ColdDrink(4.38, "Coca-Cola", 200.0, ColdDrink.ColdDrinkType.COLA));
        v_Builder.f_set_need_to_pack(Boolean.TRUE);
        v_Builder.f_set_pack_price(0.89);

        final Order c_Order = v_Builder.f_build();
        System.out.println("Total price: " + c_Order.f_get_total_price().toString());
    }
}
