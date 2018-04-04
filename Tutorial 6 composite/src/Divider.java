package sadp6code;

public class Divider extends BinaryExpression {

    public Divider(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() / right.calculate();
    }
}
