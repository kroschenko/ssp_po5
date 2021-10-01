package com.company;

public class Main {

    public static void main(String[] args) {
        for (String cs : args) {
            System.out.println("Argument = " + cs);
            System.out.println(isAllLowerCase(cs));
        }

    }
    public static boolean isAllLowerCase(String cs) {
        if (cs != null && !isEmpty(cs)) {
            int sz = cs.length();

            for (int i = 0; i < sz; ++i) {
                if (!Character.isLowerCase(cs.charAt(i))) {
                    System.out.println("Your text contains upper case or gaps");
                    return false;
                }
            }
            System.out.println("Your text is in lower case");
            return true;
        }
        else  {
            System.out.println("Your text is null, or you didn't enter any text");
            return false;
        }
    }

    public  static  boolean isEmpty ( final  CharSequence cs) {
        return cs == null || cs.length () == 0;
    }
}
