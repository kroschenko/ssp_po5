using System;

namespace lab6._1._9
{
    class Program
    {
        static void Main(string[] args)
        {
            Order.Builder v_Builder = Order.Builder.f_new_instance();
            v_Builder.f_set_dish(new Burger(12.99, "Chicken Burger", 400.0, Burger.BurgerType.CHICKEN));
            v_Builder.f_set_drink(new ColdDrink(4.38, "Coca-Cola", 200.0, ColdDrink.ColdDrinkType.COLA));
            v_Builder.f_set_need_to_pack(true);
            v_Builder.f_set_pack_price(0.89);

            Order c_Order = v_Builder.f_build();
            Console.WriteLine("Total price: " + c_Order.f_get_total_price().ToString());
        }
    }
}