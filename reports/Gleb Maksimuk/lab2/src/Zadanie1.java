import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie1 {
	public static void main(String[]args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Andrey\\Desktop\\data.txt");
		Scanner scanner = new Scanner(file);
		String str="";
		String currstr="";
		while(scanner.hasNextLine()) {
			currstr = scanner.nextLine();
			System.out.println(currstr);
			str = str + currstr;
		}
		char [] Num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int NNum = Number(str, Num);
		System.out.println("The number of digits in the file: "+NNum);
		if (NNum > 0){
			if (NNum%2 != 0) NNum++;
			NNum=NNum/2;
			int n = 0;
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				str = scanner.nextLine();
				n = n + Number(str, Num);
				if (n >= NNum) {
					System.out.println("String containing a digit with a serial number n/2: "+str);
					break;
				}
			}
		}
		else System.out.println("The file does not contain numbers");
		scanner.close();
	}
	public static int Number(String str, char[]Num){
		int result = 0;
		for(int i = 0; i < str.length(); i++)
			for(int j = 0; j < 10; j++)
				if (str.charAt(i) == Num[j]) result++;
		return result;
	}
} 
