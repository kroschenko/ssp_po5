package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public static void main(String[] args) throws ParseException {
        Airline airline = getAirline();
        System.out.println("All flights:");
        airline.printListOfFlights();
        System.out.println("\nFlights for selected destination:");
        airline.printListOfFlightsForSelectedDestination("Brest");
        System.out.println("\nFlights for selected day:");
        airline.printListOfFlightsForSelectedDay(DayOfWeek.MONDAY);
        System.out.println("\nFlights for selected day and time:");
        airline.printListOfFlightsForSelectedDayAndTime(DayOfWeek.MONDAY,
                dateFormat.parse("15.10.2021 03:12:10"));
        System.out.println("\nFlights for selected type:");
        airline.printListOfFlightsForSelectedType(TypeOfAircraft.AVERAGE);
    }
    private static Airline getAirline() throws ParseException {
        Airline airline = new Airline(new ArrayList<>());
        airline.addFlights(new Flight("Brest", 1, TypeOfAircraft.AVERAGE,
                dateFormat.parse("12.09.2020 10:12:10"),
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.FRIDAY)));
        airline.addFlights(new Flight("Vitebsk", 2, TypeOfAircraft.SMALL,
                dateFormat.parse("14.10.2020 10:56:10"),
                Arrays.asList(DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)));
        airline.addFlights(new Flight("Grodno", 3, TypeOfAircraft.MAJOR,
                dateFormat.parse("16.03.2020 09:30:10"),
                Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)));
        airline.addFlights(new Flight("Mogilev", 4, TypeOfAircraft.AVERAGE,
                dateFormat.parse("19.02.2023 11:42:22"),
                Arrays.asList(DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY)));
        airline.addFlights(new Flight("Gomel", 5, TypeOfAircraft.MAJOR,
                dateFormat.parse("15.05.2020 04:33:10"),
                Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY)));
        airline.addFlights(new Flight("Minsk", 6, TypeOfAircraft.MAJOR,
                dateFormat.parse("14.10.2017 08:21:11"),
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)));
        airline.addFlights(new Flight("Brest", 7, TypeOfAircraft.SMALL,
                dateFormat.parse("15.10.2013 05:13:10"),
                Arrays.asList(DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY)));
        return airline;
    }
}