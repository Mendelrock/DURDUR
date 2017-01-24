package deco.commerce;

import static org.junit.Assert.*;

import org.junit.Test;

import deco.decorateur.CommandeOrdinaire;
import deco.emballage.*;

public class CommandePapierTest {

	@Test
	public void test() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new PapierOrdinaire(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(105.0, cde1.getMontant(), 0.01);
		
		cde1 = new PapierCadeau(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(114.0, cde1.getMontant(), 0.01);
	}

}
