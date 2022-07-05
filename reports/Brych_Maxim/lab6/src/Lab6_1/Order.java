package lab3_1;

import lab3_1.enums.LocationType;
import lab3_1.enums.BurgerType;
import lab3_1.enums.DrinkType;
import lab3_1.enums.SideType;

public class Order {

    public final String customer;

    public BurgerType burger;
    public DrinkType drink;
    public SideType side;
    public LocationType location;

    public Order(String customer) {
        this.customer = customer;
    }

    public void show()
    {
        System.out.printf(
                "Описание заказа:\n Заказчик: %s\n Бургер: %s\n Напиток: %s\n Дополнение: %s\n Упаковка: %s%n",
                customer,
                burger.name(),
                drink.name(),
                side.name(),
                location.name()
        );
        System.out.println();
    }
}
