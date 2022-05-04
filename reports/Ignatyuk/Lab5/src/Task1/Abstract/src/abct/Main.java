package abct;

public class Main {
    public final static void main(final String[] c_Args) throws Exception {
        Theatre v_Theater = new Theatre(new String("95 Hilltop Drive"), new String("20th Century Theatre"), 200, 34.99,
                new String("15:00 - 00:00"));

        System.out.println(new String("Name: ") + v_Theater.f_get_name());
        System.out.println(new String("Address: ") + v_Theater.f_get_address());
        System.out.println(new String("Visitors count: ") + v_Theater.f_get_visitors_count());
        System.out.println(new String("Visit price: ") + v_Theater.f_get_visit_price());
        System.out.println(new String("Work time: ") + v_Theater.f_get_work_time());

        System.out.println();
        v_Theater.f_show_performance();
    }
}
