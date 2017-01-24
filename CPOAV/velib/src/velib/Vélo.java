package velib;

public class Vélo {
    private String nom;
    private boolean estLoué = false;

    public Vélo(String nom) {
        this.nom = nom;
    }

    public void louer() {
        assert !estLoué : "Le vélo est déjà  loué";
        this.estLoué = true;
    }

    public boolean estLoue() {
        return this.estLoué;
    }
    
    @Override
    
    public String toString(){
    	return "";
    }
}
