package expression.exceptions;

public class DivideByZeroException extends CalculateException {
    public DivideByZeroException(int value) {
        super(String.format("division by zero: %d / 0", value));
    }
}
