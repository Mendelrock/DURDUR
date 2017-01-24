package velib;

import java.util.ArrayList;
import java.util.List;

public class Velib {
    private List<V�lo> v�los = new ArrayList<>();

    void ajouter(V�lo v) {
        v�los.add(v);
    }

    public static void main(String[] args) {
	    Velib agence = new Velib();
        agence.ajouter(new V�lo("v�lo 1"));
        agence.ajouter(new V�lo("v�lo 2"));

        V�lo libre = null;
        while ((libre = agence.ilResteDesVelosLibres()) !=null) {
            System.out.println(libre);
            libre.louer();
        }
    }

    private V�lo ilResteDesVelosLibres() {
        for(V�lo v: v�los)
            if ( !v.estLoue())
                return v;
        return null;
    }
}
