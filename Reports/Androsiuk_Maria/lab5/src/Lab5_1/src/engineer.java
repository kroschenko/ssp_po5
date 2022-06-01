
public class engineer implements employee
{
	String salaryDay;
	
	public engineer(String _salaryDay) 
	{
		salaryDay = _salaryDay;
	}
	
	public void show()
	{
		
	}
	
	public void payday()
	{
		System.out.println(salaryDay);
	}
}
