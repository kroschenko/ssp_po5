
    import java.util.Scanner;

    public class Task3 {

        private static String shiftRight(String str, int shift) {
            if (str == null) {
                return null;
            }

            if (shift < 0) {
                shift += str.length();
            }

            int strLength = str.length();
            return str.substring(strLength - shift) + str.substring(0, strLength - shift);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите строку: ");
            String str = scanner.nextLine();

            System.out.print("Сдвиг: ");
            int shift = scanner.nextInt();

            System.out.print(shiftRight(str, shift));
        }
    }
