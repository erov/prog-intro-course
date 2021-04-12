public class Sum {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			String currentNumber = "";
			int number;
			for (int j = 0; j < args[i].length(); j++) {
				char c = args[i].charAt(j);
				if (('0' <= c && c <= '9') || c == '+' || c == '-') {
					currentNumber += c;
				} else {
					if (currentNumber != "") {
						number = Integer.parseInt(currentNumber);
						sum += number;
						currentNumber = "";
					}
				}
			}
			if (currentNumber != "") {
				number = Integer.parseInt(currentNumber);
				sum += number;
			}
		}
		System.out.println(sum);
	}
}