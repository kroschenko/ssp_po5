package model;

public abstract class WorkingPerson extends Person implements Worker {
    private Boolean m_IsWorking = Boolean.FALSE;

    public WorkingPerson(final Integer c_Age, final String c_Name) {
        super(c_Age, c_Name);
    }

    public final void f_work() {
        this.m_IsWorking = Boolean.TRUE;
    }

    public final Boolean f_is_working() {
        return this.m_IsWorking;
    }

    public final void f_stop_working() {
        this.m_IsWorking = Boolean.FALSE;
    }
}
