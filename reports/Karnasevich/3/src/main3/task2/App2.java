package main3.task2;

import java.util.List;

import static java.lang.System.out;


public class App2 {

    public static void main(String[] args) {
        var park = new Park(
                List.of(
                        new Bus(new Driver("a", "b"), 1, 2000, "A", 50000, 1),
                        new Bus(new Driver("c", "d"), 2, 2010, "B", 30000, 2),
                        new Bus(new Driver("e", "f"), 3, 2015, "B", 10000),
                        new Bus(new Driver("g", "h"), 4, 2019, "C", 5000),
                        new Bus(new Driver("m", "n"), 5, 1992, "A", 100000, 3)
                )
        );
        // All buses
        out.println(park.find(x -> true));
        // All out of the park
        out.println(park.find(x -> x.route().isEmpty()));
        // All in the park
        out.println(park.find(x -> x.route().isPresent()));
        // Find by route
        out.println(park.find(x -> x.route().isPresent() && x.route().get() == 1));
        // Find by using
        out.println(park.find(x -> x.creationYear() < 2011));
        // Find by mileage
        out.println(park.find(x -> x.mileage() >= 100000));
    }
}
