package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import airCountry.Aeroport;

public class AeroportTest {
	protected Aeroport paris;
	protected Aeroport londres;
	
	@Before
	public void initAeroports(){
		paris = new Aeroport("CDG", 0);
		londres = new Aeroport("LHR", 300);
	}

	@Test
	public void test() {
		assertEquals(paris.getCoordonn�es(), 0);
		assertEquals(londres.getCoordonn�es(), 300);
		
		assertEquals(paris.toString(), "CDG");
		assertEquals(londres.toString(), "LHR");
		
	}

}
