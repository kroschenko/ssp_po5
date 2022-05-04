package facade;

public final class WatchesFacade {
    private final DigitalWatches m_DigitalWatches;
    private final MechanicalWatches m_MechanicalWatches;

    public WatchesFacade(final DigitalWatches c_DigitalWatches) {
        this.m_DigitalWatches = c_DigitalWatches;
        this.m_MechanicalWatches = null;
    }

    public WatchesFacade(final MechanicalWatches c_MechanicalWatches) {
        this.m_DigitalWatches = null;
        this.m_MechanicalWatches = c_MechanicalWatches;
    }

    public final String f_get_time() {
        if (m_DigitalWatches != null) {
            return m_DigitalWatches.f_get_time();
        }

        return m_MechanicalWatches.f_get_time();
    }
}
