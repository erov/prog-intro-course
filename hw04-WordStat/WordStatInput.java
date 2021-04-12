import java.io.*;
import java.util.*;

public class WordStatInput {
	public static void main(String[] args) {
		String input = null;
		try {
			Reader in = new InputStreamReader(new FileInputStream(args[0]), "utf8");
			try {
				StringBuilder string = new StringBuilder();
				char[] buffer = new char[1024];
				while (true) {
					int read = in.read(buffer);
					if (read < 0) {
						break;
					}
					string.append(new String(buffer, 0, read));
				}
				input = string.toString();
			} finally {
				in.close();
			}
		} catch (IOException e) {
			System.out.println("Input error: " + e.getMessage());
		}

		LinkedHashMap<String, Integer> cnt = new LinkedHashMap<String, Integer>();
		StringBuilder current = new StringBuilder();
		String[] order = new String[1];
		int n = 0, sz = 1;

		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			if (Character.isLetter(c) || Character.getType(c) == Character.DASH_PUNCTUATION || c == '\'') {
				current.append(c);
			} else {
				String converted = current.toString().toLowerCase();
				if (!converted.equals("")) {
					Integer val = 1;
					if (cnt.get(converted) != null) {
						val += cnt.get(converted);
					} else {
						if (n == sz) {
							String[] newOrder = new String[sz * 2];
							System.arraycopy(order, 0, newOrder, 0, sz);
							sz *= 2;
							order = newOrder;
						}
						order[n++] = converted;
					}
					cnt.put(converted, val);
				}
				current = new StringBuilder();
			}
		}

		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(args[1]), "utf8");
			try {
				for (int i = 0; i < n; i++) {
					out.write(order[i] + " " + cnt.get(order[i]) + "\n");
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			System.out.println("Output error: " + e.getMessage());
		}
	}
}