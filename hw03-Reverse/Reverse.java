import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] lines = new String[1_000_000];
		int n = 0;
		while (input.hasNextLine()) {
			lines[n++] = input.nextLine();
		}
		String[] separated = new String[1_000_000];
		String current = "";
		for (int i = n - 1; i >= 0; i--) {
			if (!lines[i].equals("")) {
				lines[i] = lines[i] + " ";
				int pos = 0;
				for (int j = 0; j < lines[i].length(); j++) {
					char c = lines[i].charAt(j);
					if (!Character.isWhitespace(c)) {
						current = current + c;
					} else {
						if (!current.equals("")) {
							separated[pos++] = current;
							current = "";
						}
					}
				}
				for (pos = pos - 1; pos >= 0; pos--) {
					System.out.print(separated[pos] + ' ');
				}
			}
			System.out.println();
		}
	}
}