package expression;

public class Divide extends BinaryOperation {
    public Divide(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    protected String getOperator() {
        return "/";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.MUL;
    }

    @Override
    protected int calculate(int a, int b) {
        return a / b;
    }

    @Override
    protected double calculate(double a, double b) {
        return a / b;
    }

    @Override
    protected boolean hasExtraBrackets() {
        return true;
    }

    @Override
    protected boolean isAssociative() {
        return false;
    }
}
