package org.example;

public class StringUtils {

    public static String repeat(String str, String separator, int repeat) {
        if (repeat < 0) {
            throw new IllegalArgumentException();
        }

        if (str == null || separator == null) {
            throw new NullPointerException();
        }

        if (repeat == 0) {
            return "";
        }

        if (repeat == 1) {
            str = str.trim();
            return str;
        }

        if (separator.equals(",")) {
            str = str.trim();
            String temp = "";
            for (int i = 1; i <= repeat; i++) {
                temp += str + " ";
                if (i < repeat) {
                    temp += separator + " ";
                }
            }
            return temp;
        }

        if (str.equals("")) {
            str = str.trim();
            for (int i = 1; i < repeat; i++) {
                str += separator;
            }
            return str;
        }

        if (separator.equals("")) {
            String temp = str;
            str = "";
            str = str.trim();
            for (int i = 0; i < repeat; i++) {
                str += temp;
            }
            return str;
        }

        String result = "";
        for(int i = 1; i <= repeat; i++){
            result += str;
            if(i < repeat){
                result += separator;
            }
        }
        return result;
    }

    public static String repeat(String str, int repeat) {
        throw new IllegalArgumentException();
    }

    static String repeat(String str) {
        throw new NullPointerException();
    }
}
