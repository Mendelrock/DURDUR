package calcul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import matrice.FMatrice;

public class CalculTest {
	Calcul c;
	
	@Before
	public void initialize(){
		c = new Calcul(5,5, new FMatrice());
		c.set(4, 4, 16);
		c.set(2, 2, 2);
	}
	
	@Test
	public void testSet() {
		assertFalse(c.get(2, 2)==0);
		assertTrue(c.get(4,4)==16);
		assertTrue(c.get(1, 1)==0);
	}
	
	@Test
	public void testOpti(){
		assertTrue(c.getMatrice().getTauxRemplissage()<=0.2);
		c.set(1, 1, 1);
		c.set(3, 3, 9);
		c.set(5, 5, 25);
		c.set(1, 2, 2);
		c.optimiser();
		assertFalse(c.getMatrice().getTauxRemplissage()<=0.2);
	}

}
