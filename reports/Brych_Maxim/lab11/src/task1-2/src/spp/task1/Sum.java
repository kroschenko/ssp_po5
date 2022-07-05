package spp.task1;

public class Sum {
    public static int accum(int... values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    public static long accumLong(int... values) {
        long result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}