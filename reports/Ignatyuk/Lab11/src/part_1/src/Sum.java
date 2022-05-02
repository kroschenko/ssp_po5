public final class Sum {
    public final static long accum(final int... values) {
        long result = 0;

        for (int i = 0; i < values.length; ++i) {
            result += values[i];
        }

        return result;
    }
}
