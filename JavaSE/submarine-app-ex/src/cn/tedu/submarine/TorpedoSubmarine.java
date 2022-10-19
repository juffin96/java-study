package cn.tedu.submarine;

import javax.swing.*;

/**
 * 鱼雷潜艇类
 */
public class TorpedoSubmarine extends SeaObject{
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
}
