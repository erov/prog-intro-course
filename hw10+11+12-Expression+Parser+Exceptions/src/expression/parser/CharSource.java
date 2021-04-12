package expression.parser;

public interface CharSource {
    boolean hasNext();
    boolean hasNext(int delta);
    char next();
    char next(int delta);
    ParseException error(final String message);
}
