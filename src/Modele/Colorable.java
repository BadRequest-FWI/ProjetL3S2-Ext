package Modele;

import java.awt.*;
import java.util.Random;

abstract class Colorable {
    /**
     * Gestion des objet colorable (joueur et balle)
     */

    protected int couleur = 0;
    private Random couleurRandom = new Random();

    ////////////////passage a la couleur suivante///////////////////
    public void nextCouleur(){
        if (couleur ==4){
            couleur = 1;
        }else{
            couleur++;
        }
    }

    //////////////////gestion des collisions en fonction des couleurs///////////////
    public boolean colorContact(Colorable c){
        if (this.couleur == 0 || c.couleur == 0 || this.couleur == c.couleur){
            return true;
        }else{
            return false;
        }
    }

    //////////////atribution d'une couleur aleatoire/////////////////////////////
    public void couleurRandom(){
        this.couleur = 1 + couleurRandom.nextInt(4);
    }

    //////////////remise a zero de la couleur (blanc)/////////////////////////////
    public void resetCouleur(){this.couleur = 0;}

    /////////gestion de l'affichage de la couleur//////////////////////////////////
    public void render(Graphics g) {
        switch (couleur){
            case 1:
                g.setColor(Color.RED);
                break;
            case 2 :
                g.setColor(Color.BLUE);
                break;
            case 3 :
                g.setColor(Color.MAGENTA);
                break;
            case 4 :
                g.setColor(Color.YELLOW);
                break;
            case 0 :
                g.setColor(Color.WHITE);
                break;
            default:
                g.setColor(Color.WHITE);
                break;
        }
    }
}
