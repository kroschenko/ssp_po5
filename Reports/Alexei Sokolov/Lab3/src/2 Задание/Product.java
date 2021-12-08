package kkk;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Product {

	private

	ArrayList<Integer> Id=new ArrayList<>(10);  //Id
	ArrayList<Long> UPC=new ArrayList<>(10);  //Штрих-код
	ArrayList<String> Name=new ArrayList<>(10); //Название товара
	ArrayList<Float> Price=new ArrayList<>(10); //Цена
	ArrayList<String> Manufactures=new ArrayList<>(10); //Производитель
	ArrayList<Integer> Amount=new ArrayList<>(10); //Количество
	ArrayList<String> Date=new ArrayList<>(10); //Дата истечение срока хранения
	// SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	public
	Product() {
	}
	void Download(String directory){ //Чтение файла с данными о продуктах
		try {
			File file_first=new File(directory);
			Scanner scanner= new Scanner(file_first, "UTF8");
			while(scanner.hasNextLine()) {
				String line=scanner.nextLine();
				String[] mass_first =line.split(" ");
				this.Id.add(Integer.parseInt(mass_first[0].trim()));
				this.UPC.add(Long.parseLong(mass_first[1]));
				this.Name.add(mass_first[2]);
				this.Price.add(Float.valueOf(mass_first[3]));
				this.Manufactures.add(mass_first[4]);
				this.Amount.add(Integer.parseInt(mass_first[5].trim()));
				this.Date.add(mass_first[6]);
			}
			scanner.close();
		}catch(IOException e){
			System.out.println("Error: " +e);
		}
	}
	void Search_Name(String name) { //Поиск по товару
		int a=0;
		for(int i=0;i<this.Id.size();i++) {
			if(name.equals(this.Name.get(i))) {
				this.table();
				this.vivod(i);
				a++;
			}
		}
		if(a==0) {
			System.out.println("Такого товара ("+name+") не существует");
		}
	}
	void Search_price_down(float price) { //Поиск товаров ниже указанной цены
		int a=0;
		for(int i=0;i<this.Id.size();i++) {
			if(price>=this.Price.get(i)) {
				if(a==0) {
					this.table();
				}
				this.vivod(i);
				a++;
			}
		}
		if(a==0) {
			System.out.println("Таких товаров ниже указанной стоимости ("+price+") не существует");
		}
	}
	void Data() { //Проверка товаров у которых закончился срок годности
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date dateOne= new Date();
		System.out.printf("%1$s %2$td %2$tB %2$tY\n", "Сегодняшняя дата:", dateOne);
		Date dateTwo = null;
		int a=0;
		for(int i=0;i<this.Id.size();i++) {
			try {
				dateTwo = format.parse(this.Date.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dateOne.getTime()>=dateTwo.getTime()) {
				if(a==0) {
					this.table();
				}
				this.vivod(i);
				a++;
			}
		}



	}

	@Override
	public String toString() {
		String f="";
		this.table();
		for(int i=0;i<this.Id.size();i++) {
			this.vivod(i);
		}
		return f;
	}
	void table() {
		System.out.printf("%-5s%-15s%-13s%-7s%-22s%-12s%-29s%n","ID","Штрих-код","Наименование","Цена","Производитель","Количество","Дата истечение срока хранения");
	}
	void vivod(int i){
		System.out.printf("%-5s%-15s%-13s%-7s%-22s%-12s%-29s%n",this.Id.get(i),this.UPC.get(i),this.Name.get(i),this.Price.get(i),this.Manufactures.get(i),this.Amount.get(i),this.Date.get(i));
	}

}
