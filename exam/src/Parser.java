import java.io.FileNotFoundException;
import java.io.IOException;

public class Parser {
    private final FileSource source;

    public Parser(String fileName) throws FileNotFoundException {
        this.source = new FileSource(fileName);
    }

    // :NOTE: * Очень сложно
    public SubstringList parseSubstrings() throws IOException, UnknownStringFormatException {
        StringBuilder sb = new StringBuilder();
        SubstringList result = new SubstringList();
        boolean isIgnoreCase = false;

        while (true) {
            int nxt = source.nextChar();
            if (nxt == (int) '|' || nxt == -1) {
                if (sb.length() > 0) {
                    result.push_back(new Substring(sb.toString(), isIgnoreCase));
                } else {
                    throw new UnknownStringFormatException("string is empty", result.size());
                }
                if (nxt == -1) {
                    break;
                }
                sb.setLength(0);
                isIgnoreCase = false;
            } else {
                sb.append((char) nxt);
                if (sb.length() == 13 && sb.toString().equals("--ignore-case")) {
                    isIgnoreCase = true;
                    sb.setLength(0);
                    nxt = source.nextChar();
                    if (!Character.isWhitespace(nxt)) {
                        String current = nxt == -1 ? "EOF" : Character.toString(nxt);
                        throw new UnknownStringFormatException(String.format("expected whitespace after '--ignore-case' but found '%s'", current), result.size());
                    }
                }
            }
        }

        return result;
    }
}
