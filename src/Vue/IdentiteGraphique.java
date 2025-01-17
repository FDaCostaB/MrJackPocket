package Vue;

import Global.Configuration;
import Modele.Jeu;
import Modele.Joueur;

import javax.swing.*;
import java.awt.*;

public class IdentiteGraphique extends JComponent {
    Graphics2D drawable;
    int largeur,hauteur,tailleC;
    Jeu jeu;
    Image jack,sherlock, pioche, sablier, mystere;
    boolean estCache;

    IdentiteGraphique(Jeu j){
        jeu=j;
        sherlock = Configuration.chargeImage("Sherlock");
        pioche = Configuration.chargeImage("PiocheA");
        sablier = Configuration.chargeImage("Sablier");
        mystere = Configuration.chargeImage("Suspect-inconnu");
        estCache = true;
    }

    //Pre-Condition : Jeu initialisé
    //Post-Condition : dessine la zone donnant les informations sur les joueurs
    public void dessinerIdentite(){
        Image personnage;
        Joueur personnageCourant = jeu.plateau().joueurCourant;
        int taillePiocheAdv;
        int nbSabliers;
        if(!estCache || jeu.plateau().finJeu(false,false)) nbSabliers = jeu.plateau().jack.getSablier();
        else nbSabliers = jeu.plateau().jack.getSablierVisibles();
        boolean isJack = personnageCourant.isJack();

        switch (jeu.plateau().idJack){
            case BLEU:
                jack = Configuration.chargeImage("Suspect-bleuB");
                break;
            case GRIS:
                jack = Configuration.chargeImage("Suspect-marronB");
                break;
            case NOIR:
                jack = Configuration.chargeImage("Suspect-noirB");
                break;
            case ROSE:
                jack = Configuration.chargeImage("Suspect-roseB");
                break;
            case VERT:
                jack = Configuration.chargeImage("Suspect-vertB");
                break;
            case BLANC:
                jack = Configuration.chargeImage("Suspect-blancB");
                break;
            case JAUNE:
                jack = Configuration.chargeImage("Suspect-jauneB");
                break;
            case ORANGE:
                jack = Configuration.chargeImage("Suspect-orangeB");
                break;
            case VIOLET:
                jack = Configuration.chargeImage("Suspect-violetB");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + jeu.plateau().idJack);
        }

        if(isJack){
            if(estCache) personnage = mystere;
            else personnage = jack;
            taillePiocheAdv = jeu.plateau().enqueteur.getCardList().size();
        } else {
            personnage = sherlock;
            taillePiocheAdv = jeu.plateau().jack.getCardList().size();
        }

        drawable.setFont(new Font("default", Font.BOLD, (int) (0.1*largeur)));
        drawable.setColor(Color.BLACK);
        drawable.drawString("Vous Incarnez :",30,(int) (0.2*tailleC));
        drawable.setFont(new Font("default", Font.ITALIC, 20));
        if(isJack) {
            drawable.drawString("Meurtrier",30,(int) (0.4*tailleC));
            drawable.setFont(new Font("default", Font.PLAIN, (int) (0.09*largeur)));
            drawable.drawImage(sablier,(int) (tailleC*0.3),(int) (1.5*tailleC), (int) (0.4*tailleC), (int) (0.4*tailleC), null);
            drawable.drawString(": "+nbSabliers+" / 6",(int) (tailleC*0.7),(int) (1.75*tailleC) );
        }
        else {
            drawable.drawString("Enquêteur",30,(int) (0.4*tailleC));
            drawable.setFont(new Font("default", Font.PLAIN, (int) (0.09*largeur)));
            drawable.drawImage(sablier,(int) (tailleC*0.3),(int) (3.2*tailleC), (int) (0.4*tailleC), (int) (0.4*tailleC), null);
            drawable.drawString(": "+nbSabliers+" / 6",(int) (tailleC*0.7),(int) (3.5*tailleC) );
        }
        drawable.setFont(new Font("default", Font.PLAIN,(int) (0.09*largeur)));
        drawable.drawImage(personnage, (int) (0.2*tailleC), (int) (0.5*tailleC), tailleC, tailleC, null);
        drawable.drawString("Adversaire",(int) (0.5*tailleC)-25,(int) (2.6*tailleC-20));
        drawable.drawImage(pioche,(int) (tailleC*0.3),(int) (2.7*tailleC), (int) (0.4*tailleC), (int) (0.4*tailleC), null);
        drawable.drawString(": "+taillePiocheAdv+" / 8",(int) (tailleC*0.7),(int) (2.95*tailleC) );
        drawable.setFont(new Font("default", Font.PLAIN, 16));

    }

    @Override
    public void paintComponent(Graphics g) {
        // Graphics 2D est le vrai type de l'objet passé en paramètre
        // Le cast permet d'avoir acces a un peu plus de primitives de dessin
        drawable = (Graphics2D) g;

        // On recupere quelques infos provenant de la partie JComponent
        largeur = getSize().width;
        hauteur = getSize().height;

        // On efface tout
        //drawable.clearRect(0, 0, largeur, hauteur);
        drawable.setBackground(new Color(255,255,255,0));
        g.setColor(new Color(255,255,255,0));
        g.fillRect(0, 0, getWidth(),getHeight());

        //Calcul de la taille d'une case
        int hCase=hauteur/4; //texte + Photo + Blanc + Adversaire
        int lCase=largeur;
        tailleC=Math.min(hCase,lCase);

        dessinerIdentite();

    }

    //Pre-Condition : Jeu initialisé
    //Post-Condition : change l'etat de estCache(identité de jack) et refraichit l'affichage
    public void swapImageJack() {
        estCache = !estCache;
        repaint();
    }

    //Pre-Condition : Jeu initialisé
    //Post-Condition : cache l'identité de jack et refraichit l'affichage
    public void resetIdJack() {
        estCache = true;
        repaint();
    }
}
