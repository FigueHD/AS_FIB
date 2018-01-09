package junit.com;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestLinearRate {
	
	LinearRateStrategy lrs;
	
	@Before
	public void setUp() {
		this.lrs = new LinearRateStrategy();
	}
	
	@Test
	public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
			assertEquals( "Should display 2 min for 5 cents", 
			5 / 5 * 2, lrs.calcularTarifa(5) ); 
	}
}

