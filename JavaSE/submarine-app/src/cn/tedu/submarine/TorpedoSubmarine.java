package cn.tedu.submarine;

import javax.swing.*;

/**
 * 鱼雷潜艇
 */
public class TorpedoSubmarine extends SeaObject{

    public TorpedoSubmarine() {
        super(64, 20);

    }

    @Override
    public void move(){
        System.out.println("鱼雷潜艇x向右移动...");
    }

    @Override
    public ImageIcon readImage() {
        return Images.torpedoSubmarine;
    }
}
