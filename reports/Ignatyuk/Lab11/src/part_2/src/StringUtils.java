public final class StringUtils {
    public final static int indexOfDifference(final String str1, final String str2) throws NullPointerException {
        if (str1 == null || str2 == null) {
            throw new NullPointerException();
        }

        if (str1.equals("") && str2.equals("")) {
            return -1;
        }

        int i = 0;

        for (; i < str1.length() && i < str2.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }

        return i;
    }
}
