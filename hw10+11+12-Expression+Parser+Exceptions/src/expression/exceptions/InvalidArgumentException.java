package expression.exceptions;

public class InvalidArgumentException extends CalculateException {
    public InvalidArgumentException(String message, int argument) {
        super(String.format("%s: %d", message, argument));
    }
}
