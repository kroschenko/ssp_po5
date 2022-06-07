package lab;

public class Main {

    public static void main(String[] args) {
	Trolleybus trbus1 = new Trolleybus("4A51", 54, 2, 1);
	Trolleybus trbus2 = new Trolleybus("8C51", 50, 50, 2.5);
	trbus1.show();
	trbus2.showAll();
    }
}

interface Transport {
    void show();
    void showAll();
}

abstract class PublicTransport implements Transport{
    private String number;
    private int seats;

    public PublicTransport(String _number, int _seats) {
        number = _number;
        seats = _seats;
    }

    public String getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }
}

class Trolleybus extends PublicTransport {
    private int route;
    private double fare;
    public Trolleybus (String _number, int _seats, int _route, double _fare) {
        super(_number, _seats);
        route = _route;
        fare = _fare;
    }
    @Override
    public void show() {
        System.out.println("Trolleybus №" + super.getNumber() + " works on route " + route);
    }

    @Override
    public void showAll() {
        System.out.println("Trolleybus №" + super.getNumber() + " works on route " + route +
                ". It costs " + fare + "$ and has " + super.getSeats() + " seats." );
    }
}