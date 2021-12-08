package kkk;

public class Start {

	public static void main(String[] args){
		Product a1=new Product();

		a1.Download("Product1.txt");
		System.out.print(a1);

		System.out.println("Ищем в списке товаров <Фисташки>");
		a1.Search_Name("Фисташки");
		System.out.println("Ищем в списке товаров <Вафли>");
		a1.Search_Name("Вафли");

		System.out.println("Поиск товаров ниже указанной стоимости(3 руб)");
		a1.Search_price_down(3f);

		System.out.println("Проверка товаров которых срок годности закончился. ");
		a1.Data();
	}
}

