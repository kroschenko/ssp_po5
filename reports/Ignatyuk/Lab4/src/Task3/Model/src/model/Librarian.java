package model;

public final class Librarian extends WorkingPerson {
    private Library m_Library = new Library();

    public Librarian(final Integer c_Age, final String c_Name, final Library c_Library) {
        super(c_Age, c_Name);
        this.m_Library = c_Library;
    }

    public final void f_set_library(final Library c_Library) {
        this.m_Library = c_Library;
    }

    public final Library f_get_library() {
        return this.m_Library;
    }

    public final void f_add_order(final Order c_Order) {
        this.m_Library.f_add_order(c_Order);
    }
}
