package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 世界窗口类
 */
public class World extends JLabel {
    public static final int HEIGHT = 479;
    public static final int WIDTH = 641;
    public static final int RUNNING = 0;
    public static final int PAUSE = 1;
    public static final int GAME_OVER = 2;
    private int state = RUNNING;
    private static final Battleship battleship = new Battleship();
    private SeaObject[] submarines = {};
    private Bomb[] bombs = {};
    private Mine[] mines = {};

    private SeaObject nextSubmarine() {
        int random = new Random().nextInt(20);
        if (random < 7) {
            return new ObserveSubmarine();
        } else if (random < 15) {
            return new TorpedoSubmarine();
        }
        return new MineSubmarine();
    }

    private int submarineEnterIndex = 0;

    private void submarineEnterAction() {
        submarineEnterIndex++;
        if (submarineEnterIndex % 40 == 0) {
            SeaObject submarine = nextSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = submarine;
        }
    }

    private int mineEnterIndex = 0;

    private void mineEnterAction() {
        mineEnterIndex++;
        if (mineEnterIndex % 100 == 0) {
            for (SeaObject submarine : submarines) {
                MineSubmarine mineSubmarine = submarine instanceof MineSubmarine ? ((MineSubmarine) submarine) : null;
                if (mineSubmarine != null) {
                    Mine mine = mineSubmarine.shootMine();
                    mines = Arrays.copyOf(mines, mines.length + 1);
                    mines[mines.length - 1] = mine;
                }
            }
        }
    }

    private void outOfBoundsAction() {
        for (int i = 0; i < submarines.length; i++) {
            if (submarines[i].isOutOfBounds() || submarines[i].isDead()) {
                submarines[i] = submarines[submarines.length - 1];
                submarines = Arrays.copyOf(submarines, submarines.length - 1);
            }
        }
        for (int i = 0; i < mines.length; i++) {
            if (mines[i].isOutOfBounds() || mines[i].isDead()) {
                mines[i] = mines[mines.length - 1];
                mines = Arrays.copyOf(mines, mines.length - 1);
            }
        }
        for (int i = 0; i < bombs.length; i++) {
            if (bombs[i].isOutOfBounds() || bombs[i].isDead()) {
                bombs[i] = bombs[bombs.length - 1];
                bombs = Arrays.copyOf(bombs, bombs.length - 1);
            }
        }
    }

    private void moveAction() {
        for (SeaObject submarine : submarines) {
            submarine.move();
        }
        for (Mine mine : mines) {
            mine.move();
        }
        for (Bomb bomb : bombs) {
            bomb.move();
        }
    }

    private int score = 0;

    private void bombBangAction() {
        for (Bomb bomb : bombs) {
            for (SeaObject submarine : submarines) {
                if (bomb.isLive() && submarine.isLive() && bomb.isHit(submarine)) {
                    bomb.goDead();
                    submarine.goDead();
                    if (bomb instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) submarine;
                        score += es.getScore();
                    }
                    if (bomb instanceof EnemyLife) {
                        EnemyLife el = (EnemyLife) submarine;
                        int num = el.getLife();
                        battleship.addLife(num);
                    }
                }
            }
        }
    }

    private void mineBangAction() {
        for (Mine mine : mines) {
            if (mine.isLive() && battleship.isLive() && mine.isHit(battleship)) {
                mine.goDead();
                battleship.subLife();
            }
        }
    }

    private void checkGameOverAction() {
        if (battleship.getLife() <= 0) {
            state = GAME_OVER;
        }
    }

    @Override
    public void paint(Graphics g) {
        Images.sea.paintIcon(null, g, 0, 0);
        battleship.paintImage(g);
        for (SeaObject submarine : submarines) {
            submarine.paintImage(g);
        }
        for (Bomb bomb : bombs) {
            bomb.paintImage(g);
        }
        for (Mine mine : mines) {
            mine.paintImage(g);
        }
        g.drawString("SCORE: " + score, 200, 50);
        g.drawString("LIFE: " + battleship.getLife(), 400, 50);
        if (state == GAME_OVER) {
            Images.gameOver.paintIcon(null, g, 0, 0);
        }
    }

    private void action() {
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    if (state == RUNNING) {
                        state = PAUSE;
                    } else if (state == PAUSE) {
                        state = RUNNING;
                    }
                }
                if (state == RUNNING) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        Bomb obj = battleship.shootBomb();
                        bombs = Arrays.copyOf(bombs, bombs.length + 1);
                        bombs[bombs.length - 1] = obj;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                        battleship.moveLeft();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                        battleship.moveRight();
                    }
                }
            }
        };
        this.addKeyListener(k);
        Timer timer = new Timer();
        int interval = 10;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state == RUNNING) {
                    //各元素进场、移动
                    submarineEnterAction();
                    mineEnterAction();
                    moveAction();
                    outOfBoundsAction();
                    bombBangAction();
                    mineBangAction();
                    checkGameOverAction();
                    repaint();
                }
            }
        }, interval, interval);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 6, HEIGHT + 29);
        frame.setTitle("潜艇大战");
        frame.setIconImage(new ImageIcon("img/mine.png").getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        world.action();
    }
}
