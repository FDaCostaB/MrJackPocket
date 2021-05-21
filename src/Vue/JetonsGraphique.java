package Vue;

import Global.Configuration;
import Modele.Jeu;

import javax.swing.*;
import java.awt.*;

public class JetonsGraphique extends JComponent implements ElementPlateauG {
    Graphics2D drawable;
    int largeur,hauteur,tailleC,offsetX,offsetY;
    Jeu jeu;
    Image jeton1A , jeton1B , jeton2A , jeton2B, jeton3A , jeton3B, jeton4A , jeton4B;

    JetonsGraphique(Jeu j){
        jeu=j;
        jeton1A = Configuration.chargeImage("Jeton-1-A");
        jeton1B = Configuration.chargeImage("Jeton-1-B");
        jeton2A = Configuration.chargeImage("Jeton-2-A");
        jeton2B = Configuration.chargeImage("Jeton-2-B");
        jeton3A = Configuration.chargeImage("Jeton-3-A");
        jeton3B = Configuration.chargeImage("Jeton-3-B");
        jeton4A = Configuration.chargeImage("Jeton-4-A");
        jeton4B = Configuration.chargeImage("Jeton-4-B");
        offsetX = 20;
        offsetY = 30;
    }

    //TODO charger la bonne face
    public void dessinerJetons(){
        Image jeton1, jeton2, jeton3, jeton4;
        //TODO choisir la bonne face des jetons
        jeton1 = jeton1A;
        jeton2 = jeton2A;
        jeton3 = jeton3A;
        jeton4 = jeton4B;
        drawable.setFont(new Font("default", Font.BOLD, 25));
        drawable.drawString("Jetons :",(int) (largeur*0.5)-60,25);
        drawable.setFont(new Font("default", Font.PLAIN, 12));
        drawable.drawImage(jeton1, 0, offsetY, tailleC, tailleC, null);
        drawable.drawImage(jeton2, tailleC+offsetX, offsetY, tailleC, tailleC, null);
        drawable.drawImage(jeton3, 0, tailleC+2*offsetY, tailleC, tailleC, null);
        drawable.drawImage(jeton4, tailleC+offsetX, tailleC+2*offsetY, tailleC, tailleC, null);
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
        drawable.clearRect(0, 0, largeur, hauteur);

        //Calcul de la taille d'une case
        int hCase=(hauteur-2*offsetY)/2;
        int lCase=(largeur-2*offsetX)/2;
        tailleC=Math.min(hCase,lCase);

        dessinerJetons();

    }

    @Override
    public int getTailleCase() {
        return tailleC;
    }

    @Override
    public int getType() {
        return 2; //2 : Jetons
    }

    @Override
    public int getOffsetX() {
        return offsetX;
    }

    @Override
    public int getOffsetY() {
        return offsetY;
    }
}
