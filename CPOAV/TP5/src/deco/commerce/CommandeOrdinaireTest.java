package deco.commerce;

import static org.junit.Assert.*;

import org.junit.Test;

import deco.decorateur.*;
import deco.emballage.Emballage;

public class CommandeOrdinaireTest {
	@Test
	public void test() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new Emballage(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(103.0, cde1.getMontant(), 0.01);
		
		cde1 = new Emballage(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(106.0, cde1.getMontant(), 0.01);		
	}

}
