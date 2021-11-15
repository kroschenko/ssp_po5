package model;

public abstract class TownBuilding implements Building {
    private Boolean m_IsCreated = Boolean.FALSE, m_IsOpen = Boolean.FALSE;
    private String m_Name = new String(), m_Address = new String();

    public TownBuilding(final String c_Name, final String c_Address) {
        this.m_Name = c_Name;
        this.m_Address = c_Address;
    }

    public final void f_set_name(final String c_Name) {
        this.m_Name = c_Name;
    }

    public final String f_get_name() {
        return this.m_Name;
    }

    public final void f_set_adress(final String c_Address) {
        this.m_Address = c_Address;
    }

    public final String f_get_address() {
        return this.m_Address;
    }

    public final void f_create() {
        this.m_IsCreated = Boolean.TRUE;
    }

    public final void f_destroy() {
        this.m_IsCreated = Boolean.FALSE;
    }

    public final Boolean f_is_created() {
        return this.m_IsCreated;
    }

    public final void f_open() {
        this.m_IsOpen = Boolean.TRUE;
    }

    public final void f_close() {
        this.m_IsOpen = Boolean.FALSE;
    }

    public final Boolean f_is_open() {
        return this.m_IsOpen;
    }
}
