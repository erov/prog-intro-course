public class UnknownStringFormatException extends Exception {
    public UnknownStringFormatException(String message, int position) {
        super(String.format("error in substring %d: %s", position, message));
    }
}
