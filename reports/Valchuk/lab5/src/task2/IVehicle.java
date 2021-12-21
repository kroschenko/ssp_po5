import java.time.Duration;

public interface IVehicle {
    Duration getTransportationTime(int distanceKm);
    Double getTransportationCost(int distanceKm);
}
