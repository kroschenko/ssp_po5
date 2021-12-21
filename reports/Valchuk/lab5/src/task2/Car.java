import java.time.Duration;

public class Car implements IVehicle {
    @Override
    public Duration getTransportationTime(int distanceKm) {
        return Duration.ofMinutes(1).multipliedBy(distanceKm);
    }

    @Override
    public Double getTransportationCost(int distanceKm) {
        return 3.0 * distanceKm;
    }
}
