package Vue;

import Controleur.Control;

import javax.swing.*;

public class Window extends JFrame {
    /**
     * Fenetre principale
     */

    private static final long serialVersionUID = 1L;
    protected String titre = "Color Pong";
    protected static int width = 1295;
    protected static int height = 738;
    private Timer timer;


    public Window(Control ctrl){
        this.timer = new Timer(10,ctrl);
        ctrl.setWindow(this);
        this.setTitle(titre);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(ctrl.getAcceuilVue());
    }

    ///////////////////////gestion du timer///////////////////////////////

    public void start (){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    //////////////////////nouvel affichage/////////////////////////////
    public void update(JPanel p){
        this.setContentPane (p);
        this.revalidate();
    }
}
