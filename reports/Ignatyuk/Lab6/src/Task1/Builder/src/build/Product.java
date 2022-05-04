package build;

public abstract class Product {
    private Double m_Price = 0.0;
    private String m_Name = new String();

    public Product(final Double c_Price, final String c_Name) {
        this.m_Price = c_Price;
        this.m_Name = c_Name;
    }

    public final Double f_get_price() {
        return this.m_Price;
    }

    public final void f_set_price(final Double c_Price) {
        this.m_Price = c_Price;
    }

    public final String f_get_name() {
        return this.m_Name;
    }

    public final void f_set_name(final String c_Name) {
        this.m_Name = c_Name;
    }
}
