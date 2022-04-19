public class task2 {
    public static String loose(String str, String remove) {
        if (remove == null && str == null)
            throw new NullPointerException();
        else if (remove == null)
            return str;
        if (str == null)
            return null;
        String result = "";
        for (Character c : str.toCharArray()) {
            if (!remove.contains(c.toString()))
                result = result.concat(c.toString());
        }
        return result;
    }
}
