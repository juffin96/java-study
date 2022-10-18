package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 小敌机
 */
public class Airplane extends FlyingObject{
    private int speed; // 速度

    public Airplane(){
        super(48, 50);
        speed = 2;
    }

    @Override
    public void step(){
        y += speed;
    }

    private int index = 1; //爆破图起始下标
    @Override
    public BufferedImage getImage() {
        if (isLive()){
            return Images.airs[0];
        } else if (isDead()) {
            BufferedImage img = Images.airs[index++];
            if (index == Images.airs.length){
                state = REMOVE;
            }
            return img;
        }
        return null;
    }
}
