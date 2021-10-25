package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public static void main(String[] args) throws ParseException {
        Airline airline = getAirline();
        System.out.println("------------Все полёты------------");
        airline.printListOfFlights();
        System.out.println("\nВылеты с выбранным расстоянием: ");
        airline.printListOfFlightsForSelectedDestination("Брест");
        System.out.println("\nВылеты по выбранным дням: ");
        airline.printListOfFlightsForSelectedDay(DayOfWeek.MONDAY);
        System.out.println("\nВылеты по выбранному дню и времени: ");
        airline.printListOfFlightsForSelectedDayAndTime(DayOfWeek.SUNDAY, dateFormat.parse("15.10.2021 03:12:10"));
        System.out.println("\nВылеты по выбранному типу: ");
        airline.printListOfFlightsForSelectedType(TypeOfAircraft.AVERAGE);
    }
    private static Airline getAirline() throws ParseException {
        Airline airline = new Airline(new ArrayList<>());

        airline.addFlights(new Flight("Брест", 1, TypeOfAircraft.AVERAGE, dateFormat.parse("12.09.2020 10:12:10"),
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.FRIDAY)));

        airline.addFlights(new Flight("Витебск", 2, TypeOfAircraft.SMALL, dateFormat.parse("14.10.2020 10:56:10"),
                Arrays.asList(DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)));

        airline.addFlights(new Flight("Гродно", 3, TypeOfAircraft.MAJOR, dateFormat.parse("15.03.2020 09:30:10"),
                Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.TUESDAY)));

        airline.addFlights(new Flight("Могилёв", 4, TypeOfAircraft.AVERAGE, dateFormat.parse("19.02.2023 11:42:22"),
                Arrays.asList(DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY)));

        airline.addFlights(new Flight("Гомель", 5, TypeOfAircraft.MAJOR, dateFormat.parse("15.03.2020 09:30:10"),
                Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.WEDNESDAY)));

        airline.addFlights(new Flight("Минск", 6, TypeOfAircraft.AVERAGE, dateFormat.parse("14.10.2017 08:21:11"),
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)));

        airline.addFlights(new Flight("Брест", 7, TypeOfAircraft.SMALL, dateFormat.parse("15.10.2013 05:13:10"),
                Arrays.asList(DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY)));

        return airline;
    }
}
