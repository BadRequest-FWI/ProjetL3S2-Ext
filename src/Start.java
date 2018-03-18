import Controleur.Control;
import Vue.Window;

public class Start {

    public static void main (String[]args){
        Control ctrl = new Control();
        Window win = new Window(ctrl);
    }
}
