package expression.exceptions;

import expression.AbstractExpression;
import expression.Add;

public class CheckedAdd extends Add {
    public CheckedAdd(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected int calculate(int a, int b) {
        return CheckedMath.add(a, b);
    }

    @Override
    protected double calculate(double a, double b) {
        throw new UnsupportedCalculateTypeException("double precision");
    }

}