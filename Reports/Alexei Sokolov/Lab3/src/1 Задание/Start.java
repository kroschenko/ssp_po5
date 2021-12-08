package kkk;

public class Start {
	public static void main(String[] args){
		Many_numbers a1=new Many_numbers();
		Many_numbers a2=new Many_numbers(2.798f);
		Many_numbers a3=new Many_numbers(5.7f);
		System.out.print("Выводим первый - ");
		System.out.println(a1.getNumbers());
		System.out.print("Выводим второй - ");
		System.out.println(a2.getNumbers());
		System.out.println("Добавляем ко второму число 5.7");
		a2.setNumbers(5.7f);
		System.out.print("Выводим второй - ");
		System.out.println(a2.getNumbers());

		System.out.println(Many_numbers.intersection(a1,a2));
		System.out.println("Удаление по индексу(1) в первом: " + a1.getNumbers());
		a1.remove(1);
		System.out.print("Выводим первый - ");
		System.out.println(a1.getNumbers());
		System.out.println("Удаление 3.87 в первом, а также добавляем 5.7 в конец ");
		a1.remove(3.87f);
		a1.setNumbers(5.7f);
		System.out.print("Выводим первый - ");
		System.out.println(a1.getNumbers());

		System.out.println(Many_numbers.intersection(a1,a2));
		System.out.print(a1.getNumbers() + " == " +a2.getNumbers() +" ");
		System.out.println(a1.equals(a2));
		System.out.print(a1.getNumbers() + " == " +a3.getNumbers() +" ");
		System.out.println(a1.equals(a3));
		System.out.println(a1);
	}
}
