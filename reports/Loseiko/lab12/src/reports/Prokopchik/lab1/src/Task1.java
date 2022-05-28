public class Task1 {

    public static void main(String[] args) {
        for(int i = Integer.parseInt(args[0]); i <= Integer.parseInt(args[1]); i += Integer.parseInt(args[2])) {
            System.out.println(i);
        }
    }
}
