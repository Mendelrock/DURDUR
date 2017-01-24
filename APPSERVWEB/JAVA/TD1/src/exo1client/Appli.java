// Appli.java
package exo1client;

import voiture.Voiture;
import voiture.Usine;
import static voiture.Usine.Version;

public class Appli {
  public static void main(String[] args) {
    Voiture[] tab = { 
        Usine.construit("607", Version.STANDARD),
        Usine.construit("ClioSport", Version.SUICIDAIRE),
        Usine.construit("Saxo", Version.POPULAIRE),
        Usine.construit("C4", Version.STANDARD),
    };
    for (Voiture v : tab) {
      new TestMoteur(v).lancer();
    }
  }
}
