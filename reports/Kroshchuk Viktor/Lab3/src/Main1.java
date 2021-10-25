package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IntegerSet integerSet1 = new IntegerSet();
        integerSet1.addItem(123);
        integerSet1.addItem(230);
        integerSet1.addItem(456);
        ArrayList<Integer> integerList = new ArrayList() {{
            add(10);
            add(12);
            add(456);
        }};
        IntegerSet integerSet2 = new IntegerSet(integerList);

        System.out.println("Первое множество: " + integerSet1);
        System.out.println("Второе множество: " + integerSet2);

        System.out.println("integerSet1 == integerSet2? -  " + (integerSet1.equals(integerSet2)));

        System.out.println("Добавление двух элементов ...");
        integerSet2.addItem(123);
        integerSet1.addItem(10);
        System.out.println("Первое множество: " + integerSet1);
        System.out.println("Второе множество: " + integerSet2);

        System.out.println("Пересечение: " + integerSet2.intersections(integerSet1));

        System.out.println("Второй элемент integerSet2 = " + integerSet2.getItemById(2));
        System.out.println("integerSet2 содержит 12? - " + integerSet2.contains(12));

        System.out.println("Удаление элемента... ");
        integerSet1.deleteItemById(2);
        integerSet2.deleteItemById(3);
        System.out.println("Первое множество: " + integerSet1);
        System.out.println("Второе множество: " + integerSet2);

    }
}
