package etats;

public interface ICommande {

	int getNum�ro();

	ICommande payer();

	ICommande livrer();

	ICommande rembourser();

	String getEtat();

}