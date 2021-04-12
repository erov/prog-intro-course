import java.util.*;
import java.lang.*;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        final int mod = 998_244_353;

        int[] deg = new int[n + 1];
        deg[0] = 1;
        for (int i = 1; i <= n; i++) {
            deg[i] = (int) ((long) deg[i - 1] * k % mod);
        }

        int[] r = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                r[i] = (int) ((long) (i / 2) * (deg[i / 2] + deg[i / 2 + 1]) % mod);
            } else {
                r[i] = (int) ((long) i * deg[(i + 1) / 2] % mod);
            }
        }

        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = r[i];
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    if (j < i) {
                        d[i] -= (int) ((long) i / j * d[j] % mod);
                        d[i] += mod;
                        d[i] %= mod;
                    }
                    int l = i / j;
                    if (l != j && l < i) {
                        d[i] -= (int) ((long) i / l * d[l] % mod);
                        d[i] += mod;
                        d[i] %= mod;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    ans += d[j];
                    ans %= mod;
                    int l = i / j;
                    if (l != j) {
                        ans += d[l];
                        ans %= mod;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}