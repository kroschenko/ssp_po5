package lab;

public class Bus {
    private String fio;
    private int num_bus;
    private int num_route;
    private String brand;
    private int year;
    private int mileage;
    private boolean location; //true - in the park; false - on the road

    public Bus (String _fio, int _num_bus, int _num_route, String _brand, int _year, int _mileage, boolean _location) {
        fio = _fio;
        num_bus = _num_bus;
        num_route = _num_route;
        brand = _brand;
        year = _year;
        mileage = _mileage;
        location = _location;
    }

    public int getNum_route() {
        return num_route;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public boolean isInThePark() {
        return location;
    }

    @Override
    public String toString() {
        String str_location;
        if (location) str_location = "Park";
         else str_location = "Road";
        return "FIO: " + fio + '\n' +
                "Bus Number: " + num_bus + '\n' +
                "Route: " + num_route + '\n' +
                "Brand: " + brand + '\n' +
                "Year: " + year + '\n' +
                "Mileage: " + mileage + '\n' +
                "Location: " + str_location + '\n';
    }
}
