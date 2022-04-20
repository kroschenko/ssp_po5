package com.company;

public class StringUtils {

    static String repeat(String str, String separator, int repeat){
        if (repeat < 0){
            throw new IllegalArgumentException();
        }

        if(str == null || separator == null){
            throw new NullPointerException();
        }

        if(repeat == 1){
            str = str.trim();
            return str;
        }

        if(separator.equals(",")){
            str = str.trim();
            String temp = "";
            for (int i =1; i <= repeat; i++){
                temp += str + " ";
                if(i<repeat){
                    temp += separator + " ";
                }
            }
            return temp;
        }

        if(separator.equals("")){
            String temp = "";
            str = str.trim();
            for (int i = 1; i <= repeat; i++){
                if(i%2 != 0){
                    temp += " " + str;
                }else {
                    temp += str + " ";
                }
            }
            return temp;
        }

        String res = "";
        for(int i = 1; i <= repeat; i++){
            res += str;
            if(i < repeat){
                res += separator;
            }
        }
        return res;
    }

    static String repeat(String str, int repeat){
        throw new IllegalArgumentException();
    }

    static String repeat(String str){
        throw new IllegalArgumentException();
    }
}