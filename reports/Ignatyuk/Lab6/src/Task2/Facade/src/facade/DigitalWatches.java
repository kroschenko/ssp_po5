package facade;

public final class DigitalWatches implements Watches {
    private Integer m_Hours = 0, m_Minutes = 0;

    public DigitalWatches(final Integer c_Hours, final Integer c_Minutes) {
        this.m_Hours = c_Hours;
        this.m_Minutes = c_Minutes;
    }

    @Override
    public final String f_get_time() {
        return new String((this.m_Hours < 10 ? '0' + this.m_Hours.toString() : this.m_Hours.toString()) + ':'
                + (this.m_Minutes < 10 ? '0' + this.m_Minutes.toString() : this.m_Minutes.toString()));
    }

    @Override
    public final void f_set_time(final Integer c_Hours, final Integer c_Minutes) {
        this.m_Hours = c_Hours;
        this.m_Minutes = c_Minutes;
    }

    @Override
    public final Integer f_get_hours() {
        return this.m_Hours;
    }

    @Override
    public final void f_set_hours(final Integer c_Hours) {
        this.m_Hours = c_Hours;
    }

    @Override
    public final Integer f_get_minutes() {
        return this.m_Minutes;
    }

    @Override
    public final void f_set_minutes(final Integer c_Minutes) {
        this.m_Minutes = c_Minutes;
    }
}
