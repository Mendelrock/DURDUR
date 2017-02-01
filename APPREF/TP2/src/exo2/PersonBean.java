package exo2;

import java.io.Serializable;

public class PersonBean implements Serializable {
    private String name;
    private boolean deceased;

    // Constructeur par défaut (Ne prenant pas d'arguments).
    public PersonBean() {
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /* Différentes sémantiques pour les booléens. (get vs is)
       Ici nous optons pour un préfixe is. */
    public boolean getDeceased() {
        return this.deceased;
    }
    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }
}