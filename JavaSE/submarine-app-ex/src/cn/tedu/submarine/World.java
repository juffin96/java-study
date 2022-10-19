package cn.tedu.submarine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 世界窗口类
 */
public class World extends JLabel{
    public static final int HEIGHT = 479;
    public static final int WIDTH = 641;
    private static final Battleship battleship = new Battleship();
    private SeaObject[] submarines = {};
    private Bomb[] bombs = {};
    private Mine[] mines = {};

    private SeaObject nextSubmarine(){
        int random = new Random().nextInt(20);
        if (random < 7){
            return new ObserveSubmarine();
        } else if (random < 15) {
            return new TorpedoSubmarine();
        }
        return new MineSubmarine();
    }

    private int submarineEnterIndex = 0;
    private void submarineEnterAction() {
        submarineEnterIndex++;
        if (submarineEnterIndex % 40 == 0){
            SeaObject submarine = nextSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = submarine;
        }
    }

    private int mineEnterIndex = 0;
    private void mineEnterAction(){
        mineEnterIndex++;
        if (mineEnterIndex % 100 == 0){
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

    private void moveAction(){
        for (SeaObject submarine : submarines) {
            submarine.move();
        }
        for (Mine mine : mines) {
            mine.move();
        }
    }

    @Override
    public void paint(Graphics g){
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
    }
    private void action(){
        Timer timer = new Timer();
        int interval = 10;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //各元素进场、移动
                submarineEnterAction();
                mineEnterAction();
                //TODO 炸弹进场
                moveAction();
                repaint();
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
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        world.action();
        world.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
                    battleship.x -= battleship.speed;
                }
                if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                    battleship.x += battleship.speed;
                }
            }
        });
    }
}
