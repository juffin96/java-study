package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore {

    public TorpedoSubmarine() {
        super(64, 20);
    }

    @Override
    public void move() {
        x += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.torpedoSubmarine;
    }

    @Override
    public int getScore() {
        return 1;
    }
}
