package expression;

public class Negate extends UnaryOperation {

    public Negate(AbstractExpression expression) {
        super(expression);
    }

    @Override
    protected String getOperator() {
        return "-";
    }

    @Override
    protected Priorities getPriority() {
        return Priorities.NEGATE;
    }

    @Override
    protected int calculate(int a) {
        return -a;
    }

    @Override
    protected double calculate(double a) {
        return -a;
    }
}
