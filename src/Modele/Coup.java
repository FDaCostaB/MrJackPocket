package Modele;

import java.awt.*;
/*
**Coup**:
Type Action
Methode qui execute le coup
 */
public class Coup extends Commande{
	
	private Actions action;
    private Point position1;
    private Point position2;
	private Plateau plateau;
    private int orientation1;
    private int orientation2;
    private int deplacement =0;

   
    //entier : 1 ou 2
	
    //CAS Où ACTION EQUIVEAUT à ECHANGE OU ROTATION
	//TODO Modify constructor
	public Coup(Plateau plateau, Actions action,Point position1,Point position2,int orientation1,int orientation2,int deplacement) {

		this.plateau = plateau;
		this.action = action;
		this.position1 = position1;
		this.position2 = position2;
		this.orientation1 = orientation1;
		this.orientation2 = orientation2;
	    this.deplacement=deplacement;
	
	}

	public void rotation(int orientation,Point position) {

		plateau.grille[position.y][ position.x].setOrientation(orientation);

	}

	public void echanger(int orientation1,int orientation2, Point position1,Point position2) {
		CarteRue tmp = plateau.grille[position1.y][position1.x];
		plateau.grille[position1.y][position1.x] =plateau.grille[position2.y][position2.x];
		plateau.grille[position1.y][position1.x].setPositionEnqueteur(tmp.getPositionEnqueteur());
		tmp.setPositionEnqueteur(plateau.grille[position2.y][position2.x].getPositionEnqueteur());
		plateau.grille[position1.y][position1.x].setOrientation(orientation2);
		plateau.grille[position2.y][position2.x] = tmp;
		plateau.grille[position2.y][position2.x].setOrientation(orientation1);

	}
   
	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public Point getPosition1() {
		return position1;
	}

	public void setPosition1(Point position1) {
		this.position1 = position1;
	}

	public Point getPosition2() {
		return position2;
	}

	public void setPositionQuartier2(Point position2) {
		this.position2 = position2;
	}

	public int getOrientation1() {
		return orientation1;
	}

	public void setOrientation1(int orientation) {
		this.orientation1 = orientation;
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}


	public int getOrientation2() {
		return orientation2;
	}


	public void setOrientation2(int orientation2) {
		this.orientation2 = orientation2;
	}


	@Override
	void execute() {
		switch(action){
			case DEPLACER_JOKER:
				break;
			case DEPLACER_TOBBY:
				break;
			case DEPLACER_SHERLOCK:
				break;
			case DEPLACER_WATSON:
				break;
			case INNOCENTER_CARD:
				break;
			case ECHANGER_DISTRICT:
				break;
			case ROTATION_DISTRICT:
				break;
			default:
				throw new IllegalStateException("Unexecpted action");
		}

	}

	@Override
	void desexecute() {
	}
}
