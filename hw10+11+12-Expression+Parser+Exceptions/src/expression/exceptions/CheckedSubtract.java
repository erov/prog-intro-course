package expression.exceptions;

import expression.AbstractExpression;
import expression.Subtract;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected int calculate(int a, int b) {
        return CheckedMath.subtract(a, b);
    }

    @Override
    protected double calculate(double a, double b) {
        throw new UnsupportedCalculateTypeException("double precision");
    }
}