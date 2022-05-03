package task2;

public class LongSum {

    public static long accum ( long[] values ) {
        long result = 0;
        for ( int i = 0; i < values.length; i++) {
            result += values[i];
        }
        return result;
    }
}
