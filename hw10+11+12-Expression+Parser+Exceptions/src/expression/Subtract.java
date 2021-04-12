package expression;

public class Subtract extends BinaryOperation {
    public Subtract(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "-";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.ADD;
    }

    @Override
    protected int calculate(int a, int b) {
        return a - b;
    }

    @Override
    protected double calculate(double a, double b) {
        return a - b;
    }

    @Override
    protected boolean hasExtraBrackets() {
        return false;
    }

    @Override
    protected boolean isAssociative() {
        return false;
    }
}
