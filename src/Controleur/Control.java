package Controleur;

import Modele.PongGame;
import Vue.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements ActionListener, KeyListener {
    /*
     * Controleur principale de l'appli
     * Fait le lien entre l'affichage (package vue) et les données (package modele)
     */
    private Window window;
    private AcceuilVue acceuilVue;
    private GameVue gameVue;
    private AideVue aideVue;
    private PongVue pongVue;
    private EndGameVue endGameVue;
    private LevelBotVue levelBotVue;
    ////////////////////////////////////////////////////////
    private PongGame pongGameModel;
    ///////////////////////////////////////////////////////
    private boolean ingame = false;
    private boolean ia;



    public Control(){
        initButton();
        initVues();
        acceuilVue = new AcceuilVue();
    }

    public void initVues() {
        gameVue = new GameVue();
        aideVue = new AideVue();
        levelBotVue = new LevelBotVue();

    }
    ///////////mise des differents bouton sur ecoute par la controleur///////////
    public void initButton() {
        //AcceuilVue
        AcceuilVue.aide.addActionListener(this);
        AcceuilVue.jouer.addActionListener(this);
        AcceuilVue.quit.addActionListener(this);
        //GameVue
        GameVue.pve.addActionListener(this);
        GameVue.pvp.addActionListener(this);
        GameVue.ret.addActionListener(this);
        //AideVue
        AideVue.ret.addActionListener(this);
        AideVue.jouer.addActionListener(this);
        //EndGameVue
        EndGameVue.jouer.addActionListener(this);
        EndGameVue.quit.addActionListener(this);
        EndGameVue.ret.addActionListener(this);
        //LevelBotVue
        LevelBotVue.easy.addActionListener(this);
        LevelBotVue.medium.addActionListener(this);
        LevelBotVue.hard.addActionListener(this );
        LevelBotVue.ret.addActionListener(this);
    }
    ///////Lancement d'une partie joueur contre joueur////////////
    public void startGame(boolean ia){
        pongVue = new PongVue();
        pongGameModel = new PongGame(pongVue);
        pongGameModel.start(ia);
        ingame = true;
        window.update(pongVue);
        pongVue.addKeyListener(this);
        pongVue.setFocusable(true);
        pongVue.requestFocusInWindow();
        window.start();
    }
    //////////Lancement d'une partie joueur contre ia///////////
    public void startGame(boolean ia,int level){
        pongVue = new PongVue();
        pongGameModel = new PongGame(pongVue);
        pongGameModel.start(ia,level);
        ingame = true;
        window.update(pongVue);
        pongVue.addKeyListener(this);
        pongVue.setFocusable(true);
        pongVue.requestFocusInWindow();
        window.start();
    }


    ///////////Gestion des evenements//////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        //AcceuilVue
        if (e.getSource() == AcceuilVue.jouer) window.update(gameVue);
        if (e.getSource() == AcceuilVue.aide) window.update(aideVue);
        if (e.getSource() == AcceuilVue.quit){
            int option = JOptionPane.showConfirmDialog(null, "Quitter l'application ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option == JOptionPane.OK_OPTION) System.exit(0);
        }

        //GameVue
        if (e.getSource() == GameVue.ret) window.update(acceuilVue);
        if (e.getSource() == GameVue.pvp){
            ia = false;
            startGame(ia);
        }
        if (e.getSource() == GameVue.pve){
            ia = true;
            window.update(levelBotVue);
        }

        //AideVue
        if (e.getSource() == AideVue.jouer) window.update(gameVue);
        if (e.getSource() == AideVue.ret) window.update(acceuilVue);

        //EnGameVue
        if (e.getSource() == EndGameVue.jouer) window.update(gameVue);
        if (e.getSource() == EndGameVue.ret) window.update(acceuilVue);
        if (e.getSource() == EndGameVue.quit){
            int option = JOptionPane.showConfirmDialog(null, "Quitter l'application ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option == JOptionPane.OK_OPTION) System.exit(0);
        }

        //LevelBotVue
        if(e.getSource() == LevelBotVue.easy) startGame(ia,92);
        if(e.getSource() == LevelBotVue.medium) startGame(ia,87);
        if(e.getSource() == LevelBotVue.hard) startGame(ia,82);
        if(e.getSource() == LevelBotVue.ret) window.update(gameVue);

        //En Jeu
        if(ingame){
            pongGameModel.BallUpdate();
            if (ia){
                pongVue.getPlayer2().update();
            }
            pongVue.repaint();

            if (pongVue.getPlayer1().score>= 15){
               endGameVue = new EndGameVue(true);
               window.stop();
               ingame = false;
               window.update(endGameVue);
            }
            if (pongVue.getPlayer2().score>= 15){
                endGameVue = new EndGameVue(false);
                window.stop();
                ingame = false;
                window.update(endGameVue);
            }

        }
    }

    ///////////////Gestion des commandes utilisateurs/////////////////

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();

        switch (id){
            case KeyEvent.VK_Z:
                pongGameModel.playerUpdate(true,1);
                break;
            case KeyEvent.VK_S :
                pongGameModel.playerUpdate(true,2);
                break;
            case KeyEvent.VK_P:
                if (!ia) pongGameModel.playerUpdate(false,1);
                break;
            case KeyEvent.VK_M:
                if (!ia) pongGameModel.playerUpdate(false,2);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();

        switch (id){
            case KeyEvent.VK_Q:
                pongGameModel.playerUpdate(true,0);
                break;
            case KeyEvent.VK_L:
                if (!ia) pongGameModel.playerUpdate(false,0);
                break;
            case KeyEvent.VK_ESCAPE:
                //////Pause en jeu et menu pause///////
                String[]choix ={"Reprendre","Menu Principale","Quitter"};
                JOptionPane pause = new JOptionPane();
                if(ingame){
                    window.stop();
                    ingame = false;
                    while (true) {
                        int i = pause.showOptionDialog(null, "Jeu en pause", "It's a trap !",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
                        if (i == 0) {
                            window.start();
                            ingame = true;
                            break;
                        } else if (i == 1) {
                            int option = JOptionPane.showConfirmDialog(null, "Retour au menu Principal ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (option == JOptionPane.OK_OPTION) {
                                window.update(acceuilVue);
                                break;
                            }
                        } else if (i == 2) {
                            int option = JOptionPane.showConfirmDialog(null, "Quitter l'application ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (option == JOptionPane.OK_OPTION) System.exit(0);
                            break;
                        }else {
                            break;
                        }
                    }
                    }else{
                        pause.setVisible(false);
                        window.start();
                        ingame = true;

                }
                break;
            default:
                break;
        }

    }

    //////////////////////////////Getters & setters///////////////////////////
    public AcceuilVue getAcceuilVue() {
        return acceuilVue;
    }

    public GameVue getGameVue() {
        return gameVue;
    }

    public AideVue getAideVue() {
        return aideVue;
    }

    public EndGameVue getEndGameVue() {
        return endGameVue;
    }

    public PongVue getPongVue() {
        return pongVue;
    }


    public void setWindow(Window window) {
        this.window = window;
    }
}
