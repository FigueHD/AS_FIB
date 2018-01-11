package junit.com;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPercentatgeBonificacio {
	
	PercentatgeBonificacioStrategy pb;
	
	@Before
	public void setUp(){
		this.pb = new PercentatgeBonificacioStrategy();
	}
	
	

	@Test
	public void PercentatgeShouldWorks() {
		assertEquals("should bonifcacio is 1 for 10 minutes", 1, pb.calcularBonificacio(10));
	}
	
	@Test
	public void PercentatgeChangeShouldWorksCorrectly(){
		pb.changePercentatge(0.2);
		assertEquals("should bonifcacio is 2 for 10 minutes", 2, pb.calcularBonificacio(10));
	}

}
