package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷类
 */
public class Mine extends SeaObject{
    public Mine(int x, int y) {
        super(11, 11, x, y, 1);
    }

    @Override
    public void move() {
        y -= speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.mine;
    }
}
