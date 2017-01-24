package exo1client;

import voiture.Voiture;

public class TestMoteur implements Runnable {

	public TestMoteur(Voiture voiture) {
		this.voiture = voiture;
	}

	private Voiture voiture;
	
	@Override
	public void run() {

	    int cptAcc = 0; int cptFrein = 0;
	    voiture.setVitesse(0);
	    while (voiture.getVitesse() < voiture.getVitesseMaximale()) {
	      voiture.accélérer();
	      System.out.println(voiture+ " accelère");
	      double accidentTestFrein = Math.random();
	      if (accidentTestFrein < 0.05) 
	    	  throw new RuntimeException("Plantage lors du test de la voiture "+this.voiture);
//	     try {
//			Thread.sleep(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		++cptAcc;
	    }
	    while (voiture.getVitesse() > 0){
	      voiture.freiner();
	      System.out.print(voiture);
	      System.out.println(" freine");
		      ++cptFrein;
	    }
	    
	    System.out.println(voiture + " nb accélarations -> " + cptAcc);
	    System.out.println(voiture + " nb de freinages -> " + cptFrein);
	  

	}
	
	public void lancer() {
		new Thread(this).start();
	}

}
