package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import arithmétique.IOperation;
import composants.operations.Opération;
import composants.operations.Plus;
import composants.valeurs.Pi;
import composants.valeurs.Variable;

public class TestArithmétique {

	@Test
	public void test() {
		Variable g = new Variable(5.);
		assertEquals(5., g.eval(), 0.01);
		
		Variable d = new Variable(2.);
		assertEquals(2., d.eval(),0.01);
		
		// 5+2=7
		Opération op = new Opération('+',g,d);
		assertEquals(7., op.eval(),0.01);
		
		Variable o = new Variable(3.);
		assertEquals(3., o.eval(),0.01);
		
		// 2+3=5
		Opération op2 = new Opération('+',d,o);
		assertEquals(5., op2.eval(),0.01);
		
		// 5+(2+3)=10
		Opération op3 = new Opération('+',g,op2);
		assertEquals(10., op3.eval(),0.01);		
	}
	
	@Test
	public void testPiPlus() {
		IOperation g = new Variable(5.);
		assertEquals(5., g.eval(), 0.01);
		
		IOperation d = new Variable(2.);
		assertEquals(2., d.eval(),0.01);
		
		// 5+2=7
		IOperation op = new Plus(g,d);
		assertEquals(7., op.eval(),0.01);
		
		// Pi~=3.14
		IOperation o = new Pi();
		assertEquals(3.14, o.eval(),0.01);
		
		// 2+Pi~=5.14
		IOperation op2 = new Plus(d,o);
		assertEquals(5.14, op2.eval(),0.01);
		
		// 5+(2+Pi)~=10.14
		IOperation op3 = new Plus(g,op2);
		assertEquals(10.14, op3.eval(),0.01);
		
		// (5+2)+(5+(2+Pi))~=17.14
		IOperation op4 = new Opération('+',op,op3);
		assertEquals(17.14, op4.eval(),0.01);
	}
}
