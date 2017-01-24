package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import commandes.CdeOrdinaire;
import commandes.CdeUrgente;
import commerce.ICommande;
import options.Emballage;
import options.LivraisonADomicile;
import options.LivraisonEnPtDeRetrait;

public class CommandesTest {
	@Test
	public void test() {
		ICommande cde1 = new CdeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNum�ro());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new Emballage(cde1);
		assertEquals(1, cde1.getNum�ro());
		assertEquals(103.0, cde1.getMontant(), 0.01);
		
		cde1 = new Emballage(cde1);
		assertEquals(1, cde1.getNum�ro());
		assertEquals(106.0, cde1.getMontant(), 0.01);
		
		ICommande cde2 = new CdeUrgente(2, 100);
		assertEquals(2, cde2.getNum�ro());
		assertEquals(120.0, cde2.getMontant(), 0.01);
		
		cde2 = new Emballage(cde2);
		assertEquals(2, cde2.getNum�ro());
		assertEquals(123.0, cde2.getMontant(), 0.01);
		
		cde1 = new LivraisonEnPtDeRetrait(cde1, "Paris");
		assertEquals(1, cde1.getNum�ro());
		assertEquals(108.0, cde1.getMontant(), 0.01);
		
		cde2 = new LivraisonADomicile(cde2);
		assertEquals(2, cde2.getNum�ro());
		assertEquals(132.0, cde2.getMontant(), 0.01);
	}

}
