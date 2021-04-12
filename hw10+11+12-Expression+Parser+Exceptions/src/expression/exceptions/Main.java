package expression.exceptions;

import expression.TripleExpression;

public class Main {
    public static void main(String[] args) {
        String expression = "1000000*x*x*x*x*x/(x-1)";
        TripleExpression result;
        try {
            result = new ExpressionParser().parse(expression);
        } catch (ParseException e) {
            System.out.println("Parse error: " + e.getMessage());
            return;
        }

        System.out.println(" x       f");
        for (int x = 0; x <= 10; x++) {
            int value;
            try {
                value = result.evaluate(x, 0, 0);
                System.out.printf("%2d       %d%n", x, value);
            } catch (CalculateException e) {
                System.out.printf("%2d       %s%n", x, e.getMessage());
            }
        }
    }
}
