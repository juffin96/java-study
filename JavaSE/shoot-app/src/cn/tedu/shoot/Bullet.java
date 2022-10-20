package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 子弹
 */
public class Bullet extends FlyingObject {
    private int speed;

    public Bullet(int x, int y) {
        super(8, 20, x, y);
        speed = 3;
    }

    @Override
    public BufferedImage getImage() {
        if (isLive()) {
            return Images.bullet;
        } else if (isDead()) {
            state = REMOVE;
        }
        //死了和删除的都不返回图片
        return null;
    }

    @Override
    public void step() {
        y -= speed;
    }
}
