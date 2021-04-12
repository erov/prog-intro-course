import java.io.*;
import java.util.*;

public class WordStatCountFirstIndex {
	public static void main(String[] args) {
		LinkedHashMap<String, Element> cnt = new LinkedHashMap<String, Element>();

		try (MyScanner input = new MyScanner(args[0], "UTF-8")) {
			int lineId = 0;
			while (!input.empty()) {
				lineId++;
				int id = 1;
				while (input.hasNextWord()) {
					String str = input.nextWord().toLowerCase();
					if (!cnt.containsKey(str)) {
						cnt.put(str, new Element(id, lineId));
					} else {
						cnt.put(str, cnt.get(str).update(id, lineId));
					}
					id++;
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

		List<Map.Entry<String, Element>> ans = new ArrayList<Map.Entry<String, Element>>(cnt.entrySet());
		ans.sort(Comparator.comparing(Map.Entry::getValue));

		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"))) {

			for (Map.Entry<String, Element> it : ans) {
				out.write(String.format("%s %s%s", it.getKey(), it.getValue(), System.lineSeparator()));
			}

		} catch (SecurityException e) {
			System.out.println("Output file access denied: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Output error: " + e.getMessage());
		}
	}
}