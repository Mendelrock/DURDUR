package etats;

public interface ICommande {

	int getNuméro();

	ICommande payer();

	ICommande livrer();

	ICommande rembourser();

	String getEtat();

}