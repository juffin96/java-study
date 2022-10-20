package cn.tedu.submarine;

import javax.swing.ImageIcon;
import java.awt.Graphics;
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
     *
     * @return true 死亡
     */
    public boolean isDead() {
        return state == DEAD;
    }

    /**
     * 判断对象是否存活
     *
     * @return true 存活
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

    /**
     * 是否超出边界
     *
     * @return true 超出边界
     */
    public boolean isOutOfBounds() {
        return this.x >= World.WIDTH;
    }

    /**
     * 物体碰撞
     *
     * @param other 另一个对象
     * @return true 碰撞成功
     */
    public boolean isHit(SeaObject other) {
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        int x = other.x;
        int y = other.y;
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    /**
     * 物体死亡
     */
    public void goDead() {
        state = DEAD;
    }
}
