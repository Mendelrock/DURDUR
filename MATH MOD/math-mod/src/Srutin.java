import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Srutin {
	HashMap<String, Integer> CandidatVal= new HashMap<String, Integer>();
	ArrayList<Integer> Votes = new ArrayList<Integer>();

	public Srutin(){
		CandidatVal.put("Sarkozy", 0);
		CandidatVal.put("Hollande", 0);
		CandidatVal.put("Lepen", 0);
		CandidatVal.put("Melenchon", 0);
		CandidatVal.put("Bayrou", 0);
	}
	
	public void Voter(String s){
		CandidatVal.put(s, CandidatVal.get(s)+1);
		System.out.println("");
	}

	public int GagnantMajoritaire(String s)throws Exception{
		String max; 
		int nbVotesGagnant = 0;
		CandidatVal.forEach((k,v) ->{
			if(nbVotesGagnant==0) max = k;
			else if(v>CandidatVal.get(max)) max = k;
			nbVotesGagnant+=v;
		});	
		/*CandidatVal.forEach((k,v) ->{
			if(v==CandidatVal.get(max)&&(!max.equals(k))) throw(new Exception(""));
		});*/
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
