import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    private static double[] subArray(double[] array, int startIndex, int endIndex) {
        double[] subArray = new double[endIndex - startIndex];
        int subArrayIndex = 0;

        for (int arrayIndex = startIndex; arrayIndex < endIndex; arrayIndex++) {
            subArray[subArrayIndex] = array[arrayIndex];
            subArrayIndex++;
        }

        return subArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an array of doubles: ");
        double[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.print("Start index: ");
        int startIndex = scanner.nextInt();

        System.out.print(("End index: "));
        int endIndex = scanner.nextInt();

        double[] subArray = subArray(array, startIndex, endIndex);
        System.out.print(Arrays.toString(subArray));
    }
}
