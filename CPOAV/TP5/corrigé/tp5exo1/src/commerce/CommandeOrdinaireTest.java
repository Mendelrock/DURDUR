package commerce;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandeOrdinaireTest {
	@Test
	public void test() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNuméro());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new Emballage(cde1);
		assertEquals(1, cde1.getNuméro());
		assertEquals(103.0, cde1.getMontant(), 0.01);
		
		cde1 = new Emballage(cde1);
		assertEquals(1, cde1.getNuméro());
		assertEquals(106.0, cde1.getMontant(), 0.01);		
	}

}
