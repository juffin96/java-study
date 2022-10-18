package cn.tedu.submarine;

import javax.swing.*;

/**
 * 侦察潜艇类
 */
public class ObserveSubmarine extends SeaObject{
    public ObserveSubmarine() {
        super(63, 19);
    }

    @Override
    public void move() {
        System.out.println("侦察潜艇x向右移动。。");
    }

    @Override
    public ImageIcon readImage() {
        return Images.observeSubmarine;
    }
}
