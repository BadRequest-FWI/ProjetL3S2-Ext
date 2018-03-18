package Vue;

import Modele.Balle;
import Modele.BotPlayer;
import Modele.PongGame;
import Modele.PongPlayer;
import javax.swing.*;
import java.awt.*;

public class PongVue extends JPanel {
    /**
     * Affiche la fenêtre du jeu
     */

    private static final long serialVersionUID = 1L;
    public static int width = 1280, height = 700;
    private PongPlayer player1;
    private PongPlayer player2;
    private Balle balle;

    public PongVue(){

    }

    ////////////////gestion de l'affichage dynamique///////////
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        render((Graphics2D) g);
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.WHITE);
        g.setFont(new Font ("Tahoma", Font.PLAIN,40));
        g.drawString(String.valueOf(player1.score),width/2-75,50);
        g.drawString(String.valueOf(player2.score),width/2+75,50);

        g.setStroke(new BasicStroke(5));
        g.drawLine(width/2,0,width/2,height);

        player1.render(g);
        player2.render(g);
        balle.render(g);
    }

    ///////////getters & setters//////////////////
    public PongPlayer getPlayer1() {
        return player1;
    }

    public PongPlayer getPlayer2() {
        return player2;
    }

    public Balle getBalle() {
        return balle;
    }


    //////////initialisation des joueurs et de la balle sur le plateau///////////
    public void initPlayer(PongGame pongGame, boolean ia){
        player1 = new PongPlayer(1);
        if (!ia) {
            player2 = new PongPlayer(2);
        }else{
            player2 = new BotPlayer(pongGame,2);
        }
        balle = new Balle();
    }

    public void initPlayer(PongGame pongGame, boolean ia, int level){
        player1 = new PongPlayer(1);
        if (!ia) {
            player2 = new PongPlayer(2);
        }else{
            player2 = new BotPlayer(pongGame,2,level);
        }
        balle = new Balle();
    }

}
