package Actions;

import Game.Ball;
import Threads.Move;
import Interface.updateMoveKey;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Key implements KeyListener, updateMoveKey {
    private Ball ballMain;
    private boolean upPressed, downPressed, leftPressed, rightPressed;
    private Move move;
    private Thread moveThread;

    public Key(Ball ballMain) {
        this.ballMain = ballMain;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            case KeyEvent.VK_Q:
                int xStepQ = -100;
                ballMain.setxStep(xStepQ);
                break;
            case KeyEvent.VK_E:
                int xStepE = 100;
                ballMain.setxStep(xStepE);
                break;
            case KeyEvent.VK_R:
                int yStepR = -100;
                ballMain.setyStep(yStepR);
                break;
            case KeyEvent.VK_F:
                int yStepF = 100;
                ballMain.setyStep(yStepF);
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
        }
    }

    public void update() {
        int step = 10;
        if (upPressed) ballMain.setY(ballMain.getY() - step);
        if (downPressed) ballMain.setY(ballMain.getY() + step);
        if (leftPressed) ballMain.setX(ballMain.getX() - step);
        if (rightPressed) ballMain.setX(ballMain.getX() + step);
    }
}
