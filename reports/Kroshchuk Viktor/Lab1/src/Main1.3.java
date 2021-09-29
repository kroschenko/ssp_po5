package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите слово на проверку нижнего регистра:");
        String cs =input.nextLine();
       // String cs=null;
        System.out.println(isAllLowerCase(cs));
    }

    public static boolean isAllLowerCase(String cs) {
        if (cs != null && !isEmpty(cs)) {
            int sz = cs.length();

            for (int i = 0; i < sz; ++i) {
                if (!Character.isLowerCase(cs.charAt(i))) {
                    System.out.println("В вашем тексте есть верхний регистр либо пропуски");
                    return false;
                }
            }
            System.out.println("Ваш текст введен нижним регистром");
            return true;
        }
        else  {
            System.out.println("Ваш текст равен null, либо вы не ввели текст");
            return false;
        }
    }

    public  static  boolean isEmpty ( final  CharSequence cs) {
        return cs == null || cs.length () == 0;
    }
}
