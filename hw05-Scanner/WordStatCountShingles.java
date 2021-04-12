import java.io.*;
import java.util.*;

public class WordStatCountShingles {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> cnt = new LinkedHashMap<String, Integer>();

		try (MyScanner input = new MyScanner(args[0], "UTF-8")) {
			while (!input.empty()) {
				while (input.hasNextWord()) {
					String str = input.nextWord().toLowerCase();
					for (int j = 0; j + 3 <= str.length(); j++) {
						String sub = str.substring(j, j + 3);
						cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
					}
				}
				input.skipLine();
			}
		} catch (SecurityException e) {
			System.out.println("Input file access denied: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println("Input error: " + e.getMessage());
			return;
		}

		List<Map.Entry<String, Integer>> ans = new ArrayList<Map.Entry<String, Integer>>(cnt.entrySet());
		ans.sort(Comparator.comparingInt(Map.Entry::getValue));

		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"))) {

			for (Map.Entry<String, Integer> it : ans) {
				out.write(String.format("%s %d%s", it.getKey(), it.getValue(), System.lineSeparator()));
			}

		} catch (SecurityException e) {
			System.out.println("Output file access denied: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Output error: " + e.getMessage());
		}
	}
}