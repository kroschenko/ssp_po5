package main3.task2;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Park {

    private final Collection<Bus> buses;

    public Park(Collection<Bus> buses) {
        this.buses = buses;
    }

    public Collection<Bus> find(Predicate<Bus> predicate) {
        return buses.stream().filter(predicate).collect(Collectors.toList());
    }
}
