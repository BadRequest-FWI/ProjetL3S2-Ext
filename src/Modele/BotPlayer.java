package Modele;

import java.util.Random;

public class BotPlayer extends PongPlayer {

    //TODO affiner la difficulte du bot

    private int LevelDelay = 0;
    protected int nbMovement = 0;
    private PongGame pongGame;
    private Random color = new Random();


    public BotPlayer(PongGame pongGame, int num) {
        super(num);
        this.pongGame = pongGame;
    }

    public BotPlayer(PongGame pongGame, int num, int LevelDelay) {
        super(num);
        this.pongGame = pongGame;
        this.LevelDelay = LevelDelay;
    }

    public void update(){

        if (color.nextInt(101) >= LevelDelay){
            if (pongGame.getVue().getBalle().getxPos() >= PongGame.width / 2 + PongGame.width / 4) {

                if (color.nextInt(101) >= LevelDelay){
                    while (!colorContact(pongGame.getVue().getBalle())) {
                        this.nextCouleur();
                    }
                }

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
