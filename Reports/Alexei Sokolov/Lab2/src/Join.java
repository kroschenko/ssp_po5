package kkk;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Join {
	public static void main(String[] args){
		int a=1,b=1,join=0;
		int lenght=args.length-1;
		System.out.println("Начинается проверка переданных значений!");
		if (lenght<2) { //Проверка если переданных значений меньше чем нужно, то завершает программу
			System.out.println("Переданных значений не достаточно");
			return;
		}
		else {
			System.out.println("Переданных значений достаточно");
		}
		for (int i=0;i<args.length;i++) {
			if(args[i].equals("Join")) { //Убедимся что утилита Join именно вызывается
				join=1;
			}
			if(args[i].equals("-1")) { //Проверка на ключ для первого файла
				a=Integer.parseInt(args[i+1]);
			}
			if(args[i].equals("-2")){ //Проверка на ключ для второго файла
				b=Integer.parseInt(args[i+1]);
			}
		}
		if (join==1) {
			System.out.println("Утилита Join выполняется с файлами:");
		}
		else {
			System.out.println("Неизвестная утилита");
			return;
		}
		if(args[lenght-2].equals("-")) {

		}
		String way_first;
		String way_two;
		String way_result;
		way_first=args[lenght-2];
		System.out.println("Путь до первого файла - " + way_first);
		way_two=args[lenght-1];
		System.out.println("Путь до второго файла - " + way_two);
		way_result=args[lenght];
		System.out.println("Путь до файла с результатами - " + way_result);
		int number_first, number_two;
		number_first=number(way_first,a);
		number_two=number(way_two,b);
		String[] content_first=new String[number_first];
		String[] join_content=new String[number_first*number_two];
		int[] Coincidence=new int[number_first*number_two];
		first(way_first,a,content_first); //Запись в массив всех слов в колонке "а"
		int number_Coincidence=Two(way_two, b, content_first,Coincidence,join_content); //Чтение второго файла и поиск схожести с первым файлом колонок
		first_last(way_first,a,Coincidence, join_content, number_Coincidence);
		result(join_content,number_Coincidence, way_result);
		System.out.println("Вывод результата на консоль: ");
		for(int i=0;i<number_Coincidence;i++) {
			System.out.println(join_content[i]);
		}


	}
	public static void first_last(String directory_first,int a, int Coincidence[], String [] join, int number_Coincidence) {
		int t=0; //t- это номер предложения [0,1,2..n]
		try {
			File file_first=new File(directory_first);
			Scanner scanner_first= new Scanner(file_first, "UTF8");
			while(scanner_first.hasNextLine()) {
				String line=scanner_first.nextLine();
				String[] mass_first =line.split(" ");
				int i=mass_first.length;
				for(int j=0;j< number_Coincidence;j++) { //Записываем в for для того чтобы найти повторы в совпадениях
					if(t==Coincidence[j]) {  //Предложение "t" сравнивается с числом, в котором было найдено совпадение
						for(int g=0;g<i;g++) {
							if(g==(a-1)) { //Исключаем то слово которое сравнивали и переходим к следующему
								g++;
							}
							if(g!=i) {
								join[j]= join[j]+" "+mass_first[g]; //Запись в массив предложения из первого файла
							}
						}
					}
				}
				t++; //Переход к следующему предложению
			}
			scanner_first.close();
		} catch(IOException e){
			System.out.println("Error: " +e);
		}
	}
	public static int number(String directory,int a) { //Определение количества слов в ряде "a"
		String line = null;
		int i,number=0;
		try {
			File file=new File(directory);
			Scanner scanner= new Scanner(file, "UTF8");
			while(scanner.hasNextLine()) {
				line=scanner.nextLine();
				String[] mass =line.split(" ");
				i=mass.length;
				if(a<=i) {
					number++;
				}
			}
			scanner.close();

		} catch(IOException e){
			System.out.println("Error: " +e);
		}
		return number;
	}

	public static void first(String directory_first, int a,String[] content) {//Запись в массив всех слов в колонке "а"
		int t=0;
		try {
			File file_first=new File(directory_first);
			Scanner scanner_first= new Scanner(file_first, "UTF8");
			while(scanner_first.hasNextLine()) {
				String line=scanner_first.nextLine();
				String[] mass_first =line.split(" ");
				int i=mass_first.length;
				if(a<=i) {
					content[t]=mass_first[a-1];
					t++;
				}
			}
			scanner_first.close();
		} catch(IOException e){
			System.out.println("Error: " +e);
		}
	}

	public static int Two(String directory_two, int b,String[] content_first,int[] Coincidence, String[] join) {
		int t=0;
		String content_two;
		try {
			File file_first=new File(directory_two);
			Scanner scanner_two= new Scanner(file_first, "UTF8");
			while(scanner_two.hasNextLine()) {
				String line=scanner_two.nextLine();
				String[] mass_two =line.split(" ");
				int i=mass_two.length;
				if(b<=i) {
					content_two=mass_two[b-1];
					for(int a=0;a<content_first.length;a++) {
						if(content_first[a].equals(content_two)) {
							Coincidence[t]=a;
							join[t]=content_first[a];
							for(int z=0;z<i;z++) {
								if(z==(b-1)) {
									z++;
								}
								if(z!=i) {

									join[t]= join[t]+" "+mass_two[z];
								}
							}
							t++;
						}
					}
				}
			}
			scanner_two.close();
		} catch(IOException e){
			System.out.println("Error: " +e);
		}
		return t;
	}
	public static void result(String[] join, int number, String way_result) {
		try {
			File file_result=new File(way_result);
			PrintWriter pw=new PrintWriter(file_result);
			for(int i=0;i<number;i++) {
				pw.println(join[i]);
			}
			pw.close();
		} catch(IOException e){
			System.out.println("Error: " +e);
		}
	}
}


