public class Zadanie1 {

   public static void main(String[] args) {
   AircraftCarrier trAirCar1 = new AircraftCarrier("HMS Argus", 5000, 3);
   AircraftCarrier trAirCar2 = new AircraftCarrier("Mistral", 20000, 5);
   trAirCar1.show();
   trAirCar2.showAll();
    }
}

interface Ship {//корабль
    void show();
    void showAll();
}

abstract class WarShip implements Ship{//военный корабль
    private String name;
    private int torpedo;

    public WarShip(String _name, int _torpedo) {
        name = _name;
        torpedo = _torpedo;
    }

    public String getName() {
        return name;
    }

    public int getTorpedo() {
        return torpedo;
    }
}

class AircraftCarrier extends WarShip {//авианосец
    private int cost;
    public AircraftCarrier (String _name, int _torpedo, int _cost) {
        super(_name, _torpedo);
        cost = _cost;
    }
    @Override
    public void show() {
		System.out.println("AircraftCarrier " + super.getName() + " has " + super.getTorpedo() + " torpedo.");
    }

    @Override
    public void showAll() {
        System.out.println("AircraftCarrier " + super.getName() + " costs " + cost + "000000000$ and has " + super.getTorpedo() + " torpedo." );
    }
}
