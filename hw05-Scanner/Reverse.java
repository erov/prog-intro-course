import java.util.Arrays;
import java.io.IOException;

public class Reverse {
	public static void main(String[] args) {
		int[][] array = new int[1][];
		int n = 0, m = 0;

		try (MyScanner input = new MyScanner()) {
			while (!input.empty()) {
				int[] nums = new int[1];
				int j = 0;
				while (input.hasNextInt()) {
					if (j == nums.length) {
						nums = Arrays.copyOf(nums, nums.length * 2);
					}
					nums[j++] = input.nextInt();
				}
				input.skipLine();

				if (m < j) {
					m = j;
				}
				if (n == array.length) {
					array = Arrays.copyOf(array, array.length * 2);
				}
				array[n++] = Arrays.copyOf(nums, j);
			}

		} catch (IOException e) {
			System.out.println("Input error: " + e.getMessage());
			return;
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = array[i].length - 1; j >= 0; j--) {
				System.out.print(String.format("%s ", array[i][j]));
			}
			System.out.print(System.lineSeparator());
		}
	}
}