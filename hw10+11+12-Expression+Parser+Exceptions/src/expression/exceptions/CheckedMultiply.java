package expression.exceptions;

import expression.AbstractExpression;
import expression.Multiply;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected int calculate(int a, int b) {
        return CheckedMath.multiply(a, b);
    }

    @Override
    protected double calculate(double a, double b) {
        throw new UnsupportedCalculateTypeException("double precision");
    }
}
