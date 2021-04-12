package expression.exceptions;

import expression.AbstractExpression;
import expression.BinaryOperation;
import expression.Priorities;

public class CheckedGcd extends BinaryOperation {
    public CheckedGcd(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "gcd";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.NEGATE;
    }

    @Override
    protected int calculate(int a, int b) {
        return CheckedMath.gcd(a, b);
    }

    @Override
    protected double calculate(double a, double b) {
        throw new UnsupportedCalculateTypeException("double precision");
    }

    @Override
    protected boolean hasExtraBrackets() {
        return false;
    }

    @Override
    protected boolean isAssociative() {
        return true;
    }
}
