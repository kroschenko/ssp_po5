import java.util.*;
public class Lab5_2 
{

	public static void main(String[] args) 
	{
		Vector<musicInst> insts = new Vector<>();
		insts.add(new percussion("drums", "Vasya"));
		insts.add(new strings("guitar","Kolya"));
		insts.add(new wind("trumpet", "Grysha"));
		
		for (musicInst i: insts)
		{
			i.show();
		}
	}

}
