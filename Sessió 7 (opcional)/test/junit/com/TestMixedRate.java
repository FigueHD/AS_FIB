package junit.com;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class TestMixedRate{
	
	MixedRateStrategy mrs;

	@Test
	public void MixedRateworksonweekend() {
		mrs = new MixedRateStrategy(true);
		assertEquals(mrs.calculateTime(250),90);	
	}
	
	@Test
	public void MixedRateworksonweekday() {
		mrs = new MixedRateStrategy(false);
		assertEquals(mrs.calculateTime(250),100);	
	}
	
	@Test
	public void MixedRateworksonweekdayandchangeit() {
		mrs = new MixedRateStrategy(false);
		mrs.changeToWeekend();
		assertEquals(mrs.calculateTime(250),90);	
	}
	
	@Test
	public void MixedRateworksonweekendandchangeit() {
		mrs = new MixedRateStrategy(true);
		mrs.changeToWeekday();
		assertEquals(mrs.calculateTime(250),100);	
	}


}
