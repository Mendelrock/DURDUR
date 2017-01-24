package airCountry;

public class AirCountry {
	
	public int distanceVol (IVol vol) {
		Aeroport dept = vol.getDepart();
		Aeroport dest = vol.getDestination();
		return vol.getDistance();
	}
}
