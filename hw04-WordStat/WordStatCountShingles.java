import java.io.*;
import java.util.*;

public class WordStatCountShingles {

	public static boolean checkIsLetter(char c) {
		return Character.isLetter(c) || Character.getType(c) == Character.DASH_PUNCTUATION || c == '\'';
	}

	public static void main(String[] args) {
		Map<String, Integer> cnt = new HashMap<String, Integer>();
		String[] order = new String[1];
		int n = 0;

		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "utf8"))) {
			while (true) {
				int c = in.read();
				StringBuilder current = new StringBuilder();
				while (c >= 0 && checkIsLetter((char) c)) {
					current.append((char) c);
					if (current.length() == 3) {
						String sub = current.toString().toLowerCase();
						Integer val = 1;
						if (cnt.get(sub) != null) {
							val += cnt.get(sub);
						} else {
							if (n == order.length) {
								order = Arrays.copyOf(order, order.length * 2);
							}
							order[n++] = sub;
						}
						current.deleteCharAt(0);
						cnt.put(sub, val);
					}
					c = in.read();
				}
				if (c < 0) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Input file does not exist: " + e.getMessage());
			return;
		} catch (SecurityException e) {
			System.out.println("Input file access denied: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println("Input error: " + e.getMessage());
			return;
		}

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = cnt.get(order[i]);
		}

		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);

		Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
		if (n > 0) {
			pos.put(nums[0], 0);
		}
		for (int i = 1; i < n; i++) {
			if (nums[i] != nums[i - 1]) {
				pos.put(nums[i], i);
			}
		}

		String[] ans = new String[n];
		for (int i = 0; i < n; i++) {
			int its = numsCopy[i];
			int j = pos.get(its);
			ans[j++] = order[i];
			pos.put(its, j);
		}

		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "utf8"))) {

			for (int i = 0; i < n; i++) {
				out.write(String.format("%s %d\n", ans[i], nums[i]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Output file does not exist: " + e.getMessage());
			return;
		} catch (SecurityException e) {
			System.out.println("Output file access denied: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Output error: " + e.getMessage());
		}
	}
}