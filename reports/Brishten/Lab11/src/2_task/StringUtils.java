package com.company.two_task;

public final class StringUtils {
    public static String keep(String str, String pattern) {
        if (str == null && pattern == null) {
            throw new NullPointerException();
        }
        if (str == null) {
            return null;
        }
        if (pattern == null) {
            return "";
        }
        if (str.equals("") || pattern.equals("")) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (pattern.indexOf(ch) == -1) {
                continue;
            }
            result.append(ch);
        }
        return result.toString();
    }
}


