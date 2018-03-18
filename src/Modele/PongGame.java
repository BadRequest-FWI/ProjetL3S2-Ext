package Modele;

import Vue.PongVue;

public class PongGame {

    public static int width = 1280, height = 700;
    private PongVue vue;

    public PongGame(PongVue view){
        this.vue = view;
    }



    public void start(boolean ia){
        vue.initPlayer(this,ia);
    }

    public void start(boolean ia,int level){
        vue.initPlayer(this,ia,level);
    }


    public void BallUpdate(){
        vue.getBalle().balleUpdate(vue.getPlayer1(),vue.getPlayer2());
    }

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
