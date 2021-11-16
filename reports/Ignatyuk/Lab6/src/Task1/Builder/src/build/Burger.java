package build;

public final class Burger extends Dish {
    private BurgerType m_BurgerType = null;

    public Burger(final Double c_Price, final String c_Name, final Double c_Weight, final BurgerType c_BurgerType) {
        super(c_Price, c_Name, c_Weight, Dish.Type.BURGER);
        this.m_BurgerType = c_BurgerType;
    }

    public final BurgerType f_get_burger_type() {
        return this.m_BurgerType;
    }

    public final void f_set_burger_type(final BurgerType c_BurgerType) {
        this.m_BurgerType = c_BurgerType;
    }

    public static enum BurgerType {
        VEGAN, CHICKEN
    }
}
