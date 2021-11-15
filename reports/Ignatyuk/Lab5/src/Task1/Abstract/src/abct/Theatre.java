package abct;

public final class Theatre extends PublicBuilding {
    public Theatre(final String c_Name, final String c_Address) {
        super(c_Name, c_Address);
    }

    public Theatre(final String c_Name, final String c_Address, final Integer c_VisitorsCount) {
        super(c_Name, c_Address, c_VisitorsCount);
    }

    public Theatre(final String c_Name, final String c_Address, final Integer c_VisitorsCount,
            final Double c_VisitPrice) {
        super(c_Name, c_Address, c_VisitorsCount, c_VisitPrice);
    }

    public Theatre(final String c_Name, final String c_Address, final Integer c_VisitorsCount,
            final Double c_VisitPrice, final String c_WorkTime) {
        super(c_Name, c_Address, c_VisitorsCount, c_VisitPrice, c_WorkTime);
    }

    public final void f_show_performance() {
        System.out.println("Very interesting performance...");
    }
}
