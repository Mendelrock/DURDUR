package geo.loc;

/**
 * @author Ouziri
 * @Copyright 2015
 */

public class DistanceGeo {
	
    public static final double rayonTerre = 6371000;
	
	public double distance (double latitude1, double longitude1, double latitude2, double longitude2) {
	    double dLat = Math.toRadians(latitude2-latitude1);
	    double dLng = Math.toRadians(longitude2-longitude1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    return Math.abs(rayonTerre * c);
	}
}
