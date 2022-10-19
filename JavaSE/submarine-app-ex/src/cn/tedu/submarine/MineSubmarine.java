package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷潜艇类
 */
public class MineSubmarine extends SeaObject{
    public MineSubmarine() {
        super(63, 19);
    }

    public Mine shootMine(){
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
}
