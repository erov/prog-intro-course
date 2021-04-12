import java.util.*;

public class E {

    static class intList {
        private int[] n;
        private int[][] arr;

        public intList(int sz) {
            n = new int[sz];
            arr = new int[sz][1];
            for (int i = 0; i < sz; i++) {
                n[i] = 0;
            }
        }

        public void push_back(int id, int x) {
            if (arr[id].length == n[id]) {
                arr[id] = Arrays.copyOf(arr[id], arr[id].length * 2);
            }
            arr[id][n[id]++] = x;
        }

        public int get(int id, int pos) {
            return arr[id][pos];
        }

        public int size(int id) {
            return n[id];
        }
    }

    static class intQueue {
        private int head, tail;
        private int[] arr;

        public intQueue() {
            head = tail = 0;
            arr = new int[1];
        }

        public void add(int x) {
            if (arr.length == tail) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[tail++] = x;
        }

        public int get() {
            return arr[head++];
        }

        public boolean empty() {
            return head == tail;
        }
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        intList g = new intList(n);
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt(), y = in.nextInt();
            x--;
            y--;
            g.push_back(x, y);
            g.push_back(y, x);
        }
        intQueue q = new intQueue();
        int[] dist = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = -1;
            cnt[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int c = in.nextInt();
            c--;
            q.add(c);
            dist[c] = 0;
            cnt[c]++;
        }

        while (!q.empty()) {
            int v = q.get();
            for (int i = 0; i < g.size(v); i++) {
                int u = g.get(v, i);
                if (dist[u] == -1) {
                    cnt[u] += cnt[v];
                    dist[u] = dist[v] + 1;
                    q.add(u);
                } else {
                    if (dist[u] == dist[v] + 1) {
                        cnt[u] += cnt[v];
                    } else if (dist[u] != dist[v] - 1) {
                        System.out.print("NO");
                        return;
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == m) {
                ans = i;
            }
        }
        if (ans == -1) {
            System.out.print("NO");
        } else {
            System.out.print(String.format("YES%n%d", ans + 1));
        }
    }
}