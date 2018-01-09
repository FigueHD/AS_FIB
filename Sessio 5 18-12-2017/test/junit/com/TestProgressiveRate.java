package junit.com;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestProgressiveRate {

	ProgressiveRateStrategy prs;
	
	@Before
	public void setUp() {
		this.prs = new ProgressiveRateStrategy();
	}
	
	@Test
	public void testFirstHourWorks() throws IllegalCoinException {
		assertEquals(2, prs.calcularTarifa(5));
	}
	
	@Test
	public void testSecondtHourWorks() throws IllegalCoinException {
		assertEquals(75, prs.calcularTarifa(200));
	}
	
	@Test
	public void testThirdHourWorks() throws IllegalCoinException {
		assertEquals(120, prs.calcularTarifa(350));
	}
	@Test
	public void testConsecutiveHourWorks() throws IllegalCoinException {
		assertEquals(140, prs.calcularTarifa(450));
	}

}
