package com.planilla.empleado.configuration;

import java.awt.Image;
import javax.swing.ImageIcon;


public class ImageView {
    public static ImageIcon getImage(String image) {
        Image img = new ImageIcon(ImageView.class.getClassLoader().getResource("icon/png/" + image)).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        return img2;
    }
}
