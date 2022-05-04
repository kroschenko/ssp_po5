package model;

public abstract class PublicBuilding extends TownBuilding {
    private Integer m_VisitorsCount = 0;
    private Double m_VisitPrice = 0.0;
    private String m_WorkTime = new String("00:00 - 00:00");

    public PublicBuilding(final String c_Name, final String c_Address) {
        super(c_Name, c_Address);
    }

    public PublicBuilding(final String c_Name, final String c_Address, final Integer c_VisitorsCount) {
        super(c_Name, c_Address);
        this.m_VisitorsCount = c_VisitorsCount;
    }

    public PublicBuilding(final String c_Name, final String c_Address, final Integer c_VisitorsCount,
            final Double c_VisitPrice) {
        super(c_Name, c_Address);
        this.m_VisitorsCount = c_VisitorsCount;
        this.m_VisitPrice = c_VisitPrice;
    }

    public PublicBuilding(final String c_Name, final String c_Address, final Integer c_VisitorsCount,
            final Double c_VisitPrice, final String c_WorkTime) {
        super(c_Name, c_Address);
        this.m_VisitorsCount = c_VisitorsCount;
        this.m_VisitPrice = c_VisitPrice;
        this.m_WorkTime = c_WorkTime;
    }

    public final String f_get_work_time() {
        return this.m_WorkTime;
    }

    public final void f_set_work_time(final String c_WorkTime) {
        this.m_WorkTime = c_WorkTime;
    }

    public final Integer f_get_visitors_count() {
        return this.m_VisitorsCount;
    }

    public final void f_set_visitors_count(final Integer c_VisitorsCount) {
        this.m_VisitorsCount = c_VisitorsCount;
    }

    public final Double f_get_visit_price() {
        return this.m_VisitPrice;
    }

    public final void f_set_visit_price(final Double c_VisitPrice) {
        this.m_VisitPrice = c_VisitPrice;
    }
}
