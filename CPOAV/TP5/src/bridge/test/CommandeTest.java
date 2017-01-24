package bridge.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bridge.commande.Commande;
import bridge.commande.ILivraison;
import bridge.livraisons.LivraisonAuMontant;
import bridge.livraisons.LivraisonAuPoids;

public class CommandeTest {
	@Test
	public void test() {
		Commande cd1 = new Commande(1.0, 100);
		Commande cd2 = new Commande(1.5, 100);
		Commande cd3 = new Commande(2.1, 100);
		
		assertEquals(1.0, cd1.getPoids(),0.01);
		assertEquals(1.5, cd2.getPoids(),0.01);
		assertEquals(2.1, cd3.getPoids(),0.01);
		
		assertEquals(100.0, cd1.getMontantTotal(), 0.01);
		assertEquals(100.0, cd2.getMontantTotal(), 0.01);
		assertEquals(100.0, cd3.getMontantTotal(), 0.01);
		
		ILivraison lam = new LivraisonAuMontant();
		ILivraison lap = new LivraisonAuPoids();
		
		cd1.setLivraison(lam);
		assertEquals(110.0, cd1.getMontantTotal(), 0.01);
		
		cd1.setLivraison(lap);
		cd2.setLivraison(lap);
		cd3.setLivraison(lap);
		assertEquals(105.0, cd1.getMontantTotal(), 0.01);
		assertEquals(108.0, cd2.getMontantTotal(), 0.01);
		assertEquals(115.0, cd3.getMontantTotal(), 0.01);
		
	}
}
