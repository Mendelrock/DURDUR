package commandes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandeTest {
	private Commande cde;
	private final int num = 1;
	@Before
	public void init(){
		cde = new Commande(num);
	}
	@Test
	public void testCycleNormal() {
		assertEquals(1, cde.getNum�ro());
		assertEquals("Cr��e", cde.getEtat());
		cde.payer();
		assertEquals("Pay�e", cde.getEtat());
		cde.livrer();
		assertEquals("Livr�e", cde.getEtat());
	}
	@Test(expected = CommandeNonLivrableEx.class)
	public void testNonLivrable() {
		cde.livrer();
	}
	@Test(expected = CommandeNonLivrableEx.class)
	public void testNonLivrableBis() {
		cde.payer();
		cde.rembourser();
		cde.livrer();
	}
	@Test(expected = CommandeNonRemboursableEx.class)
	public void testNonRemboursable() {
		cde.payer();
		cde.livrer();
		cde.rembourser();
	}
	@Test(expected = CommandeNonRemboursableEx.class)
	public void testNonRemboursableBis() {
		cde.rembourser();
	}
	@Test(expected = CommandeD�j�Pay�eEx.class)
	public void testD�j�Pay�e() {
		cde.payer();
		cde.payer();
	}
}
