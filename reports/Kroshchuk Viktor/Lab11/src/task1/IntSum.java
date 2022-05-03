package task1;

public class IntSum {

    public int accum ( int[] values ) {
        int result = 0;
        for ( int i = 0; i < values.length; i++) {
            result += values[i];
        }
        return result;
    }
}
