import static org.junit.Assert.*;

import org.junit.Test;

public class evaluate {

	@Test
	public void test() {
	  calculator caltest=new calculator();
	  assertEquals( String.valueOf(7), caltest.evaluate("5+2"));
	}

}
