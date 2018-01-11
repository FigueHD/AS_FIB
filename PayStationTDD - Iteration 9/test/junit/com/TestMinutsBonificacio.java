package junit.com;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMinutsBonificacio {
	
	MinutsBonificacioStrategy mbs;
		
	@Before
	public void setUp(){
		this.mbs = new MinutsBonificacioStrategy();		
	}
	
	@Test
	public void minutsBonificacioShouldWork() throws NoEsPotBonificar{
		assertEquals("Bonificacio per 5 minuts ha de donar 1", 1, mbs.calcularBonificacio(5));
	}
	
	@Test(expected = NoEsPotBonificar.class)
	public void exceptionsTimeBoughtLessThanMinutesToBonificate() throws NoEsPotBonificar{
		mbs.calcularBonificacio(4);
	}
	
	@Test
	public void minutsABonificarChangeWorksCorrectly() throws NoEsPotBonificar{
		mbs.changeMinutsABonificar(10);
		assertEquals("Bonificacio per 10 minuts ha de donar 1", 1, mbs.calcularBonificacio(10));
	}

}
