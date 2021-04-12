package expression;

public class Flip extends UnaryOperation {
    public Flip(AbstractExpression expression) {
        super(expression);
    }

    @Override
    protected String getOperator() {
        return "flip ";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.NEGATE;
    }

    @Override
    protected int calculate(int a) {
        return Integer.reverse(a) >>> (Integer.numberOfLeadingZeros(a));
    }

    @Override
    protected double calculate(double a) {
        throw new UnsupportedOperationException("wrong operation for double precision");
    }
}
