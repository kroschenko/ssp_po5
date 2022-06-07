package spp.task2;

public class StringUtils {
    public static String repeat(String str, String separator, int repeat) throws Exception {
        checkArgument(str);
        checkArgument(separator);
        checkArgument(repeat);
        checkArgumentTypeStr(str);
        checkArgumentTypeStr(separator);
        checkArgumentTypeInt(repeat);

        String result = "";

        if(repeat == 0){
            return result;
        }

        if (repeat > 1) {
            for(int i = 0; i < repeat-1; ++i){
                result += str + separator;
            }
            result += str;
        }
        else {
            return str;
        }

        return result;
    }

    private static void checkArgument(String str) throws Exception {
        if (str == null) {
            throw new NullPointerException("must be not null");
        }
    }

    private static void checkArgument(int argument) throws Exception {
        if (argument < 0) {
            throw new IllegalArgumentException("must be positive");
        }
    }

    private static void checkArgumentTypeStr(Object obj) throws Exception {
        if (obj.getClass() != String.class) {
            throw new IllegalArgumentTypeException("must be String");
        }
    }

    private static void checkArgumentTypeInt(Object obj) throws Exception {
        if (obj.getClass() != Integer.class) {
            throw new IllegalArgumentTypeException("must be Integer");
        }
    }
}
