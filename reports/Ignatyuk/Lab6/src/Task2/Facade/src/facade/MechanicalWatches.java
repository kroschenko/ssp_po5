package facade;

public final class MechanicalWatches implements Watches {
    private final static Integer c_HoursToDegreesK = 30, c_MinutesToDegreesK = 3;
    private Integer m_HourDegrees = 0, m_MinuteDegrees = 0;

    public MechanicalWatches(final Integer c_Hours, final Integer c_Minutes) {
        this.m_HourDegrees = c_Hours * c_HoursToDegreesK;
        this.m_MinuteDegrees = c_Minutes * c_MinutesToDegreesK;
    }

    @Override
    public final String f_get_time() {
        final Integer c_Hours = this.m_HourDegrees / c_HoursToDegreesK,
                c_Minutes = this.m_MinuteDegrees / c_MinutesToDegreesK;

        return new String((c_Hours < 10 ? '0' + c_Hours.toString() : c_Hours.toString()) + ':'
                + (c_Minutes < 10 ? '0' + c_Minutes.toString() : c_Minutes.toString()));
    }

    @Override
    public final void f_set_time(final Integer c_Hours, final Integer c_Minutes) {
        this.m_HourDegrees = c_Hours * c_HoursToDegreesK;
        this.m_MinuteDegrees = c_Minutes * c_MinutesToDegreesK;
    }

    @Override
    public final void f_set_hours(final Integer c_Hours) {
        this.m_HourDegrees = c_Hours * c_HoursToDegreesK;
    }

    @Override
    public final Integer f_get_hours() {
        return this.m_HourDegrees / c_HoursToDegreesK;
    }

    @Override
    public final void f_set_minutes(final Integer c_Minutes) {
        this.m_MinuteDegrees = c_Minutes * c_MinutesToDegreesK;
    }

    @Override
    public final Integer f_get_minutes() {
        return this.m_MinuteDegrees / c_MinutesToDegreesK;
    }

    public final void f_set_hour_degrees(final Integer c_HourDegrees) {
        this.m_HourDegrees = c_HourDegrees;
    }

    public final Integer f_get_hour_degrees() {
        return this.m_HourDegrees;
    }

    public final void f_set_minute_degrees(final Integer c_MinuteDegrees) {
        this.m_MinuteDegrees = c_MinuteDegrees;
    }

    public final Integer f_get_minute_degrees() {
        return this.m_MinuteDegrees;
    }
}
