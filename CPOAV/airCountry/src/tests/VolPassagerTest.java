package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vols.Vol;
import vols.VolPassager;

public class VolPassagerTest extends AeroportTest {
	protected Vol parisLondres;
	
	@Before
	public void initVols() {
		parisLondres = new VolPassager(paris, londres);
	}

	@Test
	public void test() {
		assertEquals(parisLondres.getDepart().toString(), "CDG");
		assertEquals(parisLondres.getDestination().toString(), "LHR");
	}

}
