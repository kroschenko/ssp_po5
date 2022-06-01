import java.util.*;


public class hospital 
{
	
	public void addPatient(String patName, int age)
	{
		patient pat = new patient();
		pat.patName = patName;
		pat.age = age;
		pat.condition = "In hospital";
		pats.add(pat);
	}
	
	public void addDoc(String docName, String patName)
	{
		doctor doc = new doctor();
		doc.docName = docName;
		doc.patName = patName;
		docs.add(doc);
		for(patient x: pats)
		{
			if (x.equals(x, patName)) x.docName = docName; else System.out.println("Have no patient with this name in our hospital");
			
		}
	}
	
	public void addProc(String proc, String patName, String docName)
	{
		boolean has = false;
		for(doctor d: docs)
			if (d.docName == docName)
			{
				has = true;
				if(d.patName == patName)
				{
					for(patient p: pats)
					{
						if (p.equals(p, patName))
						{
							p.proc = proc;
						}
					}
				}
				break;
			}
		if (has == false)
		{
			System.out.println("We haven't this doctor!");
			return;
		}
	}
	
	public void show()
	{
		for(patient x: pats)
		{
			System.out.println(x.toString());
		}
	}
	
	public void leavePat(String patName)
	{
		for(patient p: pats)
		{
			if(p.equals(p, patName))
			{
				p.condition = "Discharged";
			}
		}
	}
	
	Vector<patient> pats = new Vector<>();
	Vector<doctor> docs = new Vector<>();
}
