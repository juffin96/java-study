package cn.tedu.shoot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 图片工具类
 */
public class Images {
    public static BufferedImage sky;    //天空图片
    public static BufferedImage bullet; //子弹图片
    public static BufferedImage[] heroes; //英雄机图片数组
    public static BufferedImage[] airs; //小敌机图片数组
    public static BufferedImage[] bairs;//大敌机图片数组
    public static BufferedImage[] bees; //小蜜蜂图片数组

    static {
        sky = readImage("background.png");
        bullet = readImage("bullet.png");

        heroes = new BufferedImage[2];
        heroes[0] = readImage("hero0.png");
        heroes[1] = readImage("hero1.png");

        bairs = new BufferedImage[5];
        bairs[0] = readImage("bigairplane.png");

        airs = new BufferedImage[5];
        airs[0] = readImage("airplane.png");

        bees = new BufferedImage[5];
        bees[0] = readImage("bee.png");

        for (int i = 1; i < airs.length; i++) {
            airs[i] = readImage("bom" + i + ".png");
            bairs[i] = readImage("bom" + i + ".png");
            bees[i] = readImage("bom" + i + ".png");
        }

    }

    private static BufferedImage readImage(String filename) {
        try {
            //读取与FlyingObject同包中的图片
            BufferedImage img = ImageIO.read(FlyingObject.class.getResource(filename));
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

