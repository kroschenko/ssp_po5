
public class Lab4_3 
{
	public static void main(String[] args) 
	{
		hospital hosp = new hospital();
		hosp.addPatient("Vasya", 15);
		hosp.show();
		hosp.addDoc("Grysha", "Vasya");
		hosp.show();
		hosp.addProc("Operation", "Vasya", "Grysha");
		hosp.show();
		hosp.leavePat("Vasya");
		hosp.show();
	}
}