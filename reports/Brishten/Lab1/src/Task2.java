import java.util.Scanner;

public class Task2 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter range (min-max): ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        System.out.print("Enter size matrix: ");
        int size = in.nextInt();
        double [][]result = createMatrix(a, b, size);
        System.out.println("Output matrix");
        for (double[] ds : result) {
            for (double ds2 : ds) {
                System.out.printf("%.2f ", ds2);
            }
            System.out.println();
        }
        in.close();
    }  

    static double[][] createMatrix(double a, double b, int size){
        double [][]matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (double) ((Math.random() * (b - a)) + a);
            }    
        }
        return matrix;
    }
}

