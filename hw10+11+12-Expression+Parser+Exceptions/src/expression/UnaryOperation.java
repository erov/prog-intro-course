package expression;

public abstract class UnaryOperation implements AbstractExpression {
    private final AbstractExpression expression;

    public UnaryOperation(AbstractExpression expression) {
        this.expression = expression;
    }

    protected abstract String getOperator();
    protected abstract Priorities getPriority();
    protected abstract int calculate(int a);
    protected abstract double calculate(double a);

    @Override
    public double evaluate(double x) {
        return calculate(expression.evaluate(x));
    }

    @Override
    public int evaluate(int x) {
        return calculate(expression.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(expression.evaluate(x, y, z));
    }

    @Override
    public String toMiniString() {
        boolean brackets = expression instanceof BinaryOperation;
        return getOperator() + (brackets ? "(" : "") + expression.toMiniString() + (brackets ? ")" : "");
    }

    @Override
    public String toString() {
        return getOperator() + "(" + expression.toString() + ")";
    }

}
