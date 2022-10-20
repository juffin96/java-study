package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 飞行物
 */
public abstract class FlyingObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    public static final int REMOVE = 2;
    protected int state = LIVE; //当前状态 默认为活着的
    protected int width;  //宽
    protected int height; //高
    protected int x;      //x
    protected int y;      //y

    /**
     * 专门给小敌机 大敌机 小蜜蜂提供的
     * 三种敌人的宽和高都是不同的，所以数据不能写死，需传参
     */
    public FlyingObject(int width, int height) {
        this.width = width;
        this.height = height;
        Random random = new Random();
        x = random.nextInt(World.WIDTH - width);
        y = -height;
    }

    /**
     * 专门给英雄机、天空、子弹提供的
     */
    public FlyingObject(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public abstract BufferedImage getImage();

    /**
     * 判断对象是否活着、死了、删除的
     */
    public boolean isLive() {
        return state == LIVE; //若当前状态为LIVE，表示对象是活着的，返回true，否则返回false
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public boolean isRemove() {
        return state == REMOVE;
    }

    /**
     * 飞行物移动
     */
    public abstract void step();

    /**
     * 飞行物是否越界
     *
     * @return true 越界
     */
    public boolean isOutOfBounds() {
        return this.y >= World.HEIGHT;
    }

    public boolean isHit(FlyingObject other) {
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        int x = other.x;
        int y = other.y;
        return x1 <= x && x <= x2 && y1 < y && y <= y2;
    }

    public void goDead() {
        state = DEAD;
    }
}
