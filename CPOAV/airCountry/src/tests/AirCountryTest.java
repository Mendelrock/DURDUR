package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import airCountry.AirCountry;

public class AirCountryTest extends VolPassagerTest{
	private AirCountry agence;
	
	@Before
	public void initAgences() {
		agence = new AirCountry();
	}

	@Test
	public void test() {
		assertEquals(agence.distanceVol(parisLondres),300);
	}

}
