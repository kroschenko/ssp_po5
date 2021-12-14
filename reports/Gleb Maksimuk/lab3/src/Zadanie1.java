import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Mnojestvo mnoj1 = new Mnojestvo();
		System.out.println(mnoj1);
		Mnojestvo mnoj2 = new Mnojestvo();
		System.out.println(mnoj2);
		mnoj1.combine(mnoj2);
		System.out.println(mnoj1);
		mnoj1.isElem("t");
		mnoj1.addition();
		System.out.println(mnoj1);
		mnoj1.deletion();
		System.out.println(mnoj1);
		Mnojestvo mnoj3 = new Mnojestvo();
		System.out.println(mnoj3);
		mnoj1.equals(mnoj3);		
    }
}
class Mnojestvo {
	int n; //мощность
	String[] M;
	Mnojestvo () {
		System.out.println("Vvedite moschnost mnojestva:");
		Scanner in = new Scanner(System.in);	//считываем из консоли
		n = in.nextInt();
		in.nextLine();
		if (n > 0) {
			String[] Mn = new String[n];
			System.out.println("Vvedite elementi (cherez probel):");
			for (int i = 0; i < n; i++) {
				Mn[i] = in.next();
			}
			M = Mn;		
		}
	}
	public void combine(Mnojestvo M2) { //объединение множеств
		String[] Mn = new String[this.n + M2.n];
		int i;
		for (i = 0; i < this.n; i++) {
			Mn[i] = this.M[i];
		}
		for (; i < this.n + M2.n; i++) {
			Mn[i] = M2.M[i-this.n];
		}
		this.n = this.n + M2.n;
		this.M = Mn;		
	}
	public void isElem(String e) { //поиск элемента в множестве
		boolean elem = false;
		System.out.println("Poisk elementa " + e + " v mnojestve");
		for(int i = 0; i < this.n; i++) if (this.M[i].equals(e)) elem = true;
		if (elem == true) System.out.println("Element " + e + " prinadlejit mnojestvu");
		else System.out.println("Element " + e + " ne prinadlejit mnojestvu");
	}
	public void addition() {
		System.out.println("Vvedite poziciu");
		Scanner in = new Scanner(System.in);	//считываем из консоли
		int pos = in.nextInt();
		in.nextLine();
		System.out.println("Vvedite element");
		String elem = in.next();
		pos--;
		if (pos < 0) pos = 0;
		String[] Mn = new String[this.n + 1];
		for (int i = 0; i < this.n; i++) {
			if (i == pos) {
				Mn[i+1] = M[i];
				Mn[i] = elem;
			}
			if (i < pos) Mn[i] = this.M[i];
			if (i > pos) Mn[i + 1] = this.M[i];
		}
		if (pos >= this.n) Mn[this.n] = elem;
		this.n = this.n + 1;
		this.M = Mn;
	}
	public void deletion() {
		Scanner in = new Scanner(System.in);	//считываем из консоли
		System.out.println("Vvedite element na udalenie");
		String elem = in.next();
		int pos=-1;
		for(int i = 0; i < this.n; i++)	if (this.M[i].equals(elem)) pos = i;
		if (pos >= 0) {
			String[] Mn = new String[this.n -1];
			for (int i = 0; i < this.n -1; i++) {
				if (i == pos) {
					Mn[i] = M[i+1];
				}
				if (i < pos) Mn[i] = this.M[i];
				if (i > pos) Mn[i] = this.M[i + 1];
		}
		this.n = this.n - 1;
		this.M = Mn;
		}
		else System.out.println("V mnojestve netu takogo elementa");
	}
	boolean equals(Mnojestvo Mn) {
		boolean res = true;
		if (this.n != Mn.n) res = false;
		if (res == true) {
			for (int i = 0; i < this.n; i++) //если Mn.n больше, то и смысла в этом нету
				if (this.M[i].equals(Mn.M[i]) == false) res = false;
		}
		if (res == true) System.out.println("Mnojestva ravni");
		else System.out.println("Mnojestva ne ravni");
		return res;
	}
    @Override
    public String toString() {
	String str = "Elementi mnojestva: ";
	for (int i = 0; i < this.n; i++)
		str += this.M[i] + " ";
        return str;
    }
}
