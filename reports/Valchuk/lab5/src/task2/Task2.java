import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<IVehicle> vehicles = List.of(new Car(), new Bicycle(), new Carriage());

        for (IVehicle vehicle: vehicles) {
            System.out.println(vehicle.getClass() + " " + vehicle.getTransportationTime(10) +
                    " " + vehicle.getTransportationCost(10));
        }
    }
}
