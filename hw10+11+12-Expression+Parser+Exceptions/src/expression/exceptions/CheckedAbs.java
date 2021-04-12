package expression.exceptions;

import expression.AbstractExpression;
import expression.Priorities;
import expression.UnaryOperation;

public class CheckedAbs extends UnaryOperation {
    public CheckedAbs(AbstractExpression expression) {
        super(expression);
    }

    @Override
    protected String getOperator() {
        return "abs";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.NEGATE;
    }

    @Override
    protected int calculate(int a) {
        return CheckedMath.abs(a);
    }

    @Override
    protected double calculate(double a) {
        throw new UnsupportedCalculateTypeException("double precision");
    }
}
