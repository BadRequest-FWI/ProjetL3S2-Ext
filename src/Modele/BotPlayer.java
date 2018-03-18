package Modele;

import java.util.Random;

public class BotPlayer extends PongPlayer {
    /**
     * Modele de l'ia
     */

    //TODO affiner la difficulte du bot

    private int LevelError = 0; // indice du pourcentage d'erreur de l'ia
    private PongGame pongGame;
    private Random color = new Random();


    public BotPlayer(PongGame pongGame, int num) {
        super(num);
        this.pongGame = pongGame;
    }

    public BotPlayer(PongGame pongGame, int num, int LevelError) {
        super(num);
        this.pongGame = pongGame;
        this.LevelError = LevelError;
    }

    ////////////////////mise a jour dynamique de l'ia////////////////
    public void update(){

        /**generation d'erreur aleatiore**/
        if (color.nextInt(101) >= LevelError){
            /**Champ d'action de l'ia**/
            if (pongGame.getVue().getBalle().getxPos() >= PongGame.width / 2 + PongGame.width / 4) {

                /**generation d'erreur aleatiore**/
                if (color.nextInt(101) >= LevelError){
                    while (!colorContact(pongGame.getVue().getBalle())) {
                        this.nextCouleur();
                    }
                }

                /**controle le la position par rapport a la balle et deplacement en consequence**/
                if (this.yPos + this.height / 2 < pongGame.getVue().getBalle().getyPos()) {
                    this.deplace(false);
                }

                if (this.yPos + this.height / 2 > pongGame.getVue().getBalle().getyPos()) {
                    this.deplace(true);
                }
            }
        }
    }
}
