package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import employ�s.*;
import gestionPersonnels.Entreprise;

public class EntrepriseTest {
	Entreprise Lafrance = new Entreprise();

	@Test
	public void testRechercher() {
		//V�rification fonction de recherche
		assertNull(Lafrance.chercher("Toto"));
	}
	
	@Test
	public void testEmbaucher() {
		//V�rification embauche
		Lafrance.embaucher(new Technicien("Toto", 2000.0));
		assertNotNull(Lafrance.chercher("Toto"));
		assertTrue(Lafrance.getSalaire("Toto") == 2000.0);
		assertTrue(Lafrance.getAbsences("Toto")== 0);
	}
	
	@Test
	public void testSalaire() {
		//V�rification salaire
		Lafrance.embaucher(new Technicien("Toto", 2000.0));
		Lafrance.setAbsences("Toto",2);
		assertTrue(Lafrance.getSalaire("Toto") < 2000.0);
	}
	
	@Test
	public void testAffichage() {
		Lafrance.embaucher(new Technicien("Toto", 2000.0));
		Lafrance.embaucher(new Technicien("Cabroule", 2500.0));
		Lafrance.embaucher(new Technicien("Lalalane", 2100.0));
		Lafrance.embaucher(new Commercial("Fran�ou�", 500.0));
		Lafrance.embaucher(new Commercial("Nico", 600.0));
		Lafrance.embaucher(new Ing�nieur("Titi", 3000.0));
		Lafrance.setAbsences("Toto",2);
		Lafrance.setAbsences("Nico",1);
		Lafrance.setAbsences("Titi",3);
		System.out.println(Lafrance);
	}

}
