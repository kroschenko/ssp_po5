package task3;

public class StringUtils {

    public String repeat(String pattern, int repeat) {
        if (repeat < 0) {
            throw new IllegalArgumentException("Positive parameter expected.");
        }
        if (pattern == null) {
            throw new NullPointerException("Non-nullable pattern expected.");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < repeat; ++i) {
            builder.append(pattern);
        }
        return builder.toString();
    }
}

