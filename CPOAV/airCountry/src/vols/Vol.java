package vols;

import airCountry.Aeroport;
import airCountry.IVol;

public class Vol implements IVol{

	protected Aeroport depart;
	protected Aeroport destination;

	public Vol() {
		super();
	}

	public Aeroport getDepart() {
	    return this.depart;
	}

	public Aeroport getDestination() {
	    return this.destination;
	}

	@Override
	public int getDistance() {
		return depart.getDistance(destination);
	}

}