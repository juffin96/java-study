package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 水雷潜艇
 */
public class MineSubmarine extends SeaObject implements EnemyLife {

    public MineSubmarine() {
        super(63, 19);
    }

    public Mine shootMine() {
        return new Mine(this.x + this.width, this.y - 11);
    }

    @Override
    public void move() {
        x += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.mineSubmarine;
    }

    @Override
    public int getLife() {
        return 1;
    }
}
