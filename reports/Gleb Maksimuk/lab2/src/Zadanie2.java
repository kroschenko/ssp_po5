import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.io.*;
public class uniq {
	public static void main(String[]args) throws Exception {
		boolean c = false, d = false, u = false, i = false;
		if (args.length > 1){
			if (args[1].equals("-c")) c = true;
			if (args[1].equals("-d")) d = true;
			if (args[1].equals("-u")) u = true;
			if (args[1].equals("-i")) i = true;
		}
		if (args.length > 2)
			if (args[2].equals("-i")) i = true;
		if (args[0].equals("uniq")) {
			if (args.length == 1) result(args[0], 0, 1, c, d, u, i, false, args[args.length -1]);	//uniq
			if (args.length == 2) {
		if (args[1].equals("-c") || args[1].equals("-d") || args[1].equals("-u") || args[1].equals("-i") || args[1].equals("-")) result(args[1], 1, args.length, c, d, u, i, false, args[args.length -1]);	//uniq ?
		else result(args[1], 1, args.length, c, d, u, i, true, args[args.length -1]);  //uniq file
	}
	if (args.length == 3) {
		if (args[1].equals("-c") || args[1].equals("-d") || args[1].equals("-u") || args[1].equals("-i") || args[1].equals("-")) {							
			if (args[2].equals("-") || args[2].equals("-i")) result(args[2], 2, args.length, c, d, u, i, false, args[args.length -1]);		//uniq ? ?
			else result(args[2], 2, args.length, c, d, u, i, true, args[args.length -1]);	//uniq ? file
		}
		else result(args[1], 1, args.length, c, d, u, i, true, args[args.length -1]);//uniq file exitfile
	}
	if (args.length == 4) {
		if (args[2].equals("-i")) {
			if (args[3].equals("-")) result(args[3], 3, args.length, c, d, u, i, false, args[args.length -1]); //uniq ? i -
			else result(args[3], 3, args.length, c, d, u, i, true, args[args.length -1]); //uniq ? i file
		}				
		else result(args[2], 2, args.length, c, d, u, i, true, args[args.length -1]); //uniq ? file exitfile
	}
	if (args.length == 5) result(args[3], 3, args.length, c, d, u, i, true, args[args.length -1]); //uniq ? -i file exitfile
}
}
public static void result(String arg, int number, int length, boolean keyc, boolean keyd, boolean keyu, boolean keyi, boolean filefounded, String exit) throws Exception {
	//получение входных данных
	int n = 0;					//количество строк в файле или в консоли
	Scanner in = new Scanner(System.in);		//считываем из консоли
	if (filefounded == false) {
		System.out.println("Vvedite 4islo strok:");
		n = in.nextInt();				//число строк на ввод
		in.nextLine();			//при считывании "n" в in.nextLine() попадёт \n
	} else {
		File file = new File(arg);
		Scanner scanner = new Scanner(file);
		String str;
		while(scanner.hasNextLine()) {
		str = scanner.nextLine();
		n++;
	}
	scanner.close();
}
if (n > 0) {
	String[] text = new String[n];
	if (filefounded == false) {
		System.out.println("Vvedite stroki:");
		for (int i = 0; i < n; i++) text[i] = in.nextLine();
	}
	else {
		File file = new File(arg);
		Scanner scan = new Scanner(file);
		for (int i = 0; i < n; i++) {
			text[i] = scan.nextLine();
			System.out.println(text[i]);
		}
		scan.close();
		if (keyc == false && keyd == false && keyu == false && number +1 < length) {
			FileWriter writer = new FileWriter(exit, false);  //перезапись выходного файла
			for (int i = 0; i < n; i++) writer.write(text[i] + "\n");
			writer.close();
			System.out.println("Result is writed in file " + exit);
		}
	}
	//обработка данных сформированного массива
	if (keyc == true) { //Перед каждой строкой выводить число повторений этой строки на входе и один пробел.
		int notwin = 1;	//неблизнец
		String[] textc = new String[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (keyi == false) {
					if (i != j && text[i].equals(text[j])) notwin++;
				}
				else if (i != j && text[i].equalsIgnoreCase(text[j])) notwin++;	//сравнение строк без учёта регистров
			}
			textc[i] = notwin + " " + text[i];
			notwin = 1;
		}
		if (filefounded == false || number + 1 == length) {
			if (keyi == true) System.out.println("Result without registers:");
			else System.out.println("Result:");
			for (int i = 0; i < n; i++) System.out.println(textc[i]);	//вывод на консоль
		} else {
				FileWriter writer = new FileWriter(exit, false); //перезапись выходного файла
				for (int i = 0; i < n; i++) writer.write(textc[i] + "\n");
				writer.close();
				System.out.println("Result is writed in file " + exit);
		}
	}
	else if (keyd == true) {		//Выводить только те строки, которые повторяются на входе
	int notwin = n;			//сначала количество неблизнецов
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (keyi == false) {
					if (i != j && text[i].equals(text[j])) {
						notwin-- ;
						j = n;
					}
				} else {
					if (i != j && text[i].equalsIgnoreCase(text[j])) {
						notwin-- ;
						j = n;
					}
				}
		String[] res = new String[n - notwin];
		int Nr = 0;
		notwin = 0;		//а теперь проверка на неблизнеца
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (keyi == false) {
					if (i != j && text[i].equals(text[j])) notwin++;
				} else {
					if (i != j && text[i].equalsIgnoreCase(text[j])) notwin++;
				}
			if (notwin > 0) {					//близнец
				res[Nr] = text[i];
				Nr++;
			}
			notwin = 0;
		}
		if (filefounded == false || number + 1 == length) {
			if (keyi == true) System.out.println("Result without registers:");
			else System.out.println("Result:");
			for (int i = 0; i < Nr; i++) System.out.println(res[i]);	//вывод на консоль
		} else {
			FileWriter writer = new FileWriter(exit, false); //перезапись выходного файла
			for (int i = 0; i < Nr; i++) writer.write(res[i] + "\n");
			writer.close();
			System.out.println("Result is writed in file " + exit);
		}
	}
	else if (keyu == true) { //Выводить только те строки, которые не повторяются на входе
		int notwin = n;			//сначала количество неблизнецов
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (keyi == false) {
					if (i != j && text[i].equals(text[j])) {
						notwin-- ;
						j = n;
					}
				} else {
					if (i != j && text[i].equalsIgnoreCase(text[j])) {
						notwin-- ;
						j = n;
					}
				}
		String[] res = new String[notwin];
		int Nr = 0;
		notwin = 0;			//а теперь проверка на неблизнеца
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (keyi == false) {
					if (i != j && text[i].equals(text[j])) notwin++;
				}
				else if (i != j && text[i].equalsIgnoreCase(text[j])) notwin++;
			if (notwin == 0) {					//неблизнец
				res[Nr] = text[i];
				Nr++;
			}
			notwin = 0;
		}
		if (filefounded == false || number + 1 == length) {
			if (keyi == true) System.out.println("Result without registers:");
			else System.out.println("Result:");
			for (int i = 0; i < Nr; i++) System.out.println(res[i]);	//вывод на консоль
		} else {
			FileWriter writer = new FileWriter(exit, false); //перезапись выходного файла
			for (int i = 0; i < Nr; i++) writer.write(res[i] + "\n");
			writer.close();
			System.out.println("Result is writed in file " + exit);
		}			
}}}}
