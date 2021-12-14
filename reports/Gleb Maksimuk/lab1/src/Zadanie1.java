public class Zadanie1 {
	public static void main(String[]args){
		int index = 0;
		if (args.length%2 == 0) {
			index += args.length/2-1;
			float Mediana = (Float.parseFloat(args[index])+Float.parseFloat(args[index+1]))/2;
			System.out.println(Mediana);
		}
		else {
			index += (args.length+1)/2-1;
			System.out.println(args[index]);
		}
		
	}
}