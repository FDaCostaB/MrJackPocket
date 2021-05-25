package Controle;

import Vue.InterfaceGraphique;

public interface CollecteurEvenements {
		//void clicSouris(int l, int c);
		void commandeDistrict(int l, int c);
		boolean commandeMenu(String c);
		boolean commandeJeu(String c);
		void fixerInterfaceUtilisateur(InterfaceGraphique i);
		void fixerIA(String com);
		boolean iaActive();
		void activeIA(int state);
		void annuler();
		void refaire();
	}
