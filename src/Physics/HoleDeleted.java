package Physics;

import Game.Ball;
import GameUI.Hole;

import java.util.ArrayList;

public class HoleDeleted {

    private ArrayList<Ball> balls;
    private Hole hole;

    public HoleDeleted(ArrayList<Ball> balls, Hole hole) {
        this.balls = balls;
        this.hole = hole;
        checkCollisions();
    }

    public void checkCollisions() {
        for (Ball ball : balls) {
            if (isColliding(ball, hole)) {
                System.out.println("привет");
                balls.remove(ball);
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
