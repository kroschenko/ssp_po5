import java.util.*;
public class Page 
{
	private class paragraph
	{
		String par;
		
		@Override
		public String toString()
		{
			return par; 
		}
		
	}
	
	Vector<paragraph> pars = new Vector<>();
	
	public void addPar(String str)
	{
		paragraph parag = new paragraph();
		parag.par = str;
		pars.add(parag);
	}
	
	public void showPage()
	{
		for(paragraph x:pars)
		{
			System.out.println("\t"+x);
		}
	}
}
