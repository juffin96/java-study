package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 小蜜蜂类
 */
public class Bee extends FlyingObject{

    private int xSpeed;    // x速度
    private int ySpeed;    // y速度
    private int awardType; // 奖励类型

    public Bee(){
        super(60, 51);
        xSpeed = 1;
        ySpeed = 2;
        awardType = new Random().nextInt(2); // 0到1之间随机数
    }

    private int index = 1; //爆破图起始下标
    @Override
    public BufferedImage getImage() {
        if (isLive()){
            return Images.bees[0];
        } else if (isDead()) {
            BufferedImage img = Images.bees[index++];
            if (index == Images.bees.length){
                state = REMOVE;
            }
            return img;
        }
        return null;
    }

    public void step(){
        x += xSpeed;
        y += ySpeed;
        if (x <= 0 || x >= World.WIDTH - width){
            //切换方向
            xSpeed *= -1;
        }
    }
}
