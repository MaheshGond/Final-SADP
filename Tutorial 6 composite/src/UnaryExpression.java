package sadp6code;

public abstract class UnaryExpression implements Expression {
    protected Expression right;

    public UnaryExpression(Expression right) {
        this.right = right;
    }
}
