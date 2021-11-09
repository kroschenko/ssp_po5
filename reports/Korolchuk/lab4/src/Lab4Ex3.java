package com.spp.labs;

import java.util.*;

public class Lab4Ex3 {
    public static void main(String[] args) {
        Trip trip1 = new Trip("trip1");
        Trip trip2 = new Trip("trip2");
        Trip trip3 = new Trip("trip3");
        Trip trip4 = new Trip("trip4");
        Trip trip5 = new Trip("trip5");
        Trip trip6 = new Trip("trip6");
        
        Driver driver1 = new Driver("driver1");
        Driver driver2 = new Driver("driver2");
        Driver driver3 = new Driver("driver3");
        Driver driver4 = new Driver("driver4");
        Driver driver5 = new Driver("driver5");
        
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        Car car4 = new Car("car4");
        Car car5 = new Car("car5");
        
        Dispatcher dispatcher = new Dispatcher(new Trip[] {trip1, trip2, trip3, trip4, trip5},
                                               new Driver[] {driver1, driver2, driver3, driver4, driver5},
                                               new Car[] {car1, car2, car3, car4, car5});
        
        dispatcher.scheduleTrips();
        driver1.repairRequest();
        driver1.finishTrip();
        dispatcher.scheduleTrips();
        driver1.finishTrip();
        dispatcher.removeDriver(driver2);
        driver2.report();
    }
}

interface Interface {
    void repairRequest();
}

class Dispatcher {
    ArrayList<Trip> trips;
    ArrayList<Driver> drivers;
    ArrayList<Car> cars;
    
    Dispatcher(Trip[] trips, Driver[] drivers, Car[] cars) {
        this.trips = new ArrayList<>(Arrays.asList(trips));
        this.drivers = new ArrayList<>(Arrays.asList(drivers));
        this.cars = new ArrayList<>(Arrays.asList(cars));
    }
    
    public void addTrip(Trip trip) {
        trips.add(trip);
    }
    
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
    
    public void addCar(Car car) {
        cars.add(car);
    }
    
    public void scheduleTrips() {
        point1:
        for (Trip trip : trips) {
            point2:
            if (!trip.scheduled) {
                for (Driver driver : drivers) {
                    if (!driver.tripStarted && !driver.removed) {
                        for (Car car : cars) {
                            if (!car.taken && !car.needRepair) {
                                trip.scheduled = true;
                                driver.tripStarted = true;
                                car.taken = true;
                                driver.car = car;
                                driver.trip = trip;
                                break point2;
                            }
                        }
                        
                        System.out.println("Все машины заняты или нуждаются в ремонте");
                        break point1;
                    }
                }
                
                System.out.println("Все водители заняты или отстранены от работы");
            }
        }
    }
    
    public void removeDriver(Driver driver) {
        driver.removed = true;
        driver.tripStarted = false;
        driver.tripFinished = false;
        driver.car.taken = false;
        driver.trip.scheduled = false;
        driver.car = null;
        driver.trip = null;
    }
}

class Trip {
    protected String name;
    protected boolean scheduled;
    
    Trip(String name) {
        this.name = name;
    }
}

class Driver implements Interface {
    protected String name;
    protected Car car;
    protected Trip trip;
    protected boolean tripStarted;
    protected boolean tripFinished;
    protected boolean removed;
    
    Driver(String name) {
        this.name = name;
        tripStarted = false;
        tripFinished = false;
        removed = false;
        car = null;
        trip = null;
    }
    
    @Override
    public void repairRequest() {
        car.needRepair = true;
        System.out.println(name + ": отправлен запрос на ремонт автомобиля " + car.name);
    }
    
    public void finishTrip() {
        if (tripStarted && !tripFinished) {
            tripStarted = false;
            tripFinished = true;
            report();
            car.taken = false;
            trip.scheduled = false;
            tripFinished = false;
            car = null;
            trip = null;
        }
    }
    
    public void report() {
        if (removed) {
            System.out.println(name + ": водитель отстранен от работы");
        }
        else {
            if (tripStarted) {
                System.out.println(name + ": поездка на автомобиле " + car.name + " не завершена");
            }
            else if (!tripStarted && tripFinished) {
                System.out.println(name + ": поездка на автомобиле " + car.name + " завершена");
            }
            else {
                System.out.println(name + ": поездка на автомобиле не назначена");
            }

            if (car != null) {
                if (car.needRepair) {
                    System.out.println(name + ": автомобиль " + car.name + " нуждается в починке");
                }
                else {
                    System.out.println(name + ": автомобиль " + car.name + " не нуждается в починке");
                }
            }
        }
    }
}

class Car {
    protected String name;
    protected boolean needRepair;
    protected boolean taken;
    
    Car(String name) {
        this.name = name;
        needRepair = false;
        taken = false;
    }
}
