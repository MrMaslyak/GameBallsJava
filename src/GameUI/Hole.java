package GameUI;

import javax.swing.*;
import java.awt.Image;

public class Hole extends JLabel {
    private int x;
    private int y;
    private int w= 50;
    private int h= 50;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, w, h);

        ImageIcon originalIcon = new ImageIcon("src/img/holeImg.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        setIcon(resizedIcon);
        setSize(50, 50);
        setOpaque(false);
        setLayout(null);
        setVisible(true);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
