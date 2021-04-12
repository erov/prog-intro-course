package expression.parser;

public class BaseParser {
    public static final char END = '\0';
    private CharSource source;
    protected char ch = 0xffff;

    protected void makeSourse(String expression) {
        source = new StringSource(expression);
        nextChar();
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : END;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean test(String expected) {
        int len = expected.length();
        for (int i = 0; i < len; i++) {
            if (source.hasNext(i) && source.next(i) == expected.charAt(i) == false) {
                return false;
            }
        }
        if (source.hasNext(len) && Character.isLetter(source.next(len))) {
            return false;
        }
        expect(expected);
        return true;
    }

    protected void expect(final char c) {
        if (ch != c) {
            throw error("Expected '" + c + "', found '" + ch + "'");
        }
        nextChar();
    }

    protected void expect(final String value) {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected boolean eof() {
        return test(END);
    }

    protected ParseException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

    protected void skipWhitespace() {
        while (Character.isWhitespace(ch)) {
            nextChar();
        }
    }

    protected boolean isDigit() {
        return between('0', '9');
    }

    protected boolean isLetter() {
        return Character.isLetter(ch);
    }

}
