package lab;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static final int CURRENT_YEAR = 2018;

    public static void main(String args[]) throws IOException {
        printMenu();
        ArrayList <Bus> buses = readInfo("D:\\Study\\5 sem\\SPP\\3\\lab3_2\\src\\buses.txt");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String ch = sc.nextLine();
            switch (ch) {
                case "1":
                    func1(buses);
                    break;
                case "2":
                    func2(buses);
                    break;
                case "3":
                    func3(buses);
                    break;
                case "4":
                    System.out.println("Enter the route:");
                    int route = Integer.parseInt(sc.nextLine());
                    func4(buses, route);
                    break;
                case "5":
                    func5(buses);
                    break;
                case "6":
                    func6(buses);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Enter again:");
                    continue;
            }
            break;
        }

    }

    private static void func1 (ArrayList<Bus> buses) {
        for (Bus bus: buses) {
            System.out.println(bus.toString());
        }
    }

    private static void func2 (ArrayList<Bus> buses) {
        for (Bus bus: buses) {
            if (!bus.isInThePark()) {
                System.out.println(bus);
            }
        }
    }

    private static void func3 (ArrayList<Bus> buses) {
        for (Bus bus: buses) {
            if (bus.isInThePark()) {
                System.out.println(bus);
            }
        }
    }

    private static void func4 (ArrayList<Bus> buses, int route) {
        for (Bus bus: buses) {
            if (bus.getNum_route() == route) {
                System.out.println(bus);
            }
        }
    }

    private static void func5 (ArrayList<Bus> buses) {
        for (Bus bus: buses) {
            if (CURRENT_YEAR - bus.getYear() > 10) {
                System.out.println(bus);
            }
        }
    }

    private static void func6 (ArrayList<Bus> buses) {
        for (Bus bus: buses) {
            if (bus.getMileage() > 100000) {
                System.out.println(bus);
            }
        }
    }

    private static void printMenu() {
        System.out.println("Enter 1 to display info about buses");
        System.out.println("Enter 2 to display info about buses on the road");
        System.out.println("Enter 3 to display info about buses in the park");
        System.out.println("Enter 4 to display info about buses  of the specified route");
        System.out.println("Enter 5 to display info about buses which have been operated for more than 10 years");
        System.out.println("Enter 6 to display info about buses which mileage is more than 100000 km");
        System.out.println("Enter 0 to exit");
    }

    private static ArrayList<Bus> readInfo(String fileName) throws
            IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String sCurrentLine;
        ArrayList<Bus> buses = new ArrayList<Bus>();
        while (((sCurrentLine = br.readLine()) != null) &&
                !sCurrentLine.equals("")) {
            String fio = sCurrentLine;
            int num_bus = Integer.parseInt(br.readLine());
            int num_route = Integer.parseInt(br.readLine());
            String brand = br.readLine();
            int year = Integer.parseInt(br.readLine());
            int mileage = Integer.parseInt(br.readLine());
            boolean location = Boolean.parseBoolean(br.readLine());
            Bus bus = new Bus(fio, num_bus, num_route, brand, year, mileage, location);
            buses.add(bus);
        }
        return buses;
    }

}
