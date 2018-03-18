package Modele;

import java.awt.*;

public class PongPlayer extends Colorable {
    /**
     * Modele du joueur
     */

    protected int playerNumber;
    protected int xPos, yPos, width = 50, height = 250;
    public int score;
    private int vitesse = 60;

    public PongPlayer(int num) {
        this.playerNumber = num;

        if (playerNumber == 1){
            this.xPos = 0;
        }

        if (playerNumber == 2){
            this.xPos = PongGame.width - width;
        }
        this.yPos = PongGame.height / 2 - this.height /2;
    }

    /////////////////gestion du deplacement du joueur////////////////////
    public void deplace(boolean up) {

        if (up){
            if (yPos - vitesse > 0) {
                yPos -= vitesse;
            }else{
                yPos = 0;
            }
        }else if (yPos + height + vitesse < PongGame.height){
            yPos += vitesse;
        }else{
            yPos = PongGame.height - height;
        }
    }

    public void render(Graphics g) {
        super.render(g);
        g.fillRect(xPos, yPos, width, height);
    }

    ////////////////////Fontion servant pour BotPlayer///////////////
    public void update(){

    }
}
