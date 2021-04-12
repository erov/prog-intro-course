package expression.exceptions;

public class UnsupportedCalculateTypeException extends CalculateException {
    public UnsupportedCalculateTypeException(String type) {
        super(String.format("operations with %s are forbidden for this task", type));
    }
}
