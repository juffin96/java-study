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
        System.out.println("炸弹y向下移动。。。");
    }

    @Override
    public ImageIcon readImage() {
        return Images.bomb;
    }
}
