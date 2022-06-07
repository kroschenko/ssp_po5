package spp.task2;

public class IllegalArgumentTypeException extends Exception {
    public IllegalArgumentTypeException(String errorMessage) {
        super("IllegalArgumentTypeException: " + errorMessage);
    }

    public IllegalArgumentTypeException() {
        super("IllegalArgumentTypeException: ");
    }
}