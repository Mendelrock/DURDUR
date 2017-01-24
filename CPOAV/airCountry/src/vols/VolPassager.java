package vols;

import airCountry.Aeroport;

public class VolPassager extends Vol {
    public VolPassager(Aeroport depart, Aeroport destination)  {
        this.depart = depart;
        this.destination = destination;
    }
}
