package GameUI;

import javax.swing.*;
import javax.swing.JLabel;
import Interface.UI;
import  Interface.updateCount;
import java.awt.*;

public class LabelBallStrikeCount extends JLabel implements updateCount, UI {
    private int countBallsStrike;

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
        this.countBallsStrike = countBallsStrike;
        setText("Balls Strike: " + countBallsStrike);
    }
}
