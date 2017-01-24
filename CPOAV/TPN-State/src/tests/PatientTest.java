package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.PatientPasAffect�;
import exceptions.PatientPasEnAttente;
import exceptions.PatientPasEvalu�;
import hopital.Patient;

public class PatientTest {
	private Patient p1,p2;
	private String nomP1, nomP2;
	private String doc1, doc2;
	private int  gravit�P1, gravit�P2;
	
	@Before
	public void init() {
		nomP1 = "Bob";
		gravit�P1 = 2;
		doc1 = "Dr Ross";
		nomP2 = "Alice";
		gravit�P2 = 4;
		doc2 = "Dr House";
		p1 = new Patient(nomP1, gravit�P1);
		p2 = new Patient(nomP2, gravit�P2);
	}
	
	@Test
	public void testCycleNormalPasGrave() {
		assertEquals(nomP1, p1.getNom());
		assertEquals(gravit�P1, p1.getGravit�());
		assertEquals("EnAttente", p1.getNomEtat());
		p1.�valuer();
		assertEquals("Evalu�", p1.getNomEtat());
		p1.affecter(doc1);
		assertEquals("Affect�", p1.getNomEtat());
		assertEquals(doc1,p1.getDoc());
		p1.traiter();
		assertEquals("Trait�", p1.getNomEtat());
	}
	
	@Test
	public void testCycleNormalGrave() {
		assertEquals(nomP2, p2.getNom());
		assertEquals(gravit�P2, p2.getGravit�());
		assertEquals("EnAttente", p2.getNomEtat());
		p2.�valuer();
		assertEquals("Affect�", p2.getNomEtat());
		assertEquals(doc2,p2.getDoc());
		p2.traiter();
		assertEquals("Trait�", p2.getNomEtat());
	}
	
	@Test(expected = PatientPasAffect�.class)
	public void testPasDeDoc() {
		p1.getDoc();
	}
	
	@Test(expected = PatientPasEvalu�.class)
	public void testPasEvalu�() {
		p1.affecter(doc1);

	}
	
	@Test(expected = PatientPasAffect�.class)
	public void testPasAffect�() {
		p1.traiter();
	}
	
	@Test(expected = PatientPasAffect�.class)
	public void testPasValid�() {
		p1.�valuer();
		p1.affecter(doc1);
		p1.traiter();
		p1.traiter();
	}
	@Test(expected = PatientPasEnAttente.class)
	public void testPatientPasEnAttente() {
		p1.�valuer();
		p1.�valuer();
	}
}
