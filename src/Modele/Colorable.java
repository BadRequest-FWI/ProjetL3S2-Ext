package Modele;


import java.awt.*;
import java.util.Random;

abstract class Colorable {

    protected int couleur = 0;

    private Random couleurRandom = new Random();

    public void nextCouleur(){
        if (couleur ==4){
            couleur = 1;
        }else{
            couleur++;
        }
    }


    public boolean colorContact(Colorable c){
        if (this.couleur == 0 || c.couleur == 0 || this.couleur == c.couleur){
            return true;
        }else{
            return false;
        }
    }
    public void couleurRandom(){
        this.couleur = 1 + couleurRandom.nextInt(4);
    }

    public void resetCouleur(){this.couleur = 0;}

    public void render(Graphics g) {
        switch (couleur){
            case 1:
                g.setColor(Color.RED);
                break;
            case 2 :
                g.setColor(Color.BLUE);
                break;
            case 3 :
                g.setColor(Color.CYAN);
                break;
            case 4 :
                g.setColor(Color.yellow);
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
