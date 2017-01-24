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
		assertEquals(paris.getCoordonnées(), 0);
		assertEquals(londres.getCoordonnées(), 300);
		
		assertEquals(paris.toString(), "CDG");
		assertEquals(londres.toString(), "LHR");
		
	}

}
