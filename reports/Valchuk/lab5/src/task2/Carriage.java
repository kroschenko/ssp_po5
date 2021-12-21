import java.time.Duration;

public class Carriage implements IVehicle {
    @Override
    public Duration getTransportationTime(int distanceKm) {
        return Duration.ofMinutes(30).multipliedBy(distanceKm);
    }

    @Override
    public Double getTransportationCost(int distanceKm) {
        return 12.5 * distanceKm;
    }
}
