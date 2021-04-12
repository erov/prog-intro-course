package expression;

public class And extends BinaryOperation {
    public And(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "&";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.AND;
    }

    @Override
    protected int calculate(int a, int b) {
        return a & b;
    }

    @Override
    protected double calculate(double a, double b) {
        throw new UnsupportedOperationException("wrong operation for double precision");
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
