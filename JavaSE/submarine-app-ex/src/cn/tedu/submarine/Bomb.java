package cn.tedu.submarine;

import javax.swing.*;

/**
 * 炸弹类
 */
public class Bomb extends SeaObject {
    public Bomb(int x, int y) {
        super(9, 12, x, y, 3);
    }

    @Override
    public void move() {
        y += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.bomb;
    }
}
