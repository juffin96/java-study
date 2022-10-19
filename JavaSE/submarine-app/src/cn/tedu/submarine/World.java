package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 游戏窗口
 */
public class World extends JPanel {
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;
    //如下就是窗口中所看到的对象
    private static final Battleship ship = new Battleship();
    private static SeaObject[] submarines = {};
    private static Mine[] mines = {};
    private static Bomb[] bombs = {};


    /**
     * 画笔
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
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

    /**
     * 生成潜艇对象
     * @return SeaObject 鱼雷潜艇、侦察潜艇、水雷潜艇
     */
    private SeaObject nextSubmarine(){
        int random = new Random().nextInt(20);
        if (random < 10){
            return new TorpedoSubmarine();
        } else if (random < 16) {
            return new ObserveSubmarine();
        }
        return new MineSubmarine();
    }

    /**
     * 潜艇进场
     */
    private int submarineEnterIndex = 0;
    private void submarineEnterAction(){
        submarineEnterIndex++;
        if (submarineEnterIndex % 40 == 0){
            SeaObject obj = nextSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = obj;
        }
    }

    /**
     * 移动
     */
    private void stepAction(){
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].move();
        }
    }

    /**
     * 启动程序的执行
     */
    private void action() {
        //创建定时器对象，定义间隔为10毫秒
        Timer timer = new Timer();
        int interval = 10;
        //匿名内部类new TImeTask(){}
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO 各元素的进场
                submarineEnterAction();
                //移动
                stepAction();
                //重画
                repaint();
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
        frame.setTitle("潜艇大战");
        frame.setIconImage(new ImageIcon("img/mine.png").getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //会自动调用paint()方法
        frame.setVisible(true);
        world.action();
        world.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
                    ship.x -= ship.speed;
                }
                if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                    ship.x += ship.speed;
                }
            }
        });
    }
}
