package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine extends SeaObject{

    public TorpedoSubmarine() {
        super(64, 20);
    }

    @Override
    public void move(){
        x += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.torpedoSubmarine;
    }
}
