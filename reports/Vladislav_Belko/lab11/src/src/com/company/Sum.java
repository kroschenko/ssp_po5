package com.company;

public class Sum {
    public static long accum(int ...values){
        long result = 0;
        for( int i = 0; i < values.length ; i++) {
            result += values [i];
        }
        return result;
    }
}
