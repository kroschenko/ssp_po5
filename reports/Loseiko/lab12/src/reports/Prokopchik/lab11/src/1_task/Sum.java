package com.company.one_task;

public final class Sum {
    public static long accum(long... values) {
        long result = 0;
        for (long value : values) {
            result += value;
        }
        return result ;
    }
}
