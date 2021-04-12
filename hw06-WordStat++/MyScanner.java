import java.io.*;

public class MyScanner implements AutoCloseable {
	private BufferedReader input;
	private int last = -1;

	public MyScanner() throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
	}

	public MyScanner(String file, String encoding) throws IOException, SecurityException {
		input = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
	}

	public void close() throws IOException {
		input.close();
	}

	private interface Checker {
		boolean isSeparator(int c);
	}

	private static boolean isLineSeparator(int c) {
		return c == '\n' || c == '\r';
	}
	private static boolean isIntSeparator(int c) {
		return Character.getType(c) == Character.SPACE_SEPARATOR;
	}
	private static boolean isWordSeparator(int c) {
		return !(Character.isLetter(c) || Character.getType(c) == Character.DASH_PUNCTUATION || c == '\'');
	}

	private boolean hasNextToken(Checker token) throws IOException {
		int c = (last != -1 ? last : input.read());
		while (token.isSeparator(c) && !isLineSeparator(c) && c != -1) {
			c = input.read();
		}
		last = c;
		return !token.isSeparator(last) && !isLineSeparator(c) && c != -1;
	}

	private String nextToken(Checker token) throws IOException {
		StringBuilder result = new StringBuilder();
		result.append((char) last);

		int c = input.read();
		while (!token.isSeparator(c) && !isLineSeparator(c) && c != -1) {
			result.append((char) c);
			c = input.read();
		}
		last = c;
		return result.toString();
	}

	private String convertInt(String value) {
		StringBuilder num = new StringBuilder();
		for (char ch : value.toCharArray()) {
			num.append(('a' <= ch && ch < 'a' + 10) ? (char) (ch - 'a' + '0') : ch);
		}
		return num.toString();
	}

	public boolean empty() throws IOException {
		if (last == -1) {
			last = input.read();
		}
		return last == -1;
	}

	public void skipLine() throws IOException {
		while (!isLineSeparator(last) && last != -1) {
			last = input.read();
		}
		if (isLineSeparator(last)) {
			last = input.read();
		}
		if (isLineSeparator(last)) {
			last = input.read();
		}
	}

	public boolean hasNextInt() throws IOException {
		return hasNextToken(MyScanner::isIntSeparator);
	}

	public int nextInt() throws IOException {
		String value = nextToken(MyScanner::isIntSeparator);
		if (value.length() > 2 && value.charAt(0) == '0' && (value.charAt(1) == 'x' || value.charAt(1) == 'X')) {
			return (int) Integer.parseUnsignedInt(value.substring(2), 16);
		}
		return Integer.parseInt(convertInt(value));
	}

	public boolean hasNextWord() throws IOException {
		return hasNextToken(MyScanner::isWordSeparator);
	}

	public String nextWord() throws IOException {
		return nextToken(MyScanner::isWordSeparator);
	}
}
