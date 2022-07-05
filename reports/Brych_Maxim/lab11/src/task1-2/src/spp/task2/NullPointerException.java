package spp.task2;

public class NullPointerException extends Exception {
    public NullPointerException(String errorMessage) {
        super("NullPointerException: " + errorMessage);
    }

    public NullPointerException() {
        super("NullPointerException: ");
    }
}
