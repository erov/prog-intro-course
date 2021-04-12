import java.util.HashMap;
import java.util.Map;

public class Node {
    Map<Character, Integer> next;
    int stringId;

    public Node() {
        next = new HashMap<>();
        stringId = -1;
    }
}