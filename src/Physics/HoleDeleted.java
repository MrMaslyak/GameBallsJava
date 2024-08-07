package Physics;

import Game.Ball;
import GameUI.Hole;
import GameUI.LabelBallStrikeCount;
import GameUI.LabelBallCount;

import java.util.ArrayList;

public class HoleDeleted {

    private ArrayList<Ball> balls;
    private Hole hole;
    private LabelBallStrikeCount ballStrikeCount;
    private LabelBallCount  labelBallCount;

    public HoleDeleted(ArrayList<Ball> balls, Hole hole, LabelBallStrikeCount ballStrikeCount,LabelBallCount  labelBallCount ) {
        this.balls = balls;
        this.hole = hole;
        this.ballStrikeCount = ballStrikeCount;
        this.labelBallCount = labelBallCount;
    }

    public void checkCollisions() {
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (isColliding(ball, hole)) {
                ballStrikeCount.incrementStrikeCount();
                labelBallCount.updateCount(balls.size()-1);
                balls.remove(ball);
                ballStrikeCount.repaint();
                break;
            }
        }
    }

    private boolean isColliding(Ball ball, Hole hole) {
        int ballX = (int) ball.getX();
        int ballY = (int) ball.getY();
        int ballRadius = ball.getRad();
        int holeX = hole.getX();
        int holeY = hole.getY();
        int holeRadius = hole.getW()/2;

        double dx = ballX + ballRadius - (holeX + holeRadius);
        double dy = ballY + ballRadius - (holeY + holeRadius);
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance < (ballRadius + holeRadius);
    }
}
