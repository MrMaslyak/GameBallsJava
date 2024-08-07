package Threads;

import Game.Game;

public class GameThread extends Thread {
    private Game game;

    public GameThread(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
