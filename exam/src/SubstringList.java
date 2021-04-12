import java.util.Arrays;

public class SubstringList {
    private Substring[] array;
    private int last;

    public SubstringList() {
        array = new Substring[1];
        last = 0;
    }

    public void push_back(Substring value) {
        if (last == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[last++] = value;
    }

    public Substring get(int id) {
        return array[id];
    }

    public int size() {
        return last;
    }
}
