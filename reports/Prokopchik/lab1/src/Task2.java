import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    private static double[] subarray(double[] array, int startIndex, int endIndex) {
        double[] subarray = new double[endIndex - startIndex];
        int subarrayIndex = 0;

        for (int arrayIndex = startIndex; arrayIndex < endIndex; arrayIndex++) {
            subarray[subarrayIndex] = array[arrayIndex];
            subarrayIndex++;
        }

        return subarray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите массив: ");
        double[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.print("индекс начала: ");
        int startIndex = scanner.nextInt();

        System.out.print(("индекс конца: "));
        int endIndex = scanner.nextInt();

        double[] subarray = subarray(array, startIndex, endIndex);
        System.out.print(Arrays.toString(subarray));
    }
}
