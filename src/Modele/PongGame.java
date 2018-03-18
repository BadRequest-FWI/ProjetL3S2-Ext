package Modele;

import Vue.PongVue;

public class PongGame {
    /**
     * Modele du jeu de pong
     */

    public static int width = 1280, height = 700;
    private PongVue vue;

    public PongGame(PongVue view){
        this.vue = view;
    }

    //////////////////////lancement du jeu joueur vs joueur///////////////////
    public void start(boolean ia){
        vue.initPlayer(this,ia);
    }

    ///////////////////////lancement du jeu joueur vs ia/////////////////////
    public void start(boolean ia,int level){
        vue.initPlayer(this,ia,level);
    }

    //////////////mise a jour dynamique de la balle (deplacement, collision) pour le controleur//////////////
    public void BallUpdate(){
        vue.getBalle().balleUpdate(vue.getPlayer1(),vue.getPlayer2());
    }

    ////////////mise a jour dynamique du joueur (deplacement) pour le controleur/////////////////
    public void playerUpdate(boolean player,int action){
        if(player) {
            switch (action) {
                case 0:
                    vue.getPlayer1().nextCouleur();
                    break;
                case 1:
                    vue.getPlayer1().deplace(true);
                    break;
                case 2:
                    vue.getPlayer1().deplace(false);
                    break;
                default:
                    break;
            }
        }else{
            switch (action){
                case 0:
                    vue.getPlayer2().nextCouleur();
                    break;
                case 1:
                    vue.getPlayer2().deplace(true);
                    break;
                case 2:
                    vue.getPlayer2().deplace(false);
                    break;
                default:
                    break;
            }
        }
    }

    public PongVue getVue() {
        return vue;
    }
}
