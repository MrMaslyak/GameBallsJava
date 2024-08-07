package Threads;

import Game.Ball;

import java.util.Random;

public class Move extends Thread {
    private Ball ball;

    public Move(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ball.setX(ball.getX() + ball.getxStep());
                ball.setY(ball.getY() + ball.getyStep());
                Random random = new Random();
                int sleepTime = random.nextInt(120) + 20;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
