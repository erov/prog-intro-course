import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        // double ost = 10;
        // int val = 0;
        // int to = (1 << 31) - 1;
        // for (int i = 1; i < to / 50000; i++) {
        // 	double current = i / (2.0 * Math.acos(-1));
        // 	current = current % 1;
        // 	if (current < ost) {
        // 		ost = current;
        // 		val = i;
        // 	}
        // }
        // val = 710

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = 710 * (i - 25_000);
            System.out.println(x);
        }
    }
}