package sadp6code;

public class Adder extends BinaryExpression {

    public Adder(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() + right.calculate();
    }
}