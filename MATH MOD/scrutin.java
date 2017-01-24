public class scrutin{
	private String[] candidats;
	private int nbCandidats;
	
	public class electeurs{
		private int choix;
		private int[] preferences;
		
		public electeurs(int nbCandidats){
			this.choix=(int)Math.random()*(nbCandidats+1);
			this.preferences= new int[nbCandidats];
			for(int i=0;i<nbCandidats;++i)
				preferences[i]=(int)Math.random()*nbCandidats;
			preference[choix]=nbCandidats;
		}
		
		public int getChoix(){
			return this.choix;
		}
		
		public int getPreference(int candidat){
			return this.preferences[candidat];
		}
		
		public int getCote(int candidat){
			return Math.abs(candidat-this.choix)-getPreference(candidat);
		}
		
	}
	
	private ArrayList<electeurs> resultats;
	
	public void 
	
}