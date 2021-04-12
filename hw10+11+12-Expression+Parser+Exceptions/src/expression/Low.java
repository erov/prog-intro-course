package expression;

public class Low extends UnaryOperation {
    public Low(AbstractExpression expression) {
        super(expression);
    }

    @Override
    protected String getOperator() {
        return "low ";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.NEGATE;
    }

    @Override
    protected int calculate(int a) {
        return Integer.lowestOneBit(a);
    }

    @Override
    protected double calculate(double a) {
        throw new UnsupportedOperationException("wrong operation for double precision");
    }
}
