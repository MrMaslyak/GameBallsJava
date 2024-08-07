package Physics;

import Game.Ball;
import GameUI.Hole;
import GameUI.LabelBallCount;
import GameUI.LabelBallStrikeCount;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Collizion {

    private ArrayList<Ball> balls;
    private HoleDeleted holeDeleted;
    private LabelBallStrikeCount ballStrikeCount;
    private Hole hole;

    public Collizion(ArrayList<Ball> balls, Hole hole, LabelBallStrikeCount  ballStrikeCount) {
        this.balls = balls;
        this.hole = hole;
        this.ballStrikeCount = ballStrikeCount;
        collizion();
    }

    private void collizion() {
        holeDeleted = new HoleDeleted(balls, hole,ballStrikeCount );
        holeDeleted.checkCollisions();
        ballStrikeCount.updateCount(balls.size());

        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                Ball ball1 = balls.get(i);
                Ball ball2 = balls.get(j);

                double dx = ball1.getX() - ball2.getX();
                double dy = ball1.getY() - ball2.getY();
                double distance = Math.sqrt(dx * dx + dy * dy);
                double combinedRadius = ball1.getRad() + ball2.getRad();

                if (distance <= combinedRadius) {
                    double overlap = combinedRadius - distance;
                    double moveDistance = overlap / 2;


                    double nx = dx / distance;
                    double ny = dy / distance;

                    double p = 2 * (ball1.getxStep() * nx + ball1.getyStep() * ny - ball2.getxStep() * nx - ball2.getyStep() * ny) /
                            (ball1.getMass() + ball2.getMass());

                    ball1.setxStep(ball1.getxStep() - p * ball2.getMass() * nx);
                    ball1.setyStep(ball1.getyStep() - p * ball2.getMass() * ny);
                    ball2.setxStep(ball2.getxStep() + p * ball1.getMass() * nx);
                    ball2.setyStep(ball2.getyStep() + p * ball1.getMass() * ny);


                    ball1.setX(ball1.getX() + moveDistance * nx);
                    ball1.setY(ball1.getY() + moveDistance * ny);
                    ball2.setX(ball2.getX() - moveDistance * nx);
                    ball2.setY(ball2.getY() - moveDistance * ny);

                    Random  random = new Random();
                    int colorCollizionR = random.nextInt(256);
                    int colorCollizionG = random.nextInt(256);
                    int colorCollizionB = random.nextInt(256);
                    ball1.setColor(new Color(colorCollizionR, colorCollizionG, colorCollizionB));
                }
            }
        }
    }
}
