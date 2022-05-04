package stct;

public abstract class Person {
    private Integer m_Age = 0;
    private String m_Name = new String();

    public Person(final Integer c_Age, final String c_Name) {
        this.m_Age = c_Age;
        this.m_Name = c_Name;
    }

    public final void f_set_age(final Integer c_Age) {
        this.m_Age = c_Age;
    }

    public final Integer f_get_age() {
        return this.m_Age;
    }

    public final void f_set_name(final String c_Name) {
        this.m_Name = c_Name;
    }

    public final String f_get_name() {
        return this.m_Name;
    }
}
