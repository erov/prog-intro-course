package expression.exceptions;

public class CheckedMath {
    public static int add(int a, int b) {
        if (b > 0 && a > Integer.MAX_VALUE - b || b < 0 && a < Integer.MIN_VALUE - b) {
            throw new OverflowException("summation overflow", a, b, "+");
        }
        return a + b;
    }

    public static int subtract(int a, int b) {
        if (b < 0 && a > Integer.MAX_VALUE + b || b > 0 && a < Integer.MIN_VALUE + b) {
            throw new OverflowException("subtraction overflow", a, b, "-");
        }
        return a - b;
    }

    public static int multiply(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (b > 0 && (a > Integer.MAX_VALUE / b || a < Integer.MIN_VALUE / b) || b < 0 && (a < Integer.MIN_VALUE / -b || a < Integer.MAX_VALUE / b)) {
            throw new OverflowException("multiplication overflow", a, b, "*");
        }
        return a * b;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException("division overflow", a, b, "/");
        }
        if (b == 0) {
            throw new DivideByZeroException(a);
        }
        return a / b;
    }

    public static int negate(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("negation overflow", a, "-");
        }
        return -a;
    }

    public static int abs(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("abs overflow", a, "abs");
        }
        return a > 0 ? a : -a;
    }

    public static int sqrt(int a) {
        if (a < 0) {
            throw new InvalidArgumentException("operation sqrt is undefined for negative numbers", a);
        }
        int l = 0, r = 46341;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (m * m <= a) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static int gcd(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            throw new OverflowException("gcd overflow", a, b, "gcd");
        }
        while (b != 0) {
            a %= b;
            int tmp = a;
            a = b;
            b = tmp;
        }
        return a > 0 ? a : -a;
    }

    public static int lcm(int a, int b) {
        int copyA = a, copyB = b;
        if (!(a == Integer.MIN_VALUE && b == Integer.MIN_VALUE)) {
            int gcd = gcd(a, b);
            if (!(b == Integer.MIN_VALUE && gcd == -1)) {
                if (gcd != 0) {
                    b /= gcd;
                }
                try {
                    a = multiply(a, b);
                    return a;
                } catch (OverflowException e) {
                    throw new OverflowException("lcm overflow", copyA, copyB, "lcm");
                }
            }
        }
        throw new OverflowException("lcm overflow", copyA, copyB, "lcm");
    }
}
