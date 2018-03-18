package Skin;

import javax.swing.*;
import java.awt.*;

public class FlatButton extends JButton {
    /**
     * Custom button (flat design)
     */
    public FlatButton(String str){
        super(str);
        this.setForeground(Color.WHITE); //text color
        this.setFont(new Font ("Tahoma",Font.BOLD,15));
        this.setBackground(new Color(0,153,204)); //button color (strong blue)
    }
}
