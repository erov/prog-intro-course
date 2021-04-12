import java.math.BigInteger;
import java.lang.Character;

public class SumBigIntegerSpace {
	public static void main(String[] args) {
		BigInteger sum = BigInteger.valueOf(0), number;
		String currentNumber = "";
		for (int i = 0; i < args.length; i++) {
			args[i] = args[i] + " ";
			for (int j = 0; j < args[i].length(); j++) {
				char c = args[i].charAt(j);
				if (Character.getType(c) == Character.SPACE_SEPARATOR) {
					if (currentNumber != "") {
						sum = sum.add(new BigInteger(currentNumber));
						currentNumber = "";
					}
				} else {
					currentNumber += c;
				}
			}
		}
		System.out.println(sum);
	}
}