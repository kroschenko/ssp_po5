public class InvalidExpressionException extends Exception {
    public InvalidExpressionException() {
        super("Math expression exception.");
    }
    public InvalidExpressionException(String message) {
        super(message);
    }
}