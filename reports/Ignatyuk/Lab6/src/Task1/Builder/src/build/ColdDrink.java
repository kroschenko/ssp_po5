package build;

public final class ColdDrink extends Drink {
    private ColdDrinkType m_ColdDrinkType = null;

    public ColdDrink(final Double c_Price, final String c_Name, final Double c_Volume,
            final ColdDrinkType c_ColdDrinkType) {
        super(c_Price, c_Name, c_Volume, Drink.Type.HOT);
        this.m_ColdDrinkType = c_ColdDrinkType;
    }

    public final ColdDrinkType f_get_cold_drink_type() {
        return this.m_ColdDrinkType;
    }

    public final void f_set_cold_drink_type(final ColdDrinkType c_ColdDrinkType) {
        this.m_ColdDrinkType = c_ColdDrinkType;
    }

    public static enum ColdDrinkType {
        COLA, PEPSI
    }
}
