package Vue;

import Skin.FlatButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class EndGameVue extends JPanel {

    private static final long serialVersionUID = 1L;
    public JPanel header = new JPanel();
    public JPanel footer = new JPanel();
    public static FlatButton jouer = new FlatButton ("Rejouer");
    public static FlatButton ret = new FlatButton ("Menu");
    public static FlatButton quit = new FlatButton ("Quitter");
    private Dimension dim = new Dimension (110,30);

    public EndGameVue(boolean result){
        JLabel winner;
        if (result){
            winner = new JLabel("Victoire du Joueur 1 ");
        }else{
            winner = new JLabel("Victoire du Joueur 2");
        }
        Font police = new Font ("Tahoma", Font.PLAIN,36);
        winner.setFont(police);winner.setForeground(Color.WHITE);
        footer.setOpaque(false);
        header.setOpaque(false);
        ret.setPreferredSize(dim);
        jouer.setPreferredSize(dim);
        quit.setPreferredSize(dim);

        this.setLayout(new BorderLayout());
        header.setLayout(new GridBagLayout());
        footer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = 0;
        header.add(winner, gbc);

        gbc.insets.left = 15;
        gbc.insets.bottom = 10;
        footer.add(jouer, gbc);

        gbc.gridx ++;
        footer.add(ret,gbc);

        gbc.gridx ++;
        footer.add(quit,gbc);

        this.add(footer, BorderLayout.SOUTH);
        this.add(header, BorderLayout.NORTH);
    }

    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("Image/ggwp.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
