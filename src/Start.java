import Controleur.Control;
import Vue.Window;

public class Start {
    /**
     * Launcher de l'appli
     */

    public static void main (String[]args){
        Control ctrl = new Control();
        Window win = new Window(ctrl);
    }
}
