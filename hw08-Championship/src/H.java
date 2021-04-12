import java.util.*;

public class H {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }

        int[] block = new int[sum];
        int[] pref = new int[n];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            pref[i] = (i != 0 ? pref[i - 1] : 0) + a[i];
            for (int j = 0; j < a[i]; j++) {
                block[pos++] = i;
            }
        }

        int q = in.nextInt();
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            if (!ans.containsKey(x)) {
                int cnt = 0;
                pos = 0;
                while (pos < sum) {
                    int to = pos + x;
                    cnt++;
                    if (to >= sum) {
                        break;
                    }
                    if (block[pos] == block[to]) {
                        cnt = -1;
                        break;
                    }
                    if (block[to] == block[to - 1]) {
                        pos = pref[block[to] - 1];
                    } else {
                        pos = pref[block[to - 1]];
                    }
                }
                ans.put(x, cnt);
            }
            int cnt = ans.get(x);
            if (cnt == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(cnt);
            }
        }
    }
}