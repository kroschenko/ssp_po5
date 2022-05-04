package build;

public final class HotDrink extends Drink {
    private HotDrinkType m_HotDrinkType = null;

    public HotDrink(final Double c_Price, final String c_Name, final Double c_Volume,
            final HotDrinkType c_HotDrinkType) {
        super(c_Price, c_Name, c_Volume, Drink.Type.HOT);
        this.m_HotDrinkType = c_HotDrinkType;
    }

    public final HotDrinkType f_get_hot_drink_type() {
        return this.m_HotDrinkType;
    }

    public final void f_set_hot_drink_type(final HotDrinkType c_HotDrinkType) {
        this.m_HotDrinkType = c_HotDrinkType;
    }

    public static enum HotDrinkType {
        TEA, COFFEE
    }
}
