package Vue;

import Skin.FlatButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LevelBotVue extends JPanel {
    /**
     * Affiche la fenêtre de selection de l'ia en jeu
     */

    private static final long serialVersionUID = 1L;
    public JPanel body = new JPanel();
    public JPanel footer = new JPanel();
    public static FlatButton easy = new FlatButton ("Facile");
    public static FlatButton medium = new FlatButton ("Moyen");
    public static FlatButton hard = new FlatButton ("Difficile");
    public static FlatButton ret = new FlatButton ("Retour");
    private Dimension dim = new Dimension (500,50);

    public LevelBotVue (){
        /*******Composants settings**********/
        footer.setOpaque(false);
        body.setOpaque(false);
        easy.setPreferredSize(dim);
        medium.setPreferredSize(dim);
        hard.setPreferredSize(dim);
        ret.setPreferredSize(new Dimension (100,30));
        /*****************mise en place des composants pour l'affichage**************/
        this.setLayout(new BorderLayout());
        body.setLayout(new GridBagLayout());
        footer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = 0;
        body.add(easy,gbc);
        gbc.gridy ++;
        gbc.insets.top = 80;
        body.add(medium,gbc);
        gbc.gridy ++;
        gbc.insets.top = 80;
        body.add(hard,gbc);

        gbc.gridx = gbc.gridy = 0;
        gbc.insets.bottom = 10;
        footer.add(ret, gbc);

        this.add(body, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

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
