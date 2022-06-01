package com.company;

public final class StringUtils {
    public static String repeat(String str, int repeatCount) {
        if (str == null) {
            throw new NullPointerException();
        }

        if (repeatCount < 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder(str.length() * repeatCount);

        for (int i = 0; i < repeatCount; i++) {
            result.append(str);
        }

        return result.toString();
    }
}
