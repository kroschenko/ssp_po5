import java.util.Random;

public class SSP_lab_1 {

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double single(int size) {
        int[][] mass = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) mass[i][j] = 1;
                else mass[i][j] = 0;
                System.out.print(mass[i][j] + "  ");
            }
            System.out.print('\n');
        }
        return size;  
    }

    public static String capitalize(String str) {
        String result_str = null;
        for (int i = 0; i < str.length(); i++) {
            if((str.charAt(0) > 'a') && (str.charAt(0) < 'z')) {
                String s1 = str.substring(0, 1).toUpperCase();
                result_str = s1 + str.substring(1);
            }
            else result_str = str;
        }
        return result_str;
    }

    public static void task_1 (String[] args) {
        double sum = 0;
        int count = 0, maxsize;
        System.out.println("Enter maxsize numbers");
        maxsize = Integer.parseInt(arr[0]);
        int[] mass = new int[maxsize];
        System.out.println("Enter numbers");
        for (int i = 0; i < maxsize; i++) {
            mass[i] = generateRandomIntIntRange(1, 100);
            sum += mass[i];
            System.out.println("Numbers: " + mass[i]);
        }
        double middle = sum/maxsize;
        for (int i = 0; i < maxsize; i++) {
            if(mass[i] > middle) count++;
        }
        double result = count*100/maxsize;
        System.out.println("Sum numbers = " + sum);
        System.out.println("Middle = " + middle);
        System.out.println("Procet = " + result);
    }

    public static void task_2 (String[] args) {
        int size = 0;
        System.out.println("Enter size matrix");
        size = Integer.parseInt(arr[0]);
        single(size);
    }

    public static void task_3 (String[] args) {
        System.out.println(capitalize(arr[0]));
    }

    public static void main(String[] args) {
		String [] arr = new String[3];
        int count = 0;
        for(String s : args) {
            arr[count] = s;
            count++;
        }
        task_1(arr[0]);
        task_2(arr[1]);
        task_3(arr[2]);
    }
}