import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int ans = ((n - a - 1) / (b - a)) * 2 + 1;
        System.out.print(ans);
    }
}