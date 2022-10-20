package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 侦察潜艇类
 */
public class ObserveSubmarine extends SeaObject implements EnemyScore {
    public ObserveSubmarine() {
        super(63, 19);
    }

    @Override
    public void move() {
        x += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.observeSubmarine;
    }

    @Override
    public int getScore() {
        return 1;
    }
}
