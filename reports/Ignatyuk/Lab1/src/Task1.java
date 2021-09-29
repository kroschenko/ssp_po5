public class Task1 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Parameters not passed!");
        }

        int[] numbers = new int[args.length];

        numbers[0] = Integer.parseInt(args[0]);
        int min = numbers[0], max = numbers[0];

        for (int i = 1, size = args.length; i < size; ++i) {
            numbers[i] = Integer.parseInt(args[i]);

            if (min > numbers[i]) {
                min = numbers[i];
            }

            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        System.out.print("Range of consistency: ");
        System.out.println(max - min);
    }
}
