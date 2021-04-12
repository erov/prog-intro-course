package expression.exceptions;

public class InvalidConstException extends ParseException {
    public InvalidConstException(String value, String type, int position) {
        super(String.format("found invalid %s constant \"%s\"", type, value), position);
    }
}
