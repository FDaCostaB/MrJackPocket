package Modele;

/*
**Carte Rue: **
Orientation: 4 bits int (Nord, Sud, Est, Ouest)
Position Inspecteur (1 = Ouest, Est = 2, Sud = 4, Nord = 8, 0 si pas sur carte)
Personnage suspect
Methode qui cache le personnage
Boolean dejaRetourne
*/

import java.awt.*;
import java.util.Random;

public class CarteRue {
    public int orientation; //4 bits de poids faible indiquent les orientations des rues (N,S,E,O) - 3/4 activés (si 1110 alors Mur|-)
    public Point position;
    public int positionEnqueteur;
    public Enqueteur enqueteur;
    public Suspect suspect;

    //Orientations:
    //TODO NSEO existe c'est le verso de la carte suspect GRIS
    public final static int NSEO = 15; //1111(Nord, Sud, Est,Ouest)

    public final static int NSE = 14; //1110(Nord, Sud, Est)
    public final static int NSO = 13; //1101 (Nord, Sud, Ouest)
    public final static int NEO = 11; //1011 (Nord, Est, Ouest)
    public final static int SEO = 7; //0111 (Sud, Est, Ouest)

    //Integrable sur 4 bits dans orientations ?
    //positionEnqueteur:
    public final static int ABSENT = 0;
    public final static int OUEST = 1;
    public final static int EST = 2;
    public final static int SUD = 4;
    public final static int NORD = 8;

    public CarteRue(Point position, Suspect suspect){
        Random rand = new Random();
        //On choisi une orientation des orientations possibles
        orientation = Plateau.orientationsRues().get(rand.nextInt(Plateau.orientationsRues().size()));
        positionEnqueteur = 0;
        enqueteur = new Enqueteur();
        this.position = position;
        this.suspect = suspect;
        this.suspect.setPosition(this.position);
    }
    
    

	public int getOrientation() {
		return orientation;
	}

	void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getPositionEnqueteur() {
		return positionEnqueteur;
	}

	void setPositionEnqueteur(int positionEnqueteur) {
		this.positionEnqueteur = positionEnqueteur;
	}

	public Enqueteur getEnqueteur() {
		return enqueteur;
	}

	public void setEnqueteur(Enqueteur enqueteur) {
		this.enqueteur = enqueteur;
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public Suspect getSuspect() {
		return suspect;
	}

	public void setSuspect(Suspect suspect) {
		this.suspect = suspect;
	}

    //TODO
    public int getPosEnqueteur(){
        return ABSENT;
    }

}
