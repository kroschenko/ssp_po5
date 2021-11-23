package SSP.Lab3.Task1;

public class Solution {

    public static void main(String[] args) {
        CharMultitude fistSet = new CharMultitude(new char[]{'a','a','b','c'});
        CharMultitude secondSet = new CharMultitude(new char[]{'a','d','f'});
        System.out.println(fistSet);
        System.out.println(secondSet);
        System.out.println("Пересечение множеств");
        System.out.println(CharMultitude.intersection(fistSet, secondSet));

        System.out.println("Добавление");
        fistSet.add('1');
        System.out.println(fistSet);

        System.out.println("Удаление");
        secondSet.remove('f');
        System.out.println(secondSet);

        CharMultitude fistEq = new CharMultitude(new char[]{'a','d','f'});
        CharMultitude secondEq = new CharMultitude(new char[]{'a','d','f'});
        CharMultitude thirdEq = new CharMultitude(new char[]{'a','d','f','t'});
        System.out.println(fistEq.toString() + " == " + secondEq.toString() + " "+ fistEq.equals(secondEq));
        System.out.println(fistEq.toString() + " == " + thirdEq.toString() + " "+ fistEq.equals(thirdEq));

    }
}
