import java.util.ArrayList;

public class Uninominal {
	ArrayList<String> Candidats = new ArrayList<String>();
	ArrayList<Integer> Votes = new ArrayList<Integer>();

	public Uninominal(){
		Candidats.add("Sarkozy");
		Candidats.add("Hollande");
		Candidats.add("Lepen");
		Candidats.add("Melenchon");
		Votes.add(0,0);
		Votes.add(1,0);
		Votes.add(2,0);
		Votes.add(3,0);
	}
	
	public void Voter(String s){
		switch(s) {
		case "Sarkozy":
			Votes.set(0,( Votes.get(0))+1);
			System.out.println(Votes.get(0));

			break;
		case "Hollande":
			Votes.set(1,( Votes.get(1))+1);

			break;
		case "Lepen":
			Votes.set(2,( Votes.get(2))+1);
			
			break;
		case "Melenchon":
			Votes.set(3,( Votes.get(3))+1);
			
			break;
		}
		Gagnant2Tour(s);
		System.out.println("");
	}

	public int GagnantMajoritaire(String s){
		int max = 0; 
		int nbVotesGagnant = 0;
		for(int i=this.Votes.size()-1; i>=0; i--){
			if(i != 0){
				if(this.Votes.get(i) > this.Votes.get(i-1) ){
					max = i ;
				}
			}
			nbVotesGagnant = this.Votes.get(i);
		}
		for(int i=this.Votes.size()-1; i>=0; i--){
			if(this.Votes.get(i)==this.Votes.get(max) && i != max){
				int max2 = i;
				System.out.println("ex-aequo = " + this.Candidats.get(max2));
			}
		}
		System.out.println("Gagnant est " + this.Candidats.get(max) + " avec " + nbVotesGagnant + " voix" );
		return nbVotesGagnant;
	}
	
	public void Gagnant2Tour(String s){
		int tailleVotes = 0;
		for(int i = 0; i<this.Votes.size(); i++){
			tailleVotes += this.Votes.get(i);
		}
		if(GagnantMajoritaire(s) < tailleVotes/2){
			
			System.out.println("deuxieme tour");
		}
		else System.out.println("pas de deuxieme tour");
		
	}
}
