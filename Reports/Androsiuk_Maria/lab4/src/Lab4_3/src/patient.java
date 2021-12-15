public class patient
{
	String patName;
	String docName;
	String proc;
	String condition;
	int age;
	
	@Override
	public String toString()
	{
		return "Patient name: "+patName+"\nProcedure: "+proc+"\nAge: "+age+"\nDoctor: "+docName+"\n"+"Condition: "+condition+"\n";
	}
	
	public boolean equals(patient pat, String patName)
	{
		if (pat.patName == patName) return true;
		else return false;
	}
}
