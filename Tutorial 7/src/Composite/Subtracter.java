package Composite;

public class Subtracter extends BinaryExpression {

    public Subtracter(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() - right.calculate();
    }
}
