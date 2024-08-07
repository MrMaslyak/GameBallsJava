package GameUI;

import Game.Ball;
import Physics.*;
import Physics.Wall;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelLine extends JPanel {
    private ArrayList<Ball> balls;
    private Image offScreenImage;
    private Graphics offScreenGraphics;
    private Hole hole;

    public JPanelLine(ArrayList<Ball> balls, Hole hole) {
        this.balls = balls;
        this.hole = hole;
        setOpaque(true);
        setLayout(null);
        setPreferredSize(new Dimension(750, 550));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (offScreenImage == null) {
            offScreenImage = createImage(getWidth(), getHeight());
            offScreenGraphics = offScreenImage.getGraphics();
        }

        offScreenGraphics.setColor(Color.WHITE);
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        offScreenGraphics.setColor(Color.BLACK);
        offScreenGraphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        new Wall(getWidth(), getHeight(), balls);
        new Collizion(balls, hole);
        balls.forEach(ball -> ball.paint(offScreenGraphics));

        g.drawImage(offScreenImage, 0, 0, this);
    }
}
