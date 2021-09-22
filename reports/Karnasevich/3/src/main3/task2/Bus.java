package main3.task2;

import java.util.Objects;
import java.util.Optional;


public class Bus {

    private final Driver driver;

    private final int number;

    private final int creationYear;

    private final String brand;

    private final double mileage;

    private boolean isAssigned;

    private int route;

    public Bus(Driver driver, int number, int creationYear, String brand, double mileage) {
        this.driver = driver;
        this.number = number;
        this.creationYear = creationYear;
        this.brand = brand;
        this.mileage = mileage;
    }

    public Bus(Driver driver, int number, int creationYear, String brand, double mileage, int route) {
        this(driver, number, creationYear, brand, mileage);
        this.route = route;
        isAssigned = true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, creationYear, brand, mileage, driver, isAssigned, route);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return number == bus.number && creationYear == bus.creationYear && Double.compare(bus.mileage, mileage) == 0 && isAssigned == bus.isAssigned && route == bus.route && Objects.equals(brand, bus.brand) && Objects.equals(driver, bus.driver);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "driver=" + driver +
                ", number=" + number +
                ", creationYear=" + creationYear +
                ", brand='" + brand + '\'' +
                ", mileage=" + mileage +
                ", isAssigned=" + isAssigned +
                ", route=" + route +
                '}';
    }

    public String brand() {
        return brand;
    }

    public double mileage() {
        return mileage;
    }

    public int number() {
        return number;
    }

    public int creationYear() {
        return creationYear;
    }

    public void assign(int route) {
        isAssigned = true;
        this.route = route;
    }

    public void unassign() {
        isAssigned = false;
    }

    public Optional<Integer> route() {
        return isAssigned ? Optional.of(route) : Optional.empty();
    }
}
