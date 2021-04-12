package expression.exceptions;

import expression.AbstractExpression;
import expression.Priorities;
import expression.UnaryOperation;

public class CheckedSqrt extends UnaryOperation {
    public CheckedSqrt(AbstractExpression expression) {
        super(expression);
    }

    @Override
    protected String getOperator() {
        return "sqrt";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.NEGATE;
    }

    @Override
    protected int calculate(int a) {
        return CheckedMath.sqrt(a);
    }

    @Override
    protected double calculate(double a) {
        throw new UnsupportedCalculateTypeException("double precision");
    }
}
