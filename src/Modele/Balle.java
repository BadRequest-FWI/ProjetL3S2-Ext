package Modele;

import java.awt.*;
import java.util.Random;

public class Balle extends Colorable{

    private int xPos, yPos, width = 25, height = 25;
    private int mouvementX, mouvementY;
    int vitesse = 6;
    private Random mouvementRandom;
    private boolean first = true;



    public Balle() {
        mouvementRandom = new Random();
        lancer();
    }

    public void balleUpdate(PongPlayer j1, PongPlayer j2){

        this.xPos += mouvementX * vitesse;
        this.yPos += mouvementY * vitesse;

        if (this.yPos + height - mouvementY > PongGame.height || this.yPos + mouvementY < 0){
            if (this.mouvementY < 0){
                this.yPos = 0;
                this.mouvementY = mouvementRandom.nextInt(4);

                if (mouvementY == 0){
                    mouvementY = 1;
                }
            }else{
                this.mouvementY = -mouvementRandom.nextInt(4);
                this.yPos = PongGame.height - height;

                if (mouvementY == 0){
                    mouvementY = -1;
                }
            }
        }

        if (collision(j1) == 1){
            if (first) {
                first=false;
                randomPlayer(j1,j2);
            }
            this.mouvementX = 1;
            this.mouvementY = -2 + mouvementRandom.nextInt(4);

            if (mouvementY == 0) {
                mouvementY = 1;
            }
            this.couleurRandom();
        }else if (collision(j2) == 1){
            if (first) {
                first=false;
                randomPlayer(j1,j2);
            }
            this.mouvementX = -1;
            this.mouvementY = -2 + mouvementRandom.nextInt(4);

            if (mouvementY == 0){
                mouvementY = 1;
            }
            this.couleurRandom();
        }

        if (collision(j1) == 2) {
            resetPlayer(j1,j2);
            j2.score++;
            lancer();
        }else if (collision(j2) == 2){
            resetPlayer(j1,j2);
            j1.score++;
            lancer();
        }

    }

    private void lancer() {
        first = true;
        this.couleurRandom();
        this.xPos = PongGame.width / 2 - this.width / 2;
        this.yPos = PongGame.height / 2 - this.height / 2;

        this.mouvementY = -2 + mouvementRandom.nextInt(4);

        if (mouvementY == 0) mouvementY = 1;


        if (mouvementRandom.nextBoolean()){
            mouvementX = 1;
        }else{
            mouvementX = -1;
        }
    }

    public void resetPlayer(PongPlayer j1, PongPlayer j2){
        j1.resetCouleur();
        j2.resetCouleur();
    }

    public void randomPlayer (PongPlayer j1, PongPlayer j2){
        j1.couleurRandom();
        j2.couleurRandom();
    }

    public int collision (PongPlayer p){

        if (this.xPos < p.xPos + p.width && this.xPos + width > p.xPos && this.yPos < p.yPos + p.height && this.yPos + height > p.yPos && this.colorContact(p)){
            return 1;
        } else if ((p.xPos > xPos && p.playerNumber == 1) || (p.xPos < xPos - width && p.playerNumber == 2)){
            return 2;
        }
        return 0;
    }

    public int getyPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void render (Graphics g){
        super.render(g);
        g.fillOval(xPos, yPos, width, height);
    }
}
