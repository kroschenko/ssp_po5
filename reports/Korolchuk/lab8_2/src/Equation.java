package hello_java.mavenproject1;

import javafx.concurrent.Task;

public class Equation extends Task<Double> {
    private int n;
    private double x;
    
    public Equation(int n, double x) {
        this.n = n;
        this.x = x;
    }
    
    @Override
    protected Double call() throws Exception {
        updateMessage("    Processing...    ");
        
        double result = countExample(n, x);
        
        updateMessage("    Done.    ");
        
        return result;
    }
    
    public double countExample(int n, double x) throws InterruptedException {
        double value = x;

        for (int k = 1; k <= n; k++) {
            System.out.println("Промежуточное значение: " + value);
            updateMessage("Промежуточное значение: " + value);

            value *= ((x * x) * (2 * k - 1) / (2 * k + 1));
            
            Thread.currentThread().sleep(1);
            
            if (Thread.currentThread() != App.thread) {
                return value;
            }
        }

        return value;
    }
}
