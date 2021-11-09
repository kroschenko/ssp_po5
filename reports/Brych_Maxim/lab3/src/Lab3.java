
import Model.Bus;
import Model.enums.LocationStatus;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;



public class Lab3 {

    public static void main(String[] args) throws Exception {
        Task1();
        Task2(Integer.parseInt(args[0]));
    }

    private static void Task1() {
        Triangle triangle = new Triangle();
        triangle.setTriangle(3f, 4f, 5f);

        Triangle triangle2 = new Triangle(3f, 4f, 5f);

        Triangle triangle3 = new Triangle();
        triangle3.setCathet_1(5f);
        triangle3.setCathet_2(6f);
        triangle3.setHypotenuse(7f);
        Triangle[] triangles = new Triangle[]{triangle, triangle2, triangle3};
        for (int i = 0; i < triangles.length; i++) {
            System.out.println("Треугольник №" + (i + 1) + " :" + triangles[i]);
            if (triangles[0].isRectangular()) System.out.println("Треугольник №" + (i + 1) + " - прямоугольный");
            else System.out.println("Треугольник №" + (i + 1) + " - непрямоугольный");
            System.out.println("Периметр треугольника №" + (i + 1) + " :" + triangles[i].Perimeter());
            System.out.format("Площадь треугольника №%d : %.3f \n", i+1 , triangles[i].Square());
        }
        if (triangle.equals(triangle2)) System.out.println("Треугольники 1 и 2 - равны");
        else System.out.println("Треугольники 1 и 2 - не равны");
    }

    private static void Task2(int routeNumber) {
        Connection conn = ManagerDB.connectDB();
        // ManagerDB.addElement(conn, new Bus("User name","34664","2","Neman Long",2012,345678L, LocationStatus.ROUTE.toString()));
        List<Bus> buses = ManagerDB.selectTable(conn , "bus");
        showTable(buses);
        showBusInROUTE(buses);
        showBusInPARK(buses);
        showBusByRouteNumber(buses, routeNumber);
        showBusByYear(buses);
        showBusByMileage(buses);
    }

    private static void showTable(List<Bus> buses) {
        System.out.println("\n\nФормирование данных обо всех автобусах в виде списка");
        for(Bus bus : buses)
            bus.print();
    }

    private static void showBusByYear(List<Bus> buses) {
        System.out.println("\n\nСписок автобусов, которые эксплуатируются больше 10 лет");
        for(Bus bus : buses)
        if(Calendar.getInstance().get(Calendar.YEAR) - bus.getYearOperation() > 10)
            bus.print();
    }

    private static void showBusByMileage(List<Bus> buses) {
        System.out.println("\n\nСписок автобусов, пробег у которых больше 100000 км.");
        for(Bus bus : buses)
        if(bus.getMileage() > 100000)
            bus.print();
    }

    private static void showBusByRouteNumber(List<Bus> buses, int routeNumber) {
        System.out.println("\n\nСписок автобусов для заданного номера маршрута (Маршрут №" + routeNumber + ")");
        for(Bus bus : buses)
            if(Integer.parseInt(bus.getRouteNumber()) == routeNumber)
                bus.print();
    }

    private static void showBusInROUTE(List<Bus> buses) {
        System.out.println("\n\nФормирование списка автобусов выехавших из парка");
        for(Bus bus : buses) {
            if(bus.getLocation().toString().equals(LocationStatus.PARK.toString()))
                continue;
            bus.print();
        }
    }

    private static void showBusInPARK(List<Bus> buses) {
        System.out.println("\n\nФормирование списка автобусов оставшихся в парке");
        for(Bus bus : buses) {
            if(bus.getLocation().toString().equals(LocationStatus.ROUTE.toString()))
                continue;
            bus.print();
        }
    }
}
