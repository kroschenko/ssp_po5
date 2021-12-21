import java.time.Duration;

public class Bicycle implements IVehicle {
    @Override
    public Duration getTransportationTime(int distanceKm) {
        return Duration.ofMinutes(15).multipliedBy(distanceKm);
    }

    @Override
    public Double getTransportationCost(int distanceKm) {
        return 30.0 * distanceKm;
    }
}
