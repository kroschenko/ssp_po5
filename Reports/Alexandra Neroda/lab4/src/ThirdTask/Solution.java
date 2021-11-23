package SSP.Lab4.ThirdTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Bus bus1 = new Bus(1);
        Bus bus2 = new Bus(38);
        Bus bus3 = new Bus(21);
        Trolleybus trolley1 = new Trolleybus(4);
        Trolleybus trolley2 = new Trolleybus(5);
        Trolleybus trolley3 = new Trolleybus(228);
        Route route = new Route("Больница - Красный двор",4,8);
        route.add(bus1,bus2,bus3, trolley1, trolley2);
        route.addAddition(trolley3);
        route.start();
    }

    public static class Route{
        String name;
        Checker checker = new Checker();
        double distance;
        int numberOfStops;

        double interval = (distance/numberOfStops)*60;//мин

        public Route(String name,double distance, int numberOfStops) {
            this.name = name;
            this.distance = distance;
            this.numberOfStops = numberOfStops;
        }

        void add(CityVehicle...vehicles){
            for(CityVehicle temp: vehicles){
                this.checker.vehicles.add(new VehicleByRoute(temp,distance,numberOfStops));
            }
        }
        void addAddition(CityVehicle...vehicles){
            for(CityVehicle temp: vehicles){
                this.checker.vehiclesAddition.add(new VehicleByRoute(temp,distance,numberOfStops));
            }
        }

        void start(){
            new Thread(checker).start();
            synchronized (checker) {
                while (!checker.vehicles.isEmpty()) {
                    new Thread(checker.vehicles.get(0)).start();
                    checker.vehicles.remove(0);
                    try {
                        Thread.sleep((long)(100*checker.intervalMultiply));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private class VehicleByRoute implements Runnable{
            CityVehicle vehicle;
            double distance;
            int numberOfStops;

            public VehicleByRoute(CityVehicle vehicle, double distance,int numberOfStops) {
                this.vehicle = vehicle;
                this.distance = distance;
                this.numberOfStops = numberOfStops;
            }

            @Override
            public void run() {
                double interval = distance/numberOfStops;
                startTrip();
                for(double d = 0, i = 0; d < distance;d+=interval,i++){
                    try {
                        Thread.sleep((long)((interval/this.vehicle.speed)*60*60) );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Arrived(i+1);

                    int accident = (int)(Math.random()*10);
                    if(accident < 1) {
                        System.out.print("Произошла авария!!!!");
                        synchronized (vehicle) {
                            this.vehicle.isAlive = false;
                        }
                        break;
                    }
                }

                    System.out.println(vehicle.toString() + " закончил движение");
                    vehicle.isArrive = true;

            }

            private synchronized void startTrip(){
                vehicle.start();
            }
            private synchronized void Arrived(double num) {
                System.out.println(vehicle.toString() + " прибыл на остановку №" + num);
            }
        }
        public class Checker implements Runnable{
            boolean interrupt=false;
            double intervalMultiply=1;
            List<VehicleByRoute> vehicles = new ArrayList<>();
            List<VehicleByRoute> vehiclesAddition = new ArrayList<>();

            @Override
            public void run() {
                List<VehicleByRoute> list = new ArrayList<>(vehicles);
                while(!interrupt) {
                    interrupt = true;
                    synchronized (vehicles) {

                        for (VehicleByRoute vr : list) {
                            if (!vr.vehicle.isAlive) {
                                if (!vehiclesAddition.isEmpty()) {
                                    list.add(vehiclesAddition.get(0));
                                    vehicles.add(0,vehiclesAddition.get(0));
                                    vehiclesAddition.remove(0);
                                    break;
                                } else
                                    intervalMultiply += 5;
                            }
                            if(!vr.vehicle.isArrive)
                                interrupt=false;
                        }
                    }
                }
            }
        }
    }

    public static class Bus extends CityVehicle{

        public Bus(int number) {
            super(number,50);
            this.name = "Автобус";
        }
    }
    public static class Trolleybus extends CityVehicle{
        public Trolleybus(int number) {
            super(number,40);
            this.name = "Троллейбус";
        }
    }

}
