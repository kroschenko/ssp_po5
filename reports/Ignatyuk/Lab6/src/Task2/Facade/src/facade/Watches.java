package facade;

public interface Watches {
    public String f_get_time();

    public void f_set_time(final Integer c_Hours, final Integer c_Minutes);

    public Integer f_get_hours();

    public void f_set_hours(final Integer c_Hours);

    public Integer f_get_minutes();

    public void f_set_minutes(final Integer c_Minutes);
}
