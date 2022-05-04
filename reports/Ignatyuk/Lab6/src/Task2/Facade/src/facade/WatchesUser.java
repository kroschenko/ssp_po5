package facade;

public final class WatchesUser {
    private final WatchesFacade m_WatchesFacade;

    public WatchesUser(final WatchesFacade c_WatchesFacade) {
        this.m_WatchesFacade = c_WatchesFacade;
    }

    public final String f_get_time() {
        return m_WatchesFacade.f_get_time();
    }
}
