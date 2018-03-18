package Vue;

import Skin.FlatButton;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AcceuilVue extends JPanel {
    /**
     * Affiche la fenêtre d'acceuil de l'appli
     */
    private static final long serialVersionUID = 1L;
    public static FlatButton jouer = new FlatButton ("Jouer");
    public static FlatButton aide = new FlatButton ("Aide");
    public static FlatButton quit = new FlatButton ("Quitter");
    private Dimension dim = new Dimension (500,50); //taille des boutons

    public AcceuilVue(){
        /*******Composants settings**********/
        jouer.setPreferredSize(dim);
        aide.setPreferredSize(dim);
        quit.setPreferredSize(dim);
        this.setBackground(Color.WHITE);
        /*****************mise en place des composants pour l'affichage**************/
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = 0;
        this.add(jouer, gbc);

        gbc.gridy ++;
        gbc.insets.top = 60;
        this.add(aide, gbc);

        gbc.gridy ++;
        this.add(quit, gbc);
    }
    ///////////////////image background///////////////
    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("Image/46.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
