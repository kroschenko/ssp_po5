import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Parameters not passed!");
        }

        long[] numbers = new long[args.length];

        for (int i = 0, size = args.length; i < size; ++i) {
            numbers[i] = Long.parseLong(args[i]);
        }

        System.out.print("Enter the number to delete: ");

        Scanner scan = new Scanner(System.in);
        long numberToDelete = scan.nextLong();
        scan.close();

        long[] processedNumbers = removeElement(numbers, numberToDelete);

        System.out.print("Raw array: ");
        printArray(numbers);

        System.out.print("\nProcessed array: ");
        printArray(processedNumbers);
    }

    public static long[] removeElement(long[] array, long element) {
        int found = 0;

        for (int i = 0, size = array.length; i < size; ++i) {
            if (array[i] == element) {
                ++found;
            }
        }

        if (found == 0) {
            return array;
        }

        long[] result = new long[array.length - found];

        for (int i = 0, j = 0, size = array.length; i < size; ++i) {
            if (array[i] != element) {
                result[j++] = array[i];
            }
        }

        return result;
    }

    public static void printArray(long[] array) {
        for (long current : array) {
            System.out.print(current);
            System.out.print(' ');
        }
    }
}
