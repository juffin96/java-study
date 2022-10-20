package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 天空类
 */
public class Sky extends FlyingObject {
    private int speed;
    private int y1; // 第二个天空图片的y坐标

    public Sky() {
        super(World.WIDTH, World.HEIGHT, 0, 0);
        speed = 1;
        y1 = -World.HEIGHT;
    }

    public int getY1() {
        return y1;
    }

    @Override
    public BufferedImage getImage() {
        return Images.sky;
    }

    public void step() {
        y += speed;
        y1 += speed;
        if (y >= World.HEIGHT) {
            y = -World.HEIGHT;
        }
        if (y1 >= World.HEIGHT) {
            y1 = -World.HEIGHT;
        }
    }
}
