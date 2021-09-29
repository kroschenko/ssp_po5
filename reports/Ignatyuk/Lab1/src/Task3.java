public class Task3 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args.length > 2) {
            throw new Exception("Invalid Parameters!");
        }

        int lenght = Integer.parseInt(args[0]);
        boolean asciiOnly = true;

        if (args.length == 2) {
            asciiOnly = Boolean.parseBoolean(args[1]);
        }

        System.out.print("Generated result: ");
        System.out.println(randomString(lenght, asciiOnly));
    }

    public static String randomString(int lenght, boolean asciiOnly) {
        char[] result = new char[lenght];

        if (asciiOnly) {
            for (int i = 0; i < lenght; ++i) {
                result[i] = randomCharacter((char) 0, (char) 255);
            }
        } else {
            for (int i = 0; i < lenght; ++i) {
                result[i] = randomCharacter('\u0000', '\uFFFF');
            }
        }

        return new String(result);
    }

    public static char randomCharacter(char begin, char end) {
        return (char) (begin + Math.random() * (end - begin + 1));
    }
}
