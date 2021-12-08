package kkk;

import java.util.ArrayList;

public class Many_numbers {
	private ArrayList<Float> Numbers=new ArrayList<>();
	public void setNumbers(float a) { //Добавление числа в конец массива
		this.Numbers.add(a);
	}
	public void setNumbers(float i, float j, float k) {
		this.Numbers.add(i);
		this.Numbers.add(j);
		this.Numbers.add(k);
	}
	Many_numbers(){//Конструктор без параметров
		this.setNumbers(1.56f,2.798f,3.87f);
	}
	Many_numbers(float a){ //Конструктор с параметром
		this.setNumbers(a);
	}
	public ArrayList<Float> getNumbers() { //Просмотр всех элементов в массиве
		return Numbers;
	}

	public void remove(int a){ //Удаление по номеру в массиве
		a--;
		if(Numbers.size()>a && a>=0) {
			float b=Numbers.get(a);
			Numbers.remove(b);
		}
	}
	public void remove(float a){ //Удаление по значению
		if(this.Numbers.contains((float)a)) {
			int index = Numbers.indexOf((float)a);
			Numbers.remove(index);
		}
	}
	public static ArrayList<Float> intersection(Many_numbers list1, Many_numbers list2){ //Пересечение двух множеств
		ArrayList<Float> list=new ArrayList<Float>();
		for (int i=0;i<list1.Numbers.size();i++) {
			for(int z=0;z<list2.Numbers.size();z++) {
				if(list1.Numbers.get(i).equals(list2.Numbers.get(z))) {
					list.add(list1.Numbers.get(i));
				}

			}
		}
		System.out.print("Пересечение двух множеств: A:"+ list1.getNumbers() + " и B:" + list2.getNumbers() +" = ");
		return list;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		Many_numbers that = (Many_numbers) o;

		if(Numbers.size() != that.Numbers.size())
			return false;
		int i=0;
		for (; i < Numbers.size(); i++) {
			if(this.Numbers.get(i) != that.Numbers.get(i))
				return false;
		}
		if(i == that.Numbers.size())
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "Numbers: "+this.getNumbers() ;
	}

}
