package kkk;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Next {
	public static void main(String[] args){
		String way_noun= "One.txt"; //существительные
		String way_adjective= "Two.txt"; //прилагательные
		String way_verb= "Three.txt"; //глаголы
		String way_preposition= "Four.txt"; //предлоги
		int a,b,c,d;
		a=number(way_noun);
		System.out.println("Количество существительных в файле - " + a );
		String[] noun=new String[a];
		filling(way_noun,noun);

		b=number(way_adjective);
		System.out.println("Количество прилагательных в файле - " + b );
		String[] adjective=new String[b];
		filling(way_adjective,adjective);

		c=number(way_verb);
		System.out.println("Количество глаголов в файле - " + c );
		String[] verb=new String[c];
		filling(way_verb,verb);

		d=number(way_preposition);
		System.out.println("Количество предлогов в файле - " + d );
		String[] preposition=new String[d];
		filling(way_preposition,preposition);

		for(int i=0;i<20;i++) { //Составление предложений
			int aa =(int)(Math.random() * a );
			int aaa =(int)(Math.random() * a );
			int bb =(int)(Math.random() * b );
			int cc =(int)(Math.random() * c );
			int dd =(int)(Math.random() * d );
			String name;
			name = noun[aa].substring(0,1).toUpperCase() + noun[aa].substring(1).toLowerCase(); //Первый элемент с заглавной буквы
			System.out.println("Предложение "+ (i+1) +": " + name+ " " + verb[cc]+ " "  + preposition[dd]+ " "  + adjective[bb]+ " "  + noun[aaa]+ "." );
		}
	}
	public static void filling(String directory, String word[]) { //Заполнение массива данными из файла
		String line = null;
		int i = 0,k=0;
		try {
			File file=new File(directory);
			Scanner scanner= new Scanner(file, "UTF8");
			while(scanner.hasNextLine()) {
				line=scanner.nextLine();
				String[] mass =line.split(" ");
				k=mass.length;
				for(int t=0;t<k;t++) {
					word[i]=mass[t];
					i++;
				}
			}
			scanner.close();
		} catch(IOException e){
			System.out.println("Error: " +e);
		}
	}

	public static int number(String directory) { //Определение количества слов в файле
		String line = null;
		int i = 0;
		try {
			File file=new File(directory);
			Scanner scanner= new Scanner(file, "UTF8");
			while(scanner.hasNextLine()) {
				line=scanner.nextLine();
				String[] mass =line.split(" ");
				i+=mass.length;
			}
			scanner.close();

		} catch(IOException e){
			System.out.println("Error: " +e);
		}
		return i;
	}
}

