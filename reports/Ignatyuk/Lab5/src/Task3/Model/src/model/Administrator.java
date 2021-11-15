package model;

public final class Administrator extends WorkingPerson {
    private Library m_Library = null;

    public Administrator(final Integer c_Age, final String c_Name, final Library c_Library) {
        super(c_Age, c_Name);
        this.m_Library = c_Library;
    }

    public final void f_set_library(final Library c_Library) {
        this.m_Library = c_Library;
    }

    public final Library f_get_library() {
        return this.m_Library;
    }

    public final void f_add_to_black_list(final Reader c_Reader) {
        this.m_Library.f_add_to_black_list(c_Reader);
    }

    public final void f_update() {
        for (final Order c_Order : m_Library.f_get_orders()) {
            if (!m_Library.f_check_deadline(c_Order)) {
                this.f_add_to_black_list(c_Order.f_get_reader());
            }
        }
    }
}
