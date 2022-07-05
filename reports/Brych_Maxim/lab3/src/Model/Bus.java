package Model;

public class Bus {
    private Long id;
    private String FIO;
    private String autoNumber;
    private String routeNumber;
    private String brand;
    private int yearOperation;
    private Long mileage;
    private String location;


    public Bus(String FIO, String autoNumber, String routeNumber, String brand, int yearOperation, Long mileage, String location) {
        this.FIO = FIO;
        this.autoNumber = autoNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.yearOperation = yearOperation;
        this.mileage = mileage;
        this.location = location;
    }

    public Bus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOperation() {
        return yearOperation;
    }

    public void setYearOperation(int yearOperation) {
        this.yearOperation = yearOperation;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "FIO='" + FIO + '\'' +
                ", autoNumber='" + autoNumber + '\'' +
                ", routeNumber='" + routeNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOperation=" + yearOperation +
                ", mileage=" + mileage +
                ", location='" + location + '\'' +
                '}';
    }
    public void print() {
        System.out.println(this.toString());
    }
}
