import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SuperClass {
    public static void main(String[] args) {
        CargoСarrier cargoCompany = new CargoСarrier();
        cargoCompany.Initialization();
        int num = cargoCompany.ChooseCity();
        cargoCompany.showPrice(num);
    }
}

class CargoСarrier
{
    private int numCity, num;
    private List<Integer> Distance = new ArrayList<Integer>();
    private List<String> City = new ArrayList<String>();

    Scanner in = new Scanner(System.in);

    public void Initialization()
    {
        char[] c = new char[10];
        Arrays.fill(c, '*');
        String str = new String(c);
        str.replace('\n', '\0');
        System.out.println(str + " Cargo carrier parameters " + str);

        System.out.print("Enter the number of cities to which the cargo carrier delivers the cargo: "); 
        this.numCity = in.nextInt();
        in.nextLine();
 
        for (int i = 0; i < this.numCity; i++)
        {
            System.out.print("Enter the name of the city at #" + i + ": ");
            this.City.add(in.nextLine());
 
            System.out.print("Specify the distance to the city " + this.City.get(i) + ": ");
            this.Distance.add(in.nextInt());
            in.nextLine();
        }
 
        System.out.println(str + " The end of initialization " + str);
    }
 
    public int ChooseCity()
    {
        do {
            System.out.print("Enter the number of the city where you want to deliver: ");
            num = in.nextInt();
            in.nextLine();
            if(num > this.numCity) {
                System.out.println("Error! There is no city with this number");
            }
            else { return num; }
        } while(true);
    }
    public void showPrice(int num)
    {
        String city = this.City.get(num);
        int s = this.Distance.get(num);

        System.out.println("********" + " Pricelist for cargo transportation to the city " + city + "********");
        System.out.println("\nDelivery by plane to the city " + city + ", distance to the city " + s);
        System.out.println("Price: " + this.AirplaneDeliveryCharges(s) + 
        "; Duration of delivery: " + this.AirplaneDeliveryTime(s));

        System.out.println("\nDelivery by train to the city " + city + ", distance to the city " + s);
        System.out.println("Price: " + this.TrainDeliveryCharges(s) + 
        "; Duration of delivery: " + this.TrainDeliveryTime(s));
 
        System.out.println("\nDelivery by car to the city " + city + ", distance to the city " + s);
        System.out.println("Price: " + this.CarDeliveryCharges(s) + 
        "; Duration of delivery: " + this.CarDeliveryTime(s));
    }

    public int AirplaneDeliveryTime(int s)
    {
        return new Airplane().DeliveryTime(s);
    }
    public int TrainDeliveryTime(int s)
    {
        return new Train().DeliveryTime(s);
    }
    public int CarDeliveryTime(int s)
    {
        return new Car().DeliveryTime(s);
    }
 
    public int AirplaneDeliveryCharges(int s)
    {
        return new Airplane().DeliveryCharges(s);
    }
 
    public int TrainDeliveryCharges(int s)
    {
        return new Train().DeliveryCharges(s);
    }
    public int CarDeliveryCharges(int s)
    {
        return new Car().DeliveryCharges(s);
    }
}
 
class Airplane extends CargoСarrier
{
    private int price = 100000;
    private int speed = 500;
 
    public int DeliveryTime(int s)
    {
        return s / speed;
    }
 
    public int DeliveryCharges(int s)
    {
        int t = DeliveryTime(s);
 
        if (t >= 0 && t <= 10) return price;
        else if (t > 20) return price + 5000;
        else return price + 10000;
    }
}
 
class Train extends CargoСarrier
{
    private int price = 40000;
    private int speed = 120;

 
    public int DeliveryTime(int s)
    {
        return s / speed;
    }
 
    public int DeliveryCharges(int s)
    {
        int t = DeliveryTime(s);
 
        if (t >= 0 && t <= 10) return price;
        else if (t > 20) return price + 5000;
        else return price + 10000;
    }
}
 
class Car extends CargoСarrier
{
    private int price = 20000;
    private int speed = 80;
 
    public int DeliveryTime(int s)
    {
        return s / speed;
    }
 
    public int DeliveryCharges(int s)
    {
        int t = DeliveryTime(s);
 
        if (t >= 0 && t <= 10) { return price; }
        else if (t > 20) { return price + 5000; }
        else { return price + 10000; }
    }
}