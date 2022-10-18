package cn.tedu.shoot;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 整个游戏窗口
 */
public class World extends JPanel {
    /**
     * 窗口的宽高
     */
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    private Sky sky = new Sky();         //天空对象
    private Hero hero = new Hero();      //英雄机对象
    private FlyingObject[] enemies = {
            new Airplane(),
            new BigAirplane(),
            new Bee()
    }; //敌人（小敌机、大敌机、小蜜蜂）对象数组
    private Bullet[] bullets = {
            new Bullet(100, 200)
    };       //子弹数组

    /**
     * 生成敌人（小敌机、大敌机、小蜜蜂）对象
     */
    public FlyingObject nextOne(){
        Random rand = new Random();
        int type = rand.nextInt(20);
        if (type < 5){
            return new Bee();
        }else if (type < 13){
            return new Airplane();
        }else {
            return new BigAirplane();
        }
    }

    //敌人入场计数
    private int enterIndex = 0;
    /** 敌人（小敌机、大敌机、小蜜蜂）入场 */
    public void enterAction(){
        enterIndex++; //每400毫秒增1
        if (enterIndex % 40 == 0){
            //此处多长时间走一次
            FlyingObject obj = nextOne();
            enemies = Arrays.copyOf(enemies, enemies.length + 1);
            //将obj添加到enemies的最后一个元素上
            enemies[enemies.length - 1] = obj;
        }

        //40,80,120,160,200,240...
    }

    /** 子弹进场 */
    private int shootIndex = 0;
    public void shootAction(){
        //每300毫秒走一次
        shootIndex++;
        if (shootIndex % 30 == 0){
            //获取英雄机发射出来的子弹数组
            Bullet[] bs = hero.shoot();
            //扩容
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length);
            //数组的追加
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
        }
        //30, 60, 90...
    }

    public void stepAction(){
        sky.step();
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
    }

    /**
     * 启动程序的执行
     */
    public void action(){
        //定时器对象
        Timer timer = new Timer();
        //定时间隔ms
        int intervel = 10;
        //定时计划表
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //敌人（小敌机、大敌机、小蜜蜂）入场
                enterAction();
                //子弹入场
                shootAction();
                //飞行物移动
                stepAction();
                //重画（重新调用paint()方法）
                repaint();
            }
        }, intervel, intervel);
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

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //尽快调用paint()方法

        world.action();
    }
}
