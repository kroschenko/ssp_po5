package lab;

import javafx.concurrent.Task;

public final class Row extends Task {
    private volatile boolean running;
    private final int n;

    public Row(final int n) {
        this.running = true;
        this.n = n;
    }

    public final void start() {
        this.running = true;
    }

    public final void stop() {
        this.running = false;
    }

    @Override
    protected final Object call() {
        try {
            int previousOdd = 1, nextOdd = previousOdd + 2;
            double result = 0.0;

            for (int i = 0; i < n; ++i) {
                while (!running) {
                }

                result += 1.0 / (previousOdd * nextOdd);
                previousOdd = nextOdd;
                nextOdd += 2;

                updateMessage("Result for n = " + String.valueOf(i + 1) + " : " + String.valueOf(result));
                Thread.sleep(100);
            }
        } catch (final InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
