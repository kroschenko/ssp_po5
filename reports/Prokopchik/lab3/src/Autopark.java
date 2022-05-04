import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Autopark
{
    private Car[] cars;

    Map<String, Integer> data = Map.of(
            "id", 0,
            "brand", 1,
            "model", 2,
            "year", 3,
            "color", 4,
            "price", 5,
            "regNumber", 6,
            "number", 7,
            "fioClient", 8,
            "idClient", 9
    );

    public Autopark(int size) {
       cars = new Car[size];
    }
    public static void main(String[] args) {
        List<String> sentences = Input_File("file.txt");
        int numberOfCars = sentences.size();
        String[][] array = new String[numberOfCars][];

        int i = 0;
        for (String str : sentences) {
            array[i++] = str.split("\\s");
        }

        Autopark lb = new Autopark(numberOfCars);
        lb.testAutopark(array);
    }

    void ListOfCars(Car[] Cars) {
        for (Car car : Cars) {
            System.out.print(car.getBrand() + " " + car.getModel() + " | ");
        }
    }

    void ListOfBrand(Car[] Cars){
        Scanner in = new Scanner(System.in);
        String b = in.next();
        for (Car car : Cars) {
            String carBrand = car.getBrand();
            if (Objects.equals(carBrand, b)) {
                System.out.print(car.getModel() + " | ");
            }
        }
    }

    void OlderCars(Car[] Cars) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int today = 2021;
        for (Car car : Cars) {
            int carYear = car.getYear();
            if (today - carYear >= n) {
                System.out.print(car.getBrand() + " " + car.getModel() + " | ");
            }
        }
    }

    void PriceYearCars( Car[] Cars){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        for (Car car : Cars) {
            int carYear = car.getYear();
            int carPrice = car.getPrice();
            if (n == carYear && carPrice > p ) {
                System.out.print(car.getBrand() + " " + car.getModel() + " | ");
            }
        }
    }


    void TakeCars(Car[] Cars) {
        for (Car car : Cars) {
            String FIOClient = car.getFIOClient();
            if (!FIOClient.equals("null")) {
                System.out.print(car.getBrand() + " " + car.getModel() + " | ");
            }
        }
    }

    void TakeCars_WithFIOClient(Car[] Cars) {
        for (Car car : Cars) {
            String FIOClient = car.getFIOClient();
            if (!FIOClient.equals("null")) {
                System.out.print(car.getBrand() + " " + car.getModel() + ": " + FIOClient + " | ");
            }
        }
    }

    void testAutopark(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
           cars[i] = new Car(arr[i][data.get("id")], arr[i][data.get("brand")], arr[i][data.get("model")],
                    arr[i][data.get("year")], arr[i][data.get("color")], arr[i][data.get("price")],
                    arr[i][data.get("regNumber")], arr[i][data.get("number")], arr[i][data.get("fioClient")],
                    arr[i][data.get("idClient")]);
            System.out.println(cars[i].toString());
        }

        System.out.println("\n======== List of cars ========");
        ListOfCars(cars);

        System.out.print("\nInput car brand name: ");
        ListOfBrand(cars);

        System.out.print("\nInput how old your car should be: ");
        OlderCars(cars);

        System.out.print("\nInput car release year and its price: ");
        PriceYearCars(cars);

        System.out.println("\n======== Taken cars ========");
        TakeCars(cars);

        System.out.println("\n======== Clients fio ========");
        TakeCars_WithFIOClient(cars);

    }

    @Override
    public String toString() {
        return "AutoparkManager [cars=" + Arrays.toString(cars) + "]";
    }

    public static List<String> Input_File(String fileName) {
        List<String> sentences = new ArrayList<>();

        try(Scanner file = new Scanner(new File(fileName)))
        {
            while (file.hasNextLine()) {
                sentences.add(file.nextLine());
            }
            file.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return sentences.stream().map(String::trim).collect(Collectors.toList());
    }
}

class Car {
    private String id, brand, model, year, color, price, regNumber, number, fioClient, idClient;

    Car(String carID, String carBrand, String carName, String carYear, String carColor,
         String carPrice, String carRegNumber, String carNumber, String FIOClient, String IdClient) {
        this.id = carID;
        this.brand = carBrand;
        this.model = carName;
        this.year = carYear;
        this.color = carColor;
        this.price = carPrice;
        this.regNumber = carRegNumber;
        this.number = carNumber;
        this.fioClient = FIOClient;
        this.idClient = IdClient;
    }

    @Override
    public String toString() {
        return "Car [[id=" + this.id + "brand=" + this.brand + ", model=" + this.model + ", year=" + this.year +
                "]\n      [color=" + this.color + ", price=" + this.price  + ", regNumber=" + this.regNumber +
                "]\n      [number=" + this.number + ", fioClient=" + this.fioClient + ", idClient=" + this.idClient + "]]";
    }

    public String getModel() {
        return this.model;
    }
    public String getBrand() {
        return this.brand;
    }

    public Integer getYear() {
        return Integer.parseInt(this.year);
    }

    public Integer getPrice() {
        return Integer.parseInt(this.price);
    }

    public String getFIOClient() {
        return this.fioClient;
    }
}
