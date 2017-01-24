package velib;

import java.util.ArrayList;
import java.util.List;

public class Velib {
    private List<Vélo> vélos = new ArrayList<>();

    void ajouter(Vélo v) {
        vélos.add(v);
    }

    public static void main(String[] args) {
	    Velib agence = new Velib();
        agence.ajouter(new Vélo("vélo 1"));
        agence.ajouter(new Vélo("vélo 2"));

        Vélo libre = null;
        while ((libre = agence.ilResteDesVelosLibres()) !=null) {
            System.out.println(libre);
            libre.louer();
        }
    }

    private Vélo ilResteDesVelosLibres() {
        for(Vélo v: vélos)
            if ( !v.estLoue())
                return v;
        return null;
    }
}
