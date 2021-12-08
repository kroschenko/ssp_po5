package kkk;

import java.util.Arrays;
import java.util.Scanner;

	public class Hello {
	    public static void main(String[] args) {
	    	int N=15; //Число чисел
	    	int[] massiv = new int[N]; //Массив
	    	for(int i=0 ;i<N; i++) { 
	    		int a =(int)(Math.random() * 500 ); //Рандом чисел до 500
	    		massiv[i]=a; //Заполнение массива
	    	}
	        Task1(massiv);
	        Task2(massiv, N);
	        Task3();
	    }
	    
	    public static void Task1(int [] massiv) { //Первая задача
	        System.out.println("Задание 1");
	        int 
	        o=0, //Число подсчёта одноциферных чисел
	        d=0, //Число подсчёта двуциферных чисел 
	        t=0; //Число подсчёта трехциферных чисел
	        for(int i=0;i<massiv.length;i++) {
	        	if(massiv[i]<10) {
	        		System.out.print("Одноциферное число: ");
	        		o++;
	        	}else if(massiv[i]<100) {
	        		System.out.print("Двуциферное число: ");
	        		d++;
	        	}else {
	        		System.out.print("Трехциферное число: ");
	        		t++;
	        	}
	        	System.out.println(massiv[i]);
	        }
	        System.out.print("Число одноциферных чисел - ");
	        System.out.println(o);
	        System.out.print("Число двуциферных чисел - ");
	        System.out.println(d);
	        System.out.print("Число трехциферных чисел - ");
	        System.out.println(t);
	  
	    }
	    public static void Vivod_massiv(int [] massiv, int N) { //Вывод всего массива
	    	System.out.print("Массив: [");
	    	for (int i=0;i<N;i++) {
	    		if(i==(N-1)) {
	    			System.out.print(massiv[i]);
	    		}
	    		else {
	    		System.out.print(massiv[i]+", ");
	    		}
	    	}
	    	System.out.println("]");
	    	
	    }
	    
	    public static void Task2(int [] massiv, int N) { //Вторая задача
	    	System.out.println("Задание 2");
	    	Vivod_massiv(massiv, N);
	    	System.out.println("Введите число на которое вы хотите сдвинуть массив влево");
	    	Scanner scanner= new Scanner (System.in);
	    	int shift = scanner.nextInt(); 
	    	scanner.close();
	    	if (shift >N) { //Если сдвиг больше чем длина массива
	    		shift =shift%N; 
	    	}
	    	
	    	if (shift ==0) {} //Проверка, если сдвиг имеет смысл выполнять
	    	else {
	    		int massiv_b[] = Arrays.copyOf(massiv, massiv.length); //Копирование исходного массива в новый
	    		for(int i=0; i<N;i++) {
	    			massiv[i]=massiv_b[(shift+i)%15]; //Сдвигаем массив
	    		}	
	    	}
	    	Vivod_massiv(massiv, N);
	    }
	    
	    public static void Task3() { //Третья задача
	    	System.out.println("Задание 3");
	    	String first =  "0011110abcabc";
	    	System.out.println(first);
	    	System.out.println("^");
	    	String Second = "0000111abcbca";
	    	System.out.println(Second);
	    	System.out.println("-------------");
	    	StringBuilder sb = new StringBuilder();

	    	for(int i = 0; i < first.length(); i++)
	    		sb.append((first.charAt(i) ^ Second.charAt(i)));

	    	String result = sb.toString();
	    	System.out.println(result);
	    }
}