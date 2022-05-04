package spp.task2;

public class IllegalArgumentException extends Exception {
    public IllegalArgumentException(String errorMessage) {
        super("IllegalArgumentException: " + errorMessage);
    }

    public IllegalArgumentException() {
        super("IllegalArgumentException: ");
    }
}