package junit.com;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestNoBonificacio {
	
	NoBonificacioStrategy nbs;
	
	@Before
	public void setUp(){
		this.nbs = new NoBonificacioStrategy();
	}
	
	@Test
	public void NoBonificacioShouldWork(){
		assertEquals("For 5 minuts bought bonificacion is 0",0, nbs.calcularBonificacio(5));
	}

}
