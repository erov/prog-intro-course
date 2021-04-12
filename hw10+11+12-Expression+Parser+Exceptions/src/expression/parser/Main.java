package expression.parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression;
        expression = in.nextLine();
        System.out.println((new ExpressionParser().parse(expression)).evaluate(0, 0, 0));
    }
}
