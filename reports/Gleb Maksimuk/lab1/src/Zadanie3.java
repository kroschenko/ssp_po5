public class Zadanie3 {
	public static void main(String[]args) {
		char simbol = args[0].charAt(0);
		int kolvo = Integer.parseInt(args[1]);
		String Stroka = repeat(simbol, kolvo);
		System.out.print("\""+Stroka+"\"");
	}
	public static String repeat(char ch, int repeat){
		String Str="";
		String simb = Character.toString(ch);
		if (repeat>0){
			for(int i=0; i<repeat; i++)
				Str = Str + simb;
		}
		return Str;
	}
}