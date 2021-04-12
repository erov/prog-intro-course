import java.util.Arrays;

public class Trie {
    private Node[] nodes;
    private int free;

    public Trie() {
        nodes =  new Node[2];
        free = 1;
        nodes[0] = new Node();
    }

    public void addString(final String str, final int id) {
        int current = 0;
        for (char ch : str.toCharArray()) {
            if (!nodes[current].next.containsKey(ch)) {
                nodes[current].next.put(ch, free);
                if (free == nodes.length) {
                    nodes = Arrays.copyOf(nodes, nodes.length * 2);
                }
                nodes[free++] = new Node();
            }
            current = nodes[current].next.get(ch);
        }
        nodes[current].stringId = id;
    }

    public int go(int position, char to) {
        return nodes[position].next.getOrDefault(to, -1);
    }

    public int getId(int position) {
        return nodes[position].stringId;
    }

    // Debug:
    public void print() {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                continue;
            }
            System.out.println(i + " " + nodes[i].stringId);
            for (var it : nodes[i].next.entrySet()) {
                System.out.println(it.getKey() + " " + it.getValue());
            }
            System.out.println("=====");
        }
    }
}
