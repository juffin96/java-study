package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 大敌机
 */
public class BigAirplane extends FlyingObject {
    private int speed;

    public BigAirplane() {
        super(66, 89);
        speed = 2;
    }

    private int index = 1; //爆破图起始下标

    @Override
    public BufferedImage getImage() {
        if (isLive()) {
            return Images.bairs[0];
        } else if (isDead()) {
            BufferedImage img = Images.bairs[index++];
            if (index == Images.bairs.length) {
                state = REMOVE;
            }
            return img;
        }
        return null;
    }

    @Override
    public void step() {
        y += speed;
    }
}
