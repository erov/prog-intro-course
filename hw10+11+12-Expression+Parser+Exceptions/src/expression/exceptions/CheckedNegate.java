package expression.exceptions;

import expression.AbstractExpression;
import expression.Negate;

public class CheckedNegate extends Negate {
    public CheckedNegate(AbstractExpression expression) {
        super(expression);
    }

    @Override
    protected int calculate(int a) {
        return CheckedMath.negate(a);
    }

    @Override
    protected double calculate(double a) {
        throw new UnsupportedCalculateTypeException("double precision");
    }
}
