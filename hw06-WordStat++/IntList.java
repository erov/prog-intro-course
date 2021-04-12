import java.util.Arrays;

public class IntList {
	private int[] array;
	private int last;

	public IntList() {
		array = new int[1];
		last = 0;
	}

	public void push_back(int value) {
		if (last == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[last++] = value;
	}

	public int get(int id) {
		return array[id];
	}

	public int back() {
		return array[last - 1];
	}

	public int size() {
		return last;
	}

	public boolean empty() {
		return size() == 0;
	}
}