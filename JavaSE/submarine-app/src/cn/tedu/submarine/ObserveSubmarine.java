package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 侦察潜艇
 */
public class ObserveSubmarine extends SeaObject{

    public ObserveSubmarine() {
        super(63, 19);

    }

    @Override
    public void move(){
        x += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.observeSubmarine;
    }
}
