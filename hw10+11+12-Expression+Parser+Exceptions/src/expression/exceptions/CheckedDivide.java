package expression.exceptions;

import expression.AbstractExpression;
import expression.Divide;

public class CheckedDivide extends Divide {
    public CheckedDivide(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected int calculate(int a, int b) {
        return CheckedMath.divide(a, b);
    }

    @Override
    protected double calculate(double a, double b) {
        throw new UnsupportedCalculateTypeException("double precision");
    }

}
