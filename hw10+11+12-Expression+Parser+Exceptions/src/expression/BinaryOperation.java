package expression;

import java.util.Objects;

public abstract class BinaryOperation implements AbstractExpression {
    private final AbstractExpression left;
    private final AbstractExpression right;

    public BinaryOperation(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract String getOperator();
    protected abstract Priorities getPriority();
    protected abstract int calculate(int a, int b);
    protected abstract double calculate(double a, double b);
    protected abstract boolean hasExtraBrackets();
    protected abstract boolean isAssociative();

    @Override
    public int evaluate(int x) {
        return calculate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public double evaluate(double x) {
        return calculate(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }


    @Override
    public String toMiniString() {
        return correct(left.toMiniString(), checkLeftOperand(left)) +
                " " + getOperator() + " " +
                correct(right.toMiniString(), checkRightOperand(right));
    }

    @Override
    public String toString() {
        return correct(left.toString() + " " + getOperator() + " " + right.toString(), true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        BinaryOperation that = (BinaryOperation) object;
        return this.left.equals(that.left) && this.right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, getOperator());
    }


    private String correct(String operand, boolean extraBrackets) {
        if (extraBrackets) {
            return "(" + operand + ")";
        }
        return operand;
    }

    private boolean checkLeftOperand(AbstractExpression expression) {
        if (expression instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) expression;
            return binaryOperation.getPriority().compareTo(this.getPriority()) < 0;
        }
        return false;
    }

    private boolean checkRightOperand(AbstractExpression expression) {
        if (checkLeftOperand(expression)) {
            return true;
        }
        if (expression instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) expression;
            return this.getPriority().equals(binaryOperation.getPriority()) && (!this.isAssociative() || binaryOperation.hasExtraBrackets());
        }
        return false;
    }
}
