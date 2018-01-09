package junit.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntegration {

	PayStation ps;
	
	@Test
	public void MultaMinutesWorks() throws NoEsPotCalcular {
		ps = new PayStationImpl(new MinutesMultaStrategy());
		assertEquals("Should return 355", 355, ps.importMulta(50,71));
	}
	
	@Test
	public void MultaMinutesWorksAfterChangingStrategy() throws NoEsPotCalcular {
		ps = new PayStationImpl(new HoursMultaStrategy());
		ps.changeMultaStrategy(new MinutesMultaStrategy());
		assertEquals("Should return 355", 355, ps.importMulta(50,71));
	}
	
	@Test(expected=NoEsPotCalcular.class)
	public void MultaMinutesThrowsException() throws NoEsPotCalcular {
		ps = new PayStationImpl(new MinutesMultaStrategy());
		ps.importMulta(0,71);
	}
	
	@Test
	public void MultaHoursWorks() throws NoEsPotCalcular {
		ps = new PayStationImpl(new HoursMultaStrategy());
		assertEquals("Should return 500", 500, ps.importMulta(71,92));
	}
	
	@Test
	public void MultaHoursWorksAfterChangingStrategy() throws NoEsPotCalcular {
		ps = new PayStationImpl(new MinutesMultaStrategy());
		ps.changeMultaStrategy(new HoursMultaStrategy());
		assertEquals("Should return 500", 500, ps.importMulta(71,92));
	}
	
	@Test(expected=NoEsPotCalcular.class)
	public void MultaHoursThrowsException() throws NoEsPotCalcular {
		ps = new PayStationImpl(new HoursMultaStrategy());
		ps.importMulta(50,59);
	}
	
	@Test(expected=NoEsPotCalcular.class)
	public void MultaHoursThrowsException2() throws NoEsPotCalcular {
		ps = new PayStationImpl(new HoursMultaStrategy());
		ps.importMulta(50,151);
	}

}