package Physics;

import Game.Ball;
import java.util.ArrayList;

public class Wall {
    private ArrayList<Ball> balls;
    private int getWidthGame, getHeightGame;

    public Wall(int getWidthGame, int getHeightGame, ArrayList<Ball> balls) {
        this.getWidthGame = getWidthGame;
        this.getHeightGame = getHeightGame;
        this.balls = balls;
        checkCollision();
    }

    private void checkCollision() {
        int x = 0, y = 0, width = getWidthGame, height = getHeightGame;
        balls.forEach(ball -> {
            if (ball.getX() < x) {
                ball.setxStep(-ball.getxStep());
                ball.setX(x);
            } else if (ball.getX() > width - ball.getRad()) {
                ball.setxStep(-ball.getxStep());
                ball.setX(width - ball.getRad());
            }
            if (ball.getY() < y) {
                ball.setyStep(-ball.getyStep());
                ball.setY(y);
            } else if (ball.getY() > height - ball.getRad()) {
                ball.setyStep(-ball.getyStep());
                ball.setY(height - ball.getRad());
            }

            ball.applyDamping();
        });
    }
}
