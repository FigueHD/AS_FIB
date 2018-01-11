package junit.com;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestIntegration {
	
	
	  PayStation ps;
	  MinutsBonificacioStrategy mbs;
	  NoBonificacioStrategy nbs;
	  

	  @Before
	  public void setUp() {
	    ps = new PayStationImpl( new PercentatgeBonificacioStrategy());
	    mbs = new MinutsBonificacioStrategy();
	    nbs = new NoBonificacioStrategy();
	  }
	
	

	@Test
	public void shouldPercentatgeBonificacioStrategyWorksCorrectly() throws NoEsPotBonificar, IllegalCoinException {
		ps.addPayment(25);
		ps.addPayment(25);
		assertEquals("timeBought with bonificacion is 22 for 20 minutes", 22, ps.buy().value());
	}
	
	@Test
	public void shouldMinutesBonificacioStrategyWorksCorrectly() throws NoEsPotBonificar, IllegalCoinException {
		ps.canviarMetodeDeBonificacio(mbs);
		ps.addPayment(25);
		ps.addPayment(25);
		ps.addPayment(25);
		assertEquals("timeBought with bonificacion is 36 for 30 minutes", 36, ps.buy().value());
	}
	
	@Test
	public void shouldNoBonificacioStrategyWorksCorrectly() throws NoEsPotBonificar, IllegalCoinException {
		ps.canviarMetodeDeBonificacio(nbs);
		addOneDollar();
		assertEquals("timeBought with bonificacion is 40 for 40 minutes", 40, ps.buy().value());
	}
	
	private void addOneDollar() throws IllegalCoinException {
		ps.addPayment(25); ps.addPayment(25); 
	    ps.addPayment(25); ps.addPayment(25); 
	}

}
