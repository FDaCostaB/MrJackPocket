package Vue;

import Modele.CarteAlibi;
import Modele.Jeu;
import Modele.SuspectCouleur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.Iterator;

//TODO agrandir la taille des cartes et recupere la bonne main

public class MainGraphique extends JComponent {
    Graphics2D drawable;
    int largeur,hauteur,tailleC;
    Jeu jeu;
    Image suspectBla, suspectBle, suspectJau, suspectNoi, suspectOra, suspectRos, suspectVer, suspectVio, suspectGri;

    MainGraphique(Jeu j){
        jeu=j;
        suspectBle = chargeImage("Suspect-bleuB");
        suspectGri = chargeImage("Suspect-grisB");
        suspectNoi = chargeImage("Suspect-noirB");
        suspectRos = chargeImage("Suspect-roseB");
        suspectVer = chargeImage("Suspect-vertB");
        suspectBla = chargeImage("Suspect-blancB");
        suspectJau = chargeImage("Suspect-jauneB");
        suspectOra = chargeImage("Suspect-orangeB");
        suspectVio = chargeImage("Suspect-violetB");
        /*List<CarteAlibi> mainFictif = new ArrayList<CarteAlibi>();
        mainFictif.add( new CarteAlibi( new Suspect( SuspectNom.JEREMY_BERT,null ) ) );
        mainFictif.add( new CarteAlibi( new Suspect( SuspectNom.MADAME,null ) ) );
        mainFictif.add( new CarteAlibi( new Suspect( SuspectNom.JOHN_PIZER,null ) ) );
        mainFictif.add( new CarteAlibi( new Suspect( SuspectNom.INSPECTOR_LESTRADE,null ) ) );
        mainFictif.add( new CarteAlibi( new Suspect( SuspectNom.SERGENT_GOODLEY,null ) ) );
        jeu.plateau().enqueteur.setCardList(mainFictif);*/
    }

    private Image chargeImage(String nom) {
        Image img = null;
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream( "PNG/" + nom + ".png" );
        try {
        // Chargement d'une image
            img = ImageIO.read (in);
        } catch ( Exception e ) {
            System.err.println("Pb image : " + nom);
            System .exit(1);
        }
        return img;
    }

    public void dessinerCarte(SuspectCouleur couleur, int x, int y){
        switch (couleur){
            case BLEU:
                drawable.drawImage(suspectBle, x,y,tailleC-y,tailleC-y,null);
                break;
            case GRIS:
                drawable.drawImage(suspectGri, x,y,tailleC-y,tailleC-y,null);
                break;
            case NOIR:
                drawable.drawImage(suspectNoi, x,y,tailleC-y,tailleC-y,null);
                break;
            case ROSE:
                drawable.drawImage(suspectRos, x,y,tailleC-y,tailleC-y,null);
                break;
            case VERT:
                drawable.drawImage(suspectVer, x,y,tailleC-y,tailleC-y,null);
                break;
            case BLANC:
                drawable.drawImage(suspectBla, x,y,tailleC-y,tailleC-y,null);
                break;
            case JAUNE:
                drawable.drawImage(suspectJau, x,y,tailleC-y,tailleC-y,null);
                break;
            case ORANGE:
                drawable.drawImage(suspectOra, x,y,tailleC-y,tailleC-y,null);
                break;
            case VIOLET:
                drawable.drawImage(suspectVio, x,y,tailleC-y,tailleC-y,null);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + jeu.plateau().idJack);
        }
    }
    public void dessinerMain(){
        Iterator<CarteAlibi> main = jeu.plateau().enqueteur.getCardList().iterator();
        int i=0;
        CarteAlibi actuel;
        while(main.hasNext()){
            actuel = main.next();
            dessinerCarte(actuel.getSuspect().getCouleur(),i* (int) ((tailleC-45)*0.85),45);
            i++;
        }
        drawable.setFont(new Font("default", Font.BOLD, 25));
        drawable.drawString("Main de l'enquêteur :",10,25);
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
        drawable.clearRect(0, 0, largeur, hauteur);

        //Calcul de la taille d'une case
        int hCase=hauteur;
        int lCase=largeur;
        tailleC=Math.min(hCase,lCase);

        dessinerMain();

    }
}
