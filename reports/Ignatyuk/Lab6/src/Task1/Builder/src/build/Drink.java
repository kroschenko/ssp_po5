package build;

public abstract class Drink extends Product {
    private Double m_Volume = 0.0;
    private Type m_Type = null;

    public Drink(final Double c_Price, final String c_Name, final Double c_Volume, final Type c_Type) {
        super(c_Price, c_Name);
        this.m_Volume = c_Volume;
        this.m_Type = c_Type;
    }

    public final Double f_get_volume() {
        return this.m_Volume;
    }

    public final void f_set_volume(final Double c_Volume) {
        this.m_Volume = c_Volume;
    }

    public final Type f_get_type() {
        return this.m_Type;
    }

    public final void f_set_type(final Type c_Type) {
        this.m_Type = c_Type;
    }

    public static enum Type {
        HOT, COLD
    }
}
