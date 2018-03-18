package Vue;

import Skin.FlatButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameVue extends JPanel {

    private static final long serialVersionUID = 1L;
    public JPanel body = new JPanel();
    public JPanel footer = new JPanel();
    public static FlatButton ret = new FlatButton ("Retour");
    public static FlatButton pvp = new FlatButton ("Joueur VS joueur");
    public static FlatButton pve = new FlatButton ("Joueur VS IA ");

    public GameVue (){
        footer.setOpaque(false);
        body.setOpaque(false);
        pvp.setPreferredSize(new Dimension(500,50));
        pve.setPreferredSize(new Dimension (500,50));
        ret.setPreferredSize(new Dimension (100,30));
        this.setLayout(new BorderLayout());
        body.setLayout(new GridBagLayout());
        footer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = 0;
        body.add(pvp,gbc);
        gbc.gridy ++;
        gbc.insets.top = 80;
        body.add(pve,gbc);

        gbc.gridx = gbc.gridy = 0;
        gbc.insets.bottom = 10;
        footer.add(ret, gbc);

        this.add(body, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("Image/46.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
