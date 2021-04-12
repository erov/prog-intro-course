package expression.exceptions;

import expression.*;

import java.util.Map;

public class ExpressionParser extends BaseParser implements Parser {
    private static final Map<String, Priorities> UNARY_OPERATIONS = Map.of(
            "-", Priorities.NEGATE,
            "abs", Priorities.NEGATE,
            "sqrt", Priorities.NEGATE
    );
    private static final Map<String, Priorities> BINARY_OPERATIONS = Map.of(
            "+", Priorities.ADD,
            "-", Priorities.ADD,
            "*", Priorities.MUL,
            "/", Priorities.MUL,
            "gcd", Priorities.GCD,
            "lcm", Priorities.GCD
    );
    private enum Arguments {
        FIRST, SECOND;
        public String get(Operations op) {
            return op == Operations.UNARY ? "" : this == FIRST ? "first " : "second ";
        }
    }
    private enum Operations {
        UNARY, BINARY;
        public String get() {
            return this == UNARY ? "unary" : "binary";
        }
    }

    @Override
    public AbstractExpression parse(String expression) throws ParseException {
        makeSourse(expression);
        AbstractExpression result = parse(Priorities.first(), Arguments.FIRST);
        if (ch != END) {
            if (ch == ')') {
                throw new MissingBracketsException("missing opening bracket for closing bracket", getPosition());
            }
            throw new MissingOparationException(getPosition());

        }
        return result;
    }

    private AbstractExpression parse(Priorities priority, Arguments argument) throws ParseException {
        if (priority.equals(Priorities.last())) {
            return parseHighestPriority(argument, Operations.BINARY);
        }

        AbstractExpression left = parse(priority.next(), argument);

        while (checkAbstractOperator(BINARY_OPERATIONS, priority)) {
            int position = getPosition();
            String operator = getAbstractOperator(BINARY_OPERATIONS);
            AbstractExpression right = parse(priority.next(), Arguments.SECOND);
            left = makeExpression(Operations.BINARY, left, right, operator, position);
        }
        return left;
    }

    private AbstractExpression parseHighestPriority(Arguments argument, Operations operation) throws ParseException {
        AbstractExpression expression;
        int position = getPosition();
        skipWhitespace();
        if (test('(')) {
            expression = parse(Priorities.first(), Arguments.FIRST);
            expect(')');
        } else if (isDigit()) {
            expression = parseConst("");
        } else if (checkAbstractOperator(UNARY_OPERATIONS, Priorities.NEGATE)) {
            String operator = getAbstractOperator(UNARY_OPERATIONS);
            skipWhitespace();
            if (eof() || ch == ')') {
                throw new ItemNotFoundException("argument for unary operation", (eof() ? "end of input" : "nothing"), getPosition());
            }
            expression = operator.equals("-") && isDigit() ? parseConst("-") :
                    makeExpression(Operations.UNARY, parseHighestPriority(Arguments.FIRST, Operations.UNARY), null, operator, position);
        } else {
            StringBuilder sb = new StringBuilder();
            while ((isLetter() || isDigit()) && !isBracket() && !Character.isWhitespace(ch) && !eof()) {
                sb.append(ch);
                nextChar();
            }
            String item = sb.toString();
            if (BINARY_OPERATIONS.containsKey(item)) {
                throw new ItemNotFoundException(
                        String.format("%sargument for %s operation", argument.get(operation), operation.get()), "nothing", position);
            }
            switch (item) {
                case "x":
                case "y":
                case "z":
                    expression = new Variable(item);
                    break;
                case "":
                    if (ch == ')') {
                        throw new ItemNotFoundException("variable/constant/unary operation inside brackets", "nothing", getPosition() - 1);
                    }
                    throw new ItemNotFoundException(
                            String.format("%sargument for %s operation", argument.get(operation), operation.get()), "nothing", position);
                default:
                    throw new InvalidVariableNameException(item, position);
            }
        }
        skipWhitespace();
        return expression;
    }

    private Const parseConst(String sign) throws ParseException {
        StringBuilder current = new StringBuilder();
        int position = getPosition() - sign.length();
        current.append(sign);
        while (isDigit()) {
            current.append(ch);
            expect(ch);
        }

        int nextPosition = getPosition();
        skipWhitespace();
        if (isDigit()) {
            throw new SpaceInNumberException(nextPosition);
        }

        int value;
        try {
            value = Integer.parseInt(current.toString());
        } catch (NumberFormatException e) {
            throw new InvalidConstException(current.toString(), "integer", position);
        }
        return new Const(value);
    }

    private boolean checkAbstractOperator(Map<String, Priorities> operations, Priorities priority) {
        for (var current : operations.entrySet()) {
            if (test(current.getKey())) {
                if (priority == null) {
                    return true;
                }
                return current.getValue().equals(priority);
            }
        }
        return false;
    }

    private String getAbstractOperator(Map<String, Priorities> operations) throws ParseException {
        String operator = "";
        for (var current : operations.entrySet()) {
            if (test(current.getKey())) {
                operator = current.getKey();
                expect(operator);
                break;
            }
        }
        return operator;
    }

    private AbstractExpression makeExpression(Operations type, AbstractExpression left, AbstractExpression right, String operator, int position) throws ParseException {
        if (type.equals(Operations.UNARY)) {
            switch (operator) {
                case "-":
                    return new CheckedNegate(left);
                case "abs":
                    return new CheckedAbs(left);
                case "sqrt":
                    return new CheckedSqrt(left);
            }
        } else {
            switch (operator) {
                case "+":
                    return new CheckedAdd(left, right);
                case "-":
                    return new CheckedSubtract(left, right);
                case "*":
                    return new CheckedMultiply(left, right);
                case "/":
                    return new CheckedDivide(left, right);
                case "gcd":
                    return new CheckedGcd(left, right);
                case "lcm":
                    return new CheckedLcm(left, right);
            }
        }
        throw new IllegalOperationException("unknown operation", position);
    }
}
