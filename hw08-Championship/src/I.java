import java.util.Scanner;
import static java.lang.Math.*;

public class I {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int inf = 1_000_000_000;
        int xLeft = inf, xRight = -inf, yDown = inf, yUp = -inf;

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x, y, h;
            x = in.nextInt();
            y = in.nextInt();
            h = in.nextInt();
            xLeft = min(xLeft, x - h);
            xRight = max(xRight, x + h);
            yDown = min(yDown, y - h);
            yUp = max(yUp, y + h);
        }

        int h = max(xRight - xLeft, yUp - yDown);
        h = (h + 1) / 2;
        int x = (xLeft + xRight) / 2, y = (yDown + yUp) / 2;
        System.out.print(String.format("%d %d %d", x, y, h));
    }
}