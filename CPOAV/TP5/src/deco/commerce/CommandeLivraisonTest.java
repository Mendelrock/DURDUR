package deco.commerce;

import static org.junit.Assert.*;

import org.junit.Test;

import deco.decorateur.CommandeOrdinaire;
import deco.emballage.*;
import deco.livraison.*;

public class CommandeLivraisonTest {

	@Test
	public void COTest() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
	}
	
	@Test
	public void CEOTest() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new PapierOrdinaire(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(105.0, cde1.getMontant(), 0.01);
	}
	
	@Test
	public void CECTest() {	
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new PapierCadeau(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(109.0, cde1.getMontant(), 0.01);
	}
	
	@Test
	public void CLTest() {	
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		ICommande cde2 = new CommandeOrdinaire(2, 30.0);
		assertEquals(2, cde2.getNumero());
		assertEquals(30.0, cde2.getMontant(), 0.01);
		
		cde1 = new LivraisonADomicile(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(109.0, cde1.getMontant(), 0.01);
		
		cde2 = new LivraisonADomicile(cde2);
		assertEquals(2, cde2.getNumero());
		assertEquals(35.0, cde2.getMontant(), 0.01);
	}
	
	@Test
	public void CLPDTTest() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new LivraisonPtdeRetrait(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(102.0, cde1.getMontant(), 0.01);
	}

	@Test
	public void CEOLPDTTest() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		
		cde1 = new PapierOrdinaire(cde1);
		cde1 = new LivraisonPtdeRetrait(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(107.0, cde1.getMontant(), 0.01);
	}
	
	@Test
	public void CECLPDTTest() {
		ICommande cde1 = new CommandeOrdinaire(1, 100.0);
		assertEquals(1, cde1.getNumero());
		assertEquals(100.0, cde1.getMontant(), 0.01);
		

		cde1 = new PapierCadeau(cde1);
		cde1 = new LivraisonPtdeRetrait(cde1);
		assertEquals(1, cde1.getNumero());
		assertEquals(111.0, cde1.getMontant(), 0.01);
	}
}
