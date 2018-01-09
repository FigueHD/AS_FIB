package junit.com;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestHoursMultaStrategy {
	
	HoursMultaStrategy hms;
	
	@Before
	public void setUp() {
		hms = new HoursMultaStrategy();
	}

	@Test
	public void shouldHoursStrategyWorks() throws NoEsPotCalcular {
		assertEquals(hms.calcularImportMulta(62, 63),500);		
	}
	
	@Test(expected=NoEsPotCalcular.class)
	public void shouldExceptionLessThanHours() throws NoEsPotCalcular {
		hms.calcularImportMulta(62, 59);
	}
	
	@Test(expected=NoEsPotCalcular.class)
	public void shouldException3vecesMas() throws NoEsPotCalcular {
		hms.calcularImportMulta(50, 151);	
	}

}
