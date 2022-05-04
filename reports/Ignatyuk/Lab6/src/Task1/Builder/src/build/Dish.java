package build;

public abstract class Dish extends Product {
    private Double m_Weight = 0.0;
    private Type m_Type = null;

    public Dish(final Double c_Price, final String c_Name, final Double c_Weight, final Type c_Type) {
        super(c_Price, c_Name);
        this.m_Weight = c_Weight;
        this.m_Type = c_Type;
    }

    public final Double f_get_weight() {
        return this.m_Weight;
    }

    public final void f_set_wight(final Double c_Weight) {
        this.m_Weight = c_Weight;
    }

    public final Type f_get_type() {
        return this.m_Type;
    }

    public final void f_set_type(final Type c_Type) {
        this.m_Type = c_Type;
    }

    public static enum Type {
        BURGER, SALAD
    }
}
