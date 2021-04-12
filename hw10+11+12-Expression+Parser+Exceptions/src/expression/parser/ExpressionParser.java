package expression.parser;

import expression.*;

import java.util.Map;

public class ExpressionParser extends BaseParser implements Parser {
    private static final Map<String, Priorities> PRIORITIES = Map.of(
            "|", Priorities.OR,
            "^", Priorities.XOR,
            "&", Priorities.AND,
            "+", Priorities.ADD,
            "-", Priorities.ADD,
            "*", Priorities.MUL,
            "/", Priorities.MUL
    );

    @Override
    public AbstractExpression parse(String expression) {
        makeSourse(expression);
        return parse(Priorities.first());
    }

    private AbstractExpression parse(Priorities priority) {
        if (priority.equals(Priorities.last())) {
            return parseHighestPriority();
        }

        AbstractExpression left = parse(priority.next());

        while (checkBinaryOperator(priority)) {
            String operator = getOperator();
            AbstractExpression right = parse(priority.next());
            left = makeExpression(left, right, operator);
        }
        return left;
    }

    private AbstractExpression parseHighestPriority() {
        AbstractExpression expression;
        skipWhitespace();
        if (test('(')) {
            expression = parse(Priorities.first());
            expect(')');
        } else if (isDigit()) {
            expression = parseConst("");
        } else if (test('-')) {
            skipWhitespace();
            expression = isDigit() ? parseConst("-") : new Negate(parseHighestPriority());
        } else if (test("flip")) {
            expression = new Flip(parseHighestPriority());
        } else if (test("low")) {
            expression = new Low(parseHighestPriority());
        } else {
            expression = parseVariable();
        }
        skipWhitespace();
        return expression;
    }

    private AbstractExpression parseVariable() {
        StringBuilder current = new StringBuilder();
        while (isLetter() && ch != END) {
            current.append(ch);
            expect(ch);
        }
        return new Variable(current.toString());
    }

    private Const parseConst(String sign) {
        StringBuilder current = new StringBuilder();
        current.append(sign);
        while (isDigit()) {
            current.append(ch);
            expect(ch);
        }
        return new Const(Integer.parseInt(current.toString()));
    }

    private boolean checkBinaryOperator(Priorities priority) {
        Priorities value = PRIORITIES.get(String.valueOf(ch));
        return value != null && value.equals(priority);
    }

    private String getOperator() {
        String operator = "";
        if (ch != END) {
            if (PRIORITIES.containsKey(String.valueOf(ch))) {
                operator = String.valueOf(ch);
                expect(operator);
            }
        }
        return operator;
    }

    private AbstractExpression makeExpression(AbstractExpression left, AbstractExpression right, String operator) {
        switch (operator) {
            case "|":
                return new Or(left, right);
            case "^":
                return new Xor(left, right);
            case "&":
                return new And(left, right);
            case "+":
                return new Add(left, right);
            case "-":
                return new Subtract(left, right);
            case "*":
                return new Multiply(left, right);
            case "/":
                return new Divide(left, right);
        }
        throw new UnsupportedOperationException("Wrong operation");
    }
}
