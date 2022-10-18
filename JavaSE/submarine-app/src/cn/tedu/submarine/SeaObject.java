package cn.tedu.submarine;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

public abstract class SeaObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    protected int state = LIVE;
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected int speed;

    /**
     * 专门给侦察潜艇、鱼雷潜艇、水雷潜艇的构造
     */
    public SeaObject(int width, int height) {
        this.width = width;
        this.height = height;
        x = -width;
        Random rd = new Random();
        y = rd.nextInt(World.HEIGHT - height - 150 + 1) + 150;
        speed = rd.nextInt(3) + 1;
    }

    /**
     * 给战舰、炸弹、水雷的构造器
     */
    public SeaObject(int width, int height, int x, int y, int speed) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    /**
     * 移动
     */
    public abstract void move();

    /**
     * 获取对象的图片
     */
    public abstract ImageIcon readImage();

    /**
     * 判断对象是否死亡
     */
    public boolean isDead() {
        return state == DEAD;
    }

    /**
     * 判断对象是否存活
     */
    public boolean isLive() {
        return state == LIVE;
    }

    /**
     * 画对象
     */
    public void paintImage(Graphics g) {
        if (this.isLive()) {
            //若存活，则画图片
            this.readImage().paintIcon(null, g, this.x, this.y);
        }
    }

}
