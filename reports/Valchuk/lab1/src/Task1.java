public class Task1 {

    public static void main(String[] args) {
        for (int index = 1; index < args.length; index++) {
            if (Integer.parseInt(args[index]) != Integer.parseInt(args[index - 1])) {
                System.out.println("Not equal");
                return;
            }
        }

        if (args.length != 0) {
            System.out.println("Equal");
        }
    }
}
