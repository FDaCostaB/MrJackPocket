package Modele;
/*
**Carte Alibi**:
Nombre de sabliers (0, 1, 2)
Nom Personnage suspect
 */
public class CarteAlibi {
	
		private SuspectNom suspect;
		private int sablier;

		// Getters and Setters
		public SuspectNom getSuspect() {
			return suspect;
		}

		public void setSuspect(SuspectNom suspect) {
			this.suspect = suspect;
		}

		public int getSablier() {
			return sablier;
		}

		public void setSablier(int sablier) {
			this.sablier = sablier;
		}

		// tester toString
		public String toString() {
			return suspect.name();
		}

	
}