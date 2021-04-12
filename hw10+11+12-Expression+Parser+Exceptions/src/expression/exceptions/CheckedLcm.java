package expression.exceptions;

import expression.AbstractExpression;
import expression.BinaryOperation;
import expression.Priorities;

public class CheckedLcm extends BinaryOperation {
    public CheckedLcm(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "lcm";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.GCD;
    }

    @Override
    protected int calculate(int a, int b) {
        return CheckedMath.lcm(a, b);
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
