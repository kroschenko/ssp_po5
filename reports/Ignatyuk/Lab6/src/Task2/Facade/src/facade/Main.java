package facade;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        final Integer c_Hours = 9, c_Minutes = 40;

        final MechanicalWatches c_MechanicalWatches = new MechanicalWatches(c_Hours, c_Minutes);
        final WatchesFacade c_FirstFacade = new WatchesFacade(c_MechanicalWatches);
        final WatchesUser c_FirstUser = new WatchesUser(c_FirstFacade);

        final DigitalWatches v_DigitalWatches = new DigitalWatches(c_Hours, c_Minutes);
        final WatchesFacade c_SecondFacade = new WatchesFacade(v_DigitalWatches);
        final WatchesUser c_SecondUser = new WatchesUser(c_SecondFacade);

        System.out.println("Time on mechanical watches: " + c_FirstUser.f_get_time());
        System.out.println("Angle of rotation of the hour hand: " + c_MechanicalWatches.f_get_hour_degrees());
        System.out.println("Angle of rotation of the minute hand: " + c_MechanicalWatches.f_get_minute_degrees());
        System.out.println();
        System.out.println("Time on digital watches: " + c_SecondUser.f_get_time());
    }
}
