package org.example;

public class Sum {
    public static int accum (int...values) {
        int result = 0;
        for ( int i = 0; i < values.length; i ++) {
            result += values[i];
        }
        return result;
    }
    public static long longaccum(long...values){
        long result = 0;
        for (int i = 0; i < values.length; i++) {
            result += values[i];
        }
        return result;
    }
}
