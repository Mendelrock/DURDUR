package velib;

public class V�lo {
    private String nom;
    private boolean estLou� = false;

    public V�lo(String nom) {
        this.nom = nom;
    }

    public void louer() {
        assert !estLou� : "Le v�lo est d�j� lou�";
        this.estLou� = true;
    }

    public boolean estLoue() {
        return this.estLou�;
    }
    
    @Override
    
    public String toString(){
    	return "";
    }
}
