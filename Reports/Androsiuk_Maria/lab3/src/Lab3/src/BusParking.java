
public class BusParking 
{
	private String DriverName, NumberOfBus, busBrand, location;
	private int routeNumber, yearStart, mileage;
	
	public BusParking(String DriverName1, String NumberOfBus1, String busBrand1, String location1, int routeNumber1, int yearStart1, int mileage1)
	{
		this.DriverName = DriverName1;
		this.NumberOfBus = NumberOfBus1;
		this.busBrand = busBrand1;
		this.location = location1;
		this.routeNumber = routeNumber1;
		this.yearStart = yearStart1;
		this.mileage = mileage1;
	}
	
	public void ShowInfo()
	{
		System.out.println("Driver name: "+DriverName);
		System.out.println("Number of bus: "+NumberOfBus);
		System.out.println("Bus brand: "+busBrand);
		System.out.println("Location now: "+location);
		System.out.println("Route "+routeNumber);
		System.out.println("From "+yearStart+" year");
		System.out.println("Mileage: "+mileage+" km");
	}
	
}
