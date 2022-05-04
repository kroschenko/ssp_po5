package build;

public final class Salad extends Dish {
    private SaladType m_SaladType = null;

    public Salad(final Double c_Price, final String c_Name, final Double c_Weight, final SaladType c_SaladType) {
        super(c_Price, c_Name, c_Weight, Dish.Type.SALAD);
        this.m_SaladType = c_SaladType;
    }

    public final SaladType f_get_salad_type() {
        return this.m_SaladType;
    }

    public final void f_set_salad_type(final SaladType c_SaladType) {
        this.m_SaladType = c_SaladType;
    }

    public static enum SaladType {
        VEGETABLE, SEAFOOD
    }
}
