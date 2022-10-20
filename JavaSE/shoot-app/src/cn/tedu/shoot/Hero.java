package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 英雄机类
 */
public class Hero extends FlyingObject {
    private int life; // 命
    private int fire; // 火力值

    public Hero() {
        super(97, 139, 140, 400);
        life = 3;
        fire = 0;
    }

    private int index = 0;

    @Override
    public BufferedImage getImage() { //每10毫秒走一次
        return Images.heroes[index++ % Images.heroes.length];
    }

    /**
     * 英雄机发射子弹 生成子弹对象
     */
    public Bullet[] shoot() {
        int xStep = this.width / 4;
        int yStep = 20;
        if (fire > 0) {
            //双倍 2发子弹
            Bullet[] bs = new Bullet[2];
            //x:英雄机的x+1/4英雄机的宽 y:英雄机的y，固定的20
            bs[0] = new Bullet(this.x + xStep, this.y - yStep);
            //x:英雄机的x+3/4英雄机的宽 y:英雄机的y，固定的20
            bs[1] = new Bullet(this.x + 3 * xStep, this.y - yStep);
            //发射一次双倍火力，则火力值减2
            fire -= 2;
            return bs;
        } else {
            //单倍 1发子弹
            Bullet[] bs = new Bullet[1];
            //x:英雄机的x+2/4英雄机的宽 y:英雄机的y，固定的20
            bs[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
            return bs;
        }
    }

    @Override
    public void step() {
        //TODO
    }
}
