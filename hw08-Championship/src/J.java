import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.nextLine();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[n];
            str = in.nextLine();
            char[] b = str.toCharArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) b[j] - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(0);
            }
            for (int j = i + 1; j < n; j++) {
                int val = a[i][j];
                if (a[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        a[i][k] = (a[i][k] - a[j][k] + 10) % 10;
                    }
                }
                System.out.print(val);
            }
            System.out.println();
        }

    }
}