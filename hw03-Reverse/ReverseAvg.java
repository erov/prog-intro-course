import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;

public class ReverseAvg {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] array = new int[1][];
		int n = 0, m = 0;

		while (input.hasNextLine()) {
			Scanner line = new Scanner(input.nextLine());
			int[] nums = new int[1];
			int j = 0;
			while (line.hasNextInt()) {
				if (j == nums.length) {
					nums = Arrays.copyOf(nums, nums.length * 2);
				}
				nums[j++] = line.nextInt();
			}
			
			if (m < j) {
				m = j;
			}
			if (n == array.length) {
				array = Arrays.copyOf(array, array.length * 2);
			}
			array[n++] = Arrays.copyOf(nums, j);
		}

		long[] sumCol = new long[m];
		int[] cntCol = new int[m];
		long[] sumRow = new long[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sumRow[i] += array[i][j];
				sumCol[j] += array[i][j];
				cntCol[j]++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < array[i].length; j++) {
				long ans = (sumRow[i] + sumCol[j] - array[i][j]) / (array[i].length + cntCol[j] - 1);
				System.out.print(ans + " ");
			}
			System.out.println();
		}
	}
}