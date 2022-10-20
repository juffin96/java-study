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
    public static final int RUNNING = 0;
    public static final int PAUSE = 1;
    public static final int GAME_OVER = 2;
    private int state = RUNNING;
    private static final Battleship ship = new Battleship();
    private static SeaObject[] submarines = {};
    private static Mine[] mines = {};
    private static Bomb[] bombs = {};


    /**
     * 画笔
     *
     * @param g the <code>Graphics</code> context in which to paint
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
        g.drawString("SCORE: " + score, 200, 50);
        g.drawString("LIFE: " + ship.getLife(), 400, 50);
        if (state == GAME_OVER) {
            Images.gameOver.paintIcon(null, g, 0, 0);
        }
    }

    /**
     * 生成潜艇对象
     *
     * @return SeaObject 鱼雷潜艇、侦察潜艇、水雷潜艇
     */
    private SeaObject nextSubmarine() {
        int random = new Random().nextInt(20);
        if (random < 7) {
            return new ObserveSubmarine();
        } else if (random < 16) {
            return new TorpedoSubmarine();
        }
        return new MineSubmarine();
    }

    private int submarineEnterIndex = 0;

    /**
     * 潜艇进场
     */
    private void submarineEnterAction() {
        submarineEnterIndex++;
        if (submarineEnterIndex % 40 == 0) {
            SeaObject obj = nextSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = obj;
        }
    }


    private int mineEnterIndex = 0;

    /**
     * 水雷进场
     */
    private void mineEnterAction() {
        mineEnterIndex++;
        if (mineEnterIndex % 100 == 0) {
            for (int i = 0; i < submarines.length; i++) {
                if (submarines[i] instanceof MineSubmarine) {
                    MineSubmarine ms = (MineSubmarine) submarines[i];
                    Mine obj = ms.shootMine();
                    mines = Arrays.copyOf(mines, mines.length + 1);
                    mines[mines.length - 1] = obj;
                }
            }
        }
    }

    /**
     * 销毁超出边界的物体
     */
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

    /**
     * 移动
     */
    private void moveAction() {
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].move();
        }
        for (int i = 0; i < mines.length; i++) {
            mines[i].move();
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].move();
        }
    }

    private int score = 0;

    /**
     * 炸弹和潜艇碰撞
     */
    private void bombBangAction() {
        for (int i = 0; i < bombs.length; i++) {
            Bomb b = bombs[i];
            for (int j = 0; j < submarines.length; j++) {
                SeaObject s = submarines[j];
                if (b.isLive() && s.isLive() && s.isHit(b)) {
                    s.goDead();
                    b.goDead();
                    //得分
                    if (s instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) s;
                        score += es.getScore();
                    }
                    //增命
                    if (s instanceof EnemyLife) {
                        EnemyLife el = (EnemyLife) s;
                        int num = el.getLife();
                        ship.addLife(num);
                    }
                }
            }
        }
    }

    /**
     * 水雷和战舰碰撞
     */
    private void mineBangAction() {
        for (int i = 0; i < mines.length; i++) {
            Mine m = mines[i];
            if (m.isLive() && ship.isLive() && m.isHit(ship)) {
                m.goDead();
                ship.subLife();
            }
        }
    }

    /**
     * 游戏结束
     */
    private void checkGameOverAction() {
        if (ship.getLife() <= 0) {
            state = GAME_OVER;
        }
    }

    /**
     * 启动程序的执行
     */
    private void action() {
        //生成监听器
        KeyAdapter k = new KeyAdapter() {
            //重写键盘按下事件
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    if (state == RUNNING) {
                        state = PAUSE;
                    } else if (state == PAUSE) {
                        state = RUNNING;
                    }
                }
                if (state == RUNNING) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        //战舰发射
                        Bomb obj = ship.shootBomb();
                        bombs = Arrays.copyOf(bombs, bombs.length + 1);
                        bombs[bombs.length - 1] = obj;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                        //战舰左移
                        ship.moveLeft();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                        //战舰右移
                        ship.moveRight();
                    }
                }
            }
        };
        this.addKeyListener(k);
        //创建定时器对象，定义间隔为10毫秒
        Timer timer = new Timer();
        int interval = 10;
        //匿名内部类new TImeTask(){}
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state == RUNNING) {
                    //各元素的进场
                    submarineEnterAction();
                    mineEnterAction();
                    //移动
                    moveAction();
                    //删除越界元素
                    outOfBoundsAction();
                    //炸弹碰撞事件
                    bombBangAction();
                    //水雷碰撞事件
                    mineBangAction();
                    //游戏结束
                    checkGameOverAction();
                    //重画
                    repaint();
                }
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
    }
}
