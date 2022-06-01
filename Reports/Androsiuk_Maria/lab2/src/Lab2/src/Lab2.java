import java.util.*;
import java.io.*;

public class Lab2 
{

	public static void main(String[] args) throws IOException
	{
		
/////////TASK1////////////////////////////////////////////
		StringBuilder text= new StringBuilder();
		FileReader reader = new FileReader("K:\\file.txt");
		BufferedReader br = new BufferedReader(reader);
		String line;
		
		while((line = br.readLine())!=null){
		text.append(line);
		}
		br.close();
		//System.out.println(text);
		String[] words = text.toString().split("[?!., ]");
		//System.out.println(words);
		Vector<String> vec = new Vector();
		Vector<String> vec1 = new Vector();
		Vector<String> vec2 = new Vector();
		for(String word: words) 
		{
			vec.addElement(word);
		}
		while (!vec.isEmpty())
		{
			String first = (String) vec.firstElement();
			while(vec.contains(first))
			{
				if (first.length()<1)
				{
					vec.remove(first);
					continue;
				}
				if (vec2.contains(first))
				{
					vec.remove(first);
					continue;
				}
				System.out.print(first+" contains in ");
				int lines = 1;
				FileReader reader1 = new FileReader("K:\\file.txt");
				BufferedReader br1 = new BufferedReader(reader1);
				while((line = br1.readLine())!=null){
					String[] line_words = line.toString().split("[:?!., ]");
					for(String word: line_words) 
						{
							vec1.addElement(word);
						}
					if (vec1.contains(first)) {
						System.out.print(lines+" ");
						vec1.clear();
						vec2.addElement(first);
						}
					lines++;
					}
				System.out.println();
				vec.remove(first);
				br1.close();
			}
		}
	}
}
