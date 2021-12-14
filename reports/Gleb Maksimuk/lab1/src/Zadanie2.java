public class Zadanie2 {
	public static void main(String[]args) {
		int i;
		double[]OldArray = new double [args.length-2];
		for (i = 0; i<args.length-2; i++)
			OldArray[i] = Double.parseDouble(args[i]);
		int ind = Integer.parseInt(args[args.length-2]);
		double elem=Double.parseDouble(args[args.length-1]);
		double[]EndArray = add(OldArray, ind, elem);
		for (i = 0; i<EndArray.length; i++)
			System.out.print(EndArray[i]+" ");
	}
	public static double[]add(double[]array, int index, double element){
		int j = 0;
		double[] NewArray = new double [array.length+1];
		if (index>NewArray.length) index = NewArray.length;
		if (index<1) index = 1;
		for(int i = 0; i<NewArray.length;i++) {
			if (i+1 == index) {
				NewArray[i] = element;
				j = 1;
			}
			if (i+j<NewArray.length)
				NewArray[i+j] = array[i];
		}
		return NewArray;
	}
}