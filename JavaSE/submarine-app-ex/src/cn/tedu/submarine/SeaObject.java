package cn.tedu.submarine;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;

/**
 * 海洋物体类
 */
public abstract class SeaObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    private int state = LIVE;
    int width;
    int height;
    int x;
    int y;
    int speed;

    /**
     * 所有潜艇的构造器
     *
     * @param width  宽
     * @param height 高
     */
    public SeaObject(int width, int height) {
        this.width = width;
        this.height = height;
        x = -width;
        Random r = new Random();
        y = r.nextInt(World.HEIGHT - height - 150 + 1) + 150;
        speed = r.nextInt(3) + 1;
    }

    /**
     * 战舰、水雷、炸雷的构造器
     *
     * @param width  宽
     * @param height 高
     * @param x      x坐标
     * @param y      y坐标
     * @param speed  速度
     */
    public SeaObject(int width, int height, int x, int y, int speed) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public abstract void move();

    public abstract ImageIcon readImage();

    public boolean isLive() {
        return state == LIVE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public void paintImage(Graphics g) {
        if (this.state == LIVE) {
            this.readImage().paintIcon(null, g, this.x, this.y);
        }
    }

    public boolean isOutOfBounds() {
        return this.x >= World.WIDTH;
    }

    public boolean isHit(SeaObject obj) {
        int x1 = this.x - obj.width;
        int x2 = this.x + this.width;
        int y1 = this.y - obj.height;
        int y2 = this.y + this.height;
        int x = obj.x;
        int y = obj.y;
        return x1 <= x && x <= x2 && y1 < y && y < y2;
    }

    public void goDead() {
        state = DEAD;
    }
}
