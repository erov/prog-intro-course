import java.util.*;
import java.lang.*;

public class M {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int p = 0; p < t; p++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            Map<Integer, Integer> cnt = new HashMap<>();
            int ans = 0;
            for (int j = n - 1; j >= 1; j--) {
                for (int i = 0; i < j; i++) {
                    ans += cnt.getOrDefault(2 * a[j] - a[i], 0);
                }
                cnt.put(a[j], cnt.getOrDefault(a[j], 0) + 1);
            }
            System.out.println(ans);
        }
    }
}