package GameUI;

import javax.swing.*;
import Interface.UI;
import Interface.updateCount;
import java.awt.*;

public class LabelBallStrikeCount extends JLabel implements updateCount, UI {
    private int countBallsStrike;
    private boolean isStrike;

    public LabelBallStrikeCount(int countBallsStrike) {
        this.countBallsStrike = countBallsStrike;
        ui();
    }

    public void ui() {
        setForeground(Color.GRAY);
        setFont(new Font("Arial", Font.BOLD, 15));
        setText("Balls Strike: " + countBallsStrike);
        setOpaque(true);
    }

    @Override
    public void updateCount(int countBallsStrike) {
        if (isStrike) {
            setText("Balls Strike: " + countBallsStrike);
        }
    }

    public boolean isStrike(boolean b) {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public int getCountBallsStrike() {
        return countBallsStrike;
    }

    public void setCountBallsStrike(int countBallsStrike) {
        this.countBallsStrike = countBallsStrike;
    }

    public void incrementStrikeCount() {
        countBallsStrike++;
        setText("Balls Strike: " + countBallsStrike);
    }
}
