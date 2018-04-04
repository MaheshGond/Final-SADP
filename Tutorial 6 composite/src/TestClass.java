package sadp6code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void testComplex() {
        Expression e =
                new Divider(
                        new Multiplier(
                                new Negate(new Constant(5.0)),
                                new Divider(new Constant(9.0), new Constant(6.0))
                        ),
                        new Adder(
                                new Constant(7.0),
                                new Subtracter(new Constant(2.0), new Constant(1.5))
                        )
                );
        assertEquals(-1, e.calculate(), 0.0);
    }
}