import java.util.ArrayList;

public class Zadanie1 {

    public static void main(String[] args) {

        City city = new City();
        city.AddPlace(1, "Pobediteley", "Gogolya", "Lenina");
        city.AddPlace(2, "Nezavisimosti", "Budennogo", "Svobody");
        city.show();
    }
}
class City {
    private class Place {
        int num;
		String avenue; //проспект
        String street;//улица
        String square;//площадь

        @Override
        public String toString() {
            return "Place " + num +
					"\nAvenu: " + avenue +
                    "\nStreet: " + street +
                    "\nSquare: " + square +"\n";
        }
    }
    ArrayList<Place> places = new ArrayList<Place>();
    public void AddPlace (int n, String AddAvenue, String AddStreet, String AddSquare) {
        Place place = new Place();
        place.num = n;
		place.avenue = AddAvenue;
        place.street = AddStreet;
        place.square = AddSquare;
        places.add(place);
    }
    public void show () {
		System.out.println("City:\n");
        for (Place place : places) {
            System.out.println(place.toString());
        }
    }
}
