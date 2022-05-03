package com.company;

import java.util.Date;
import java.util.List;

public class Flight {
    private String destination;
    private int flightNumber;
    private TypeOfAircraft typeOfAircraft;
    private Date departureTime;
    private List<DayOfWeek> daysOfTheWeek;
    public Flight(String destination, int flightNumber, TypeOfAircraft typeOfAircraft,
                  Date departureTime,
                  List<DayOfWeek> daysOfTheWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.typeOfAircraft = typeOfAircraft;
        this.departureTime = departureTime;
        this.daysOfTheWeek = daysOfTheWeek;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public TypeOfAircraft getTypeOfAircraft() {
        return typeOfAircraft;
    }
    public void setTypeOfAircraft(TypeOfAircraft typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }
    public Date getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
    public List<DayOfWeek> getDaysOfTheWeek() {
        return daysOfTheWeek;
    }
    public void setDaysOfTheWeek(List<DayOfWeek> daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }
    @Override
    public String toString() {
        return "Полёты{" +
                "Расстояние= '" + destination + '\'' +
                ", Номер вылета= " + flightNumber +
                ", Тип самолета= " + typeOfAircraft +
                ", Время отправл= " + departureTime +
                ", День недели= " + daysOfTheWeek +
                '}';
    }
}
