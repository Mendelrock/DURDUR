package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import employés.*;
import gestionPersonnels.Entreprise;

public class EntrepriseTest {
	Entreprise Lafrance = new Entreprise();

	@Test
	public void testRechercher() {
		//Vérification fonction de recherche
		assertNull(Lafrance.chercher("Toto"));
	}
	
	@Test
	public void testEmbaucher() {
		//Vérification embauche
		Lafrance.embaucher(new Technicien("Toto", 2000.0));
		assertNotNull(Lafrance.chercher("Toto"));
		assertTrue(Lafrance.getSalaire("Toto") == 2000.0);
		assertTrue(Lafrance.getAbsences("Toto")== 0);
	}
	
	@Test
	public void testSalaire() {
		//Vérification salaire
		Lafrance.embaucher(new Technicien("Toto", 2000.0));
		Lafrance.setAbsences("Toto",2);
		assertTrue(Lafrance.getSalaire("Toto") < 2000.0);
	}
	
	@Test
	public void testAffichage() {
		Lafrance.embaucher(new Technicien("Toto", 2000.0));
		Lafrance.embaucher(new Technicien("Cabroule", 2500.0));
		Lafrance.embaucher(new Technicien("Lalalane", 2100.0));
		Lafrance.embaucher(new Commercial("Françoué", 500.0));
		Lafrance.embaucher(new Commercial("Nico", 600.0));
		Lafrance.embaucher(new Ingénieur("Titi", 3000.0));
		Lafrance.setAbsences("Toto",2);
		Lafrance.setAbsences("Nico",1);
		Lafrance.setAbsences("Titi",3);
		System.out.println(Lafrance);
	}

}
