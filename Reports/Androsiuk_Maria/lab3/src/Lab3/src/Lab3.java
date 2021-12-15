import java.util.*;
import java.io.*;

public class Lab3 
{

	public static void main(String[] args) throws IOException
	{
		triangle r = new triangle(5,3,7);
		triangle h = new triangle(5,2,7);
		System.out.println(r.isExist());
		System.out.println(r.perimeter());
		System.out.println(r.square());
		System.out.println(r.equals(h));
		System.out.println(r.toString());
		
		
		FileReader reader = new FileReader("K:\\bus.txt");
		BufferedReader br = new BufferedReader(reader);
		String line;
		Vector<String> vec = new Vector<>();
		while((line = br.readLine())!=null)
		{
		//System.out.println(line);
		if (line.isEmpty()) continue;
		vec.addElement(line);
		}
		br.close();
		Vector<BusParking> Buses = new Vector<>();
		while (!vec.isEmpty())
		{
			//System.out.println(vec.get(0).toString());
			BusParking Bus = new BusParking(vec.get(0).toString(), vec.get(1).toString(), vec.get(2).toString(), vec.get(3).toString(), Integer.parseInt(vec.get(4).toString()), Integer.parseInt(vec.get(5).toString()), Integer.parseInt(vec.get(6).toString()));
			Buses.addElement(Bus);
			int i=0;
			while(i!=7)
			{
				vec.remove(vec.firstElement());
				i++;
			}
		}
		//System.out.print(Buses);
		BusParking Bus2 = (BusParking) Buses.get(1);
		Bus2.ShowInfo();
	}

}
