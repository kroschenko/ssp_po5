import java.util.Random;

public class Lab1 {
    
    public static void main(String[] args) {
        Task1();
        Task2(Integer.parseInt(args[0]));
        Task3(args[1]);
    }

    public static void Task1() {
        System.out.println("\nЗадание №1:");
        int val = 20, min = 1, max = 20, trend = 0, max_count = 0;
        int[] row = new int[val];
        Random rand = new Random();

        System.out.println("Последовательность:");
        for(int i = 0; i < val; i++) { // создание ряда
            new Random();
            row[i] = rand.nextInt(max - min + 1);
            System.out.print(row[i] + " ");
        }
        for(int i = 0; i < val; i++) { 
            int count = 0;
            for(int y = i; y < val; y++) if (row[i] == row[y]) count++;
            if (count > max_count) {
                max_count = count;
                trend = row[i];
            } else if(count == max_count) trend = 0;
        }
        if (trend != 0)
            System.out.printf("\n moda - %d, count - %d \n", trend, max_count);
        else 
            System.out.println("\n no moda \n");
    }

    public static void Task2(int step) {
        System.out.println("\nЗадание №2:");
        int val = 20, min = 100, max = 2000;
        Double [] array = new Double[20];
        Random rand = new Random();

        System.out.println("Последовательность:");
        for(int i = 0; i < val; i++) { // создание ряда
            new Random();
            array[i] = Double.valueOf(rand.nextInt((max - min + 1)) / 10);
            System.out.print(array[i] + " ");
        }

        
        System.out.print("\nКоличество позиций сдвига: " + step);
        shiftRight(array, step % 20);
        System.out.println();
        for(int i = 0; i < val; i++) { 
            System.out.print(array[i] + " ");
        }
    }

    public static void shiftRight(Double[] array, int shift) {
        Double temp = 0d;
        for(int iter = 0; iter < shift; iter++)
            for(int i = 20 - 1; i > 0; i--) {
                temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            }
    }

    public static void Task3(String str) {
        System.out.println("\nЗадание №3:");
        System.out.println("\nСтрока: " + str);
        if(pangramEng(str))
            System.out.println("Строка является панграммой!");
        else
            System.out.println("Строка не является панграммой!");
    }

    public static boolean pangramEng(String str) {
        int count = 0;
        for(char i = 'а'; i <= 'я'; i++) 
            if(str.contains(String.valueOf(i))) 
                count++;
        if(count > 26) return true;
        else return false;
    }
}