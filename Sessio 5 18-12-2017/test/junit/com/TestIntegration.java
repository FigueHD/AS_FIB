package junit.com;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class TestIntegration {

	private PayStation ps;
	
	@Test
	public void shouldNyWorkCorrectly() throws IllegalCoinException {
		ps = new PayStationImpl( new LinearRateStrategy());
		addOneDollar();
		assertEquals(40, ps.readDisplay());
	}
	
	@Test
	public void shouldBostonWorkCorrectly() throws IllegalCoinException {
		ps = new PayStationImpl( new ProgressiveRateStrategy());
		addOneDollar();
		assertEquals(40, ps.readDisplay());
	}
	
	
	public void addOneDollar() throws IllegalCoinException {
		ps.addPayment(25);ps.addPayment(25);
		ps.addPayment(25);ps.addPayment(25);
	}
}
