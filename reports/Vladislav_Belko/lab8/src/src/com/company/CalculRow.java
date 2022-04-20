package com.company;
import javafx.concurrent.Task;
public class CalculRow extends Task {
    private int randNum;
    public volatile boolean stopping;
    CalculRow(int randNum) {
        this.randNum = randNum;
    }
    @Override
    protected Object call() {
        try {
            int n;
// Для 2 варианта - коф. в рекуррентной формуле после упрощений имеет вид -1/n
// Первый (при n = 0) член ряда равен 1, значит идем от n=1 и далее
            double current = 0, previous = 1, sum = previous;
            for (n = 1; n <= randNum; n++) {
                while (stopping) { }
                current = previous * (- 1 / (double)n);
                previous = current;
                sum += current;
                updateMessage("Position: " + n + " sum: " + sum);
                Thread.sleep(10);
            }
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}