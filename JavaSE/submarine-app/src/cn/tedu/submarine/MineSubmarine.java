package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷潜艇
 */
public class MineSubmarine extends SeaObject{

    public MineSubmarine() {
        super(63, 19);

    }

    @Override
    public void move(){
        System.out.println("水雷潜艇x向右移动...");
    }

    @Override
    public ImageIcon readImage() {
        return Images.mineSubmarine;
    }
}
