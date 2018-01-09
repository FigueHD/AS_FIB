package junit.com;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestMinutesMultaStrategy {
	
	MinutesMultaStrategy mms;
	
	@Before
	public void setUp() {
		mms = new MinutesMultaStrategy();
	}
	
	@Test
	public void minutesMultaWorks() throws NoEsPotCalcular {
		assertEquals(mms.calcularImportMulta(50, 30), 150);
	}
	
	@Test (expected = NoEsPotCalcular.class)
	public void minutesMultaWorksExceptionNotimeBought() throws NoEsPotCalcular {
		mms.calcularImportMulta(0, 30);
	}

}
