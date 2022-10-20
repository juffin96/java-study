package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * 整个游戏窗口
 */
public class World extends JPanel {
    /**
     * 窗口的宽高
     */
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAME_OVER = 3;
    private int state = START;
    private Sky sky = new Sky();         //天空对象
    private Hero hero = new Hero();      //英雄机对象
    private FlyingObject[] enemies = {}; //敌人（小敌机、大敌机、小蜜蜂）对象数组
    private Bullet[] bullets = {};       //子弹数组
    private int score = 0;

    /**
     * 生成敌人（小敌机、大敌机、小蜜蜂）对象
     */
    public FlyingObject nextOne() {
        Random rand = new Random();
        int type = rand.nextInt(20);
        if (type < 5) {
            return new Bee();
        } else if (type < 13) {
            return new Airplane();
        } else {
            return new BigAirplane();
        }
    }

    //敌人入场计数
    private int enterIndex = 0;

    /**
     * 敌人（小敌机、大敌机、小蜜蜂）入场
     */
    public void enterAction() {
        enterIndex++; //每400毫秒增1
        if (enterIndex % 40 == 0) {
            //此处多长时间走一次
            FlyingObject obj = nextOne();
            enemies = Arrays.copyOf(enemies, enemies.length + 1);
            //将obj添加到enemies的最后一个元素上
            enemies[enemies.length - 1] = obj;
        }
    }

    private int shootIndex = 0;

    /**
     * 子弹进场
     */
    public void shootAction() {
        //每300毫秒走一次
        shootIndex++;
        if (shootIndex % 30 == 0) {
            //获取英雄机发射出来的子弹数组
            Bullet[] bs = hero.shoot();
            //扩容
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length);
            //数组的追加
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
        }
    }

    /**
     * 各元素移动
     */
    public void stepAction() {
        //天空动
        sky.step();
        //敌人动
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
        //子弹动
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
    }

    /**
     * 删除越界的敌人和子弹
     */
    private void outOfBoundsAction() {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].isOutOfBounds() || enemies[i].isRemove()) {
                enemies[i] = enemies[enemies.length - 1];
                enemies = Arrays.copyOf(enemies, enemies.length - 1);
            }
        }
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isOutOfBounds() || bullets[i].isRemove()) {
                bullets[i] = bullets[bullets.length - 1];
                bullets = Arrays.copyOf(bullets, bullets.length - 1);
            }
        }
    }

    /**
     * 子弹与敌人的碰撞
     */
    public void bulletBangAction() {
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            for (int j = 0; j < enemies.length; j++) {
                FlyingObject f = enemies[j];
                if (b.isLive() && f.isLive() && f.isHit(b)) {
                    b.goDead();
                    f.goDead();
                    if (f instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) f;
                        score += es.getScore();
                    }
                    if (f instanceof EnemyAward) {
                        EnemyAward ea = ((EnemyAward) f);
                        int type = ea.getAwardType();
                        switch (type) {
                            case EnemyAward.FIRE:
                                hero.addFire();
                                break;
                            case EnemyAward.LIFE:
                                hero.addLife();
                                break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 英雄机碰撞
     */
    public void heroBangAction() {
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            if (hero.isLive() && f.isLive() && f.isHit(hero)) {
                f.goDead();
                hero.subtractLife();
                hero.clearFire();
            }
        }
    }

    /**
     * 判断游戏结束
     */
    public void checkGameOverAction() {
        if (hero.getLife() <= 0) {
            state = GAME_OVER;
        }
    }

    /**
     * 启动程序的执行
     */
    public void action() {
        //鼠标侦听器，重写其移动事件
        MouseAdapter m = new MouseAdapter() {
            @Override
            //鼠标移动事件
            public void mouseMoved(MouseEvent e) {
                //传入鼠标的x, y
                if (state == RUNNING) {
                    hero.moveTo(e.getX(), e.getY());
                }
            }

            @Override
            //鼠标点击事件
            public void mouseClicked(MouseEvent e) {
                switch (state) {
                    case START:
                        state = RUNNING;
                        break;
                    case GAME_OVER:
                        score = 0;
                        sky = new Sky();
                        hero = new Hero();
                        enemies = new FlyingObject[0];
                        bullets = new Bullet[0];
                        state = START;
                        break;
                }
            }

            @Override
            //鼠标移出事件
            public void mouseExited(MouseEvent e) {
                if (state == RUNNING) {
                    state = PAUSE;
                }
            }

            @Override
            //鼠标移入事件
            public void mouseEntered(MouseEvent e) {
                if (state == PAUSE) {
                    state = RUNNING;
                }
            }
        };
        this.addMouseListener(m);
        this.addMouseMotionListener(m);
        //定时器对象
        Timer timer = new Timer();
        //定时间隔ms
        int interval = 10;
        //定时计划表
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //敌人（小敌机、大敌机、小蜜蜂）入场
                if (state == RUNNING) {
                    enterAction();
                    //子弹入场
                    shootAction();
                    //飞行物移动
                    stepAction();
                    //删除越界物体
                    outOfBoundsAction();
                    //子弹碰撞
                    bulletBangAction();
                    //英雄机碰撞
                    heroBangAction();
                    //判断游戏结束
                    checkGameOverAction();
                }
                //重画（重新调用paint()方法）
                repaint();
            }
        }, interval, interval);
    }

    /**
     * 重写paint()方法，g表示画笔
     */
    @Override
    public void paint(Graphics g) {
        //画天空
        g.drawImage(sky.getImage(), sky.x, sky.y, null);
        //画天空2
        g.drawImage(sky.getImage(), sky.x, sky.getY1(), null);
        //画英雄机
        g.drawImage(hero.getImage(), hero.x, hero.y, null);
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            g.drawImage(f.getImage(), f.x, f.y, null);
        }
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            g.drawImage(b.getImage(), b.x, b.y, null);
        }
        g.drawString("SCORE: " + score, 10, 25);
        g.drawString("LIFE: " + hero.getLife(), 10, 45);
        //根据当前状态画不同的图
        switch (state) {
            case START:
                g.drawImage(Images.start, 0, 0, null);
                break;
            case PAUSE:
                g.drawImage(Images.pause, 0, 0, null);
                break;
            case GAME_OVER:
                g.drawImage(Images.gameOver, 0, 0, null);
                break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true); //尽快调用paint()方法

        world.action();
    }
}
