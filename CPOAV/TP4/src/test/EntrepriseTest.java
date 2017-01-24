package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entreprise.Entreprise;
import entreprise.ServiceExistantException;
import services.FactoryService;

public class EntrepriseTest {

	Entreprise e;
	
	@Before
	public void initialise(){
		e = new Entreprise(new FactoryService());
	}
	
	@Test
	public void testPr�senceServiceCr�a() {
		assertFalse(e.iterator().hasNext());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionTypeService() {
		e.addService("plop", "Commercial");
	}
	
	@Test
	public void testNouveauxServices(){
		e.addService("infrastructures", "Technique");
		e.addService("r�alisation", "Technique");
		e.addService("administration", "Administratif");
		assertEquals(e.searchServiceByNom("infrastructures").getNom(),"infrastructures");
		assertEquals(e.searchServiceByNom("r�alisation").getNom(),"r�alisation");
		assertEquals(e.searchServiceByNom("administration").getNom(),"administration");
	}
	
	@Test(expected=ServiceExistantException.class)
	public void testExceptionDoublonNom(){
		e.addService("infrastructures", "Technique");
		e.addService("infrastructures", "Technique");
	}
	
	@Test(expected=ServiceExistantException.class)
	public void testExceptionDoublonAdmin(){
		e.addService("admin", "Administratif");
	}
}
