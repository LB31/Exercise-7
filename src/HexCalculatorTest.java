import static org.junit.Assert.*;

import org.junit.Test;

public class HexCalculatorTest {

	private HexCalcEngine testor;

	public HexCalculatorTest() {
		testor = new HexCalcEngine();
	}

	@Test
	public void testPlus() {
		testor.clear();
		testor.numberPressed(6);
		testor.plus();
		testor.numberPressed(7);
		testor.equals();
		assertEquals(13, testor.displayValue);
	}

	@Test
	public void testMinus() {
		testor.clear();
		testor.numberPressed(2);
		testor.minus();
		testor.numberPressed(7);
		testor.equals();
		assertEquals(-5, testor.displayValue);
	}

	@Test
	public void testMultiply() {
		testor.clear();
		testor.numberPressed(2);
		testor.multiply();
		testor.numberPressed(3);
		testor.equals();
		assertEquals(6, testor.displayValue);
	}

}
