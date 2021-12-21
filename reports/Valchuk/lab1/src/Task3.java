import java.util.Scanner;

public class Task3 {

    private static String shiftRight(String str, int shift) {
        if (str == null) {
            return null;
        }

        int strLength = str.length();

        if (shift < 0) {
            shift = (shift % strLength) + str.length();
        }

        return str.substring(strLength - (shift % strLength)) + str.substring(0, strLength - (shift % strLength));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.print("Shift: ");
        int shift = scanner.nextInt();

        System.out.print(shiftRight(str, shift));
    }
}
