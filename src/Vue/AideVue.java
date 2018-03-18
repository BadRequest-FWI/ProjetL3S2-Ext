package Vue;

import Skin.FlatButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AideVue extends JPanel {
    /**
     * Affiche la fenêtre d'aide au jeu et les controles
     */
    private static final long serialVersionUID = 1L;
    public JPanel footer = new JPanel();
    public static FlatButton jouer = new FlatButton ("Jouer");
    public static FlatButton ret = new FlatButton ("retour");
    private Dimension dim = new Dimension (100,30);//taille des boutons

    public AideVue (){
        /*******Composants settings**********/
        footer.setOpaque(false);
        jouer.setPreferredSize(dim);
        ret.setPreferredSize(dim);
        /*****************mise en place des composants pour l'affichage**************/
        this.setLayout(new BorderLayout());
        footer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = 0;
        gbc.insets.left = 15;
        gbc.insets.bottom = 10;
        footer.add(jouer, gbc);
        gbc.gridx ++;
        footer.add(ret,gbc);

        this.add(footer, BorderLayout.SOUTH);
    }

    ///////////////////image background///////////////
    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("Image/aide.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
