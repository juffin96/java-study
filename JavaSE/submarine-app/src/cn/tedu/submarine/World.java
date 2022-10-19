package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 游戏窗口
 */
public class World extends JPanel {
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;
    //如下就是窗口中所看到的对象
    private static Battleship ship = new Battleship();
    private static SeaObject[] submarines = {};
    private static Mine[] mines = {};
    private static Bomb[] bombs = {};

    public void paint(Graphics g) {
        //画海洋
        Images.sea.paintIcon(null, g, 0, 0);
        //画战舰
        ship.paintImage(g);
        //遍历潜艇
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].paintImage(g);
        }
        //遍历水雷
        for (int i = 0; i < mines.length; i++) {
            mines[i].paintImage(g);
        }
        //遍历炸弹
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].paintImage(g);
        }
    }

    private void action() {
        //创建定时器对象，定义间隔为10毫秒
        Timer timer = new Timer();
        int interval = 1000;
        //匿名内部类new TImeTask(){}
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO 各元素的进场、移动
                System.out.println(111);
            }
        }, interval, interval);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //会创建上面的所有对象
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 6, HEIGHT + 29);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //会自动调用paint()方法
        frame.setVisible(true);
        world.action();
    }
}
