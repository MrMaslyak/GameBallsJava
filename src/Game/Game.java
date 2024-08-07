package Game;

import Actions.*;
import GameUI.Hole;
import GameUI.JPanelLine;
import GameUI.*;
import Physics.HoleDeleted;
import Threads.GameThread;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame implements doPaint, UI {
    private ArrayList<Ball> balls = new ArrayList<>();
    private LabelBallCount labels;
    private LabelBallStrikeCount labelsStrikeCount;
    private JPanelLine panelLine;
    private Timer timer;
    private Ball ballMain;
    private Hole hole;

    private Key key;

    public Game() {
        setTitle("Game Balls");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        ui();
        setVisible(true);
        new GameThread(this).start();
    }

    public void ui() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(mainPanel);

        hole = new Hole(5, 5);


        labels = new LabelBallCount(0);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(labels, BorderLayout.WEST);

        labelsStrikeCount = new LabelBallStrikeCount(0);
        topPanel.add(labelsStrikeCount, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        panelLine = new JPanelLine(balls, hole, labelsStrikeCount, labels);
        mainPanel.add(panelLine, BorderLayout.CENTER);

        Mouse mouse = new Mouse(balls, labels, panelLine);
        panelLine.addMouseListener(mouse);

        panelLine.add(hole, BorderLayout.SOUTH);

        timer = new Timer(32, e -> {
            key.update();
            panelLine.repaint();
        });
        timer.start();

        ballMain = new Ball(350, 250, 0, 0, Color.black, 50, 50);
        ballMain.applyDamping();
        key = new Key(ballMain);
        addKeyListener(key);
        balls.add(ballMain);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        panelLine.repaint();
    }
}
