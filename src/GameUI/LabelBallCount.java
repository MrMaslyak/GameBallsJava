package GameUI;

import javax.swing.*;
import java.awt.*;
import Interface.UI;
import Interface.updateCount;

public class LabelBallCount extends JLabel implements updateCount, UI {
    private int countBalls;

    public LabelBallCount(int countBalls) {
        this.countBalls = countBalls;
        ui();
    }

    public void ui() {
        setForeground(Color.GRAY);
        setFont(new Font("Arial", Font.BOLD, 15));
        setText("Balls: " + countBalls);
        setOpaque(true);
    }

    public void updateCount(int countBalls) {
        this.countBalls = countBalls;
        setText("Balls: " + countBalls);
    }
}
