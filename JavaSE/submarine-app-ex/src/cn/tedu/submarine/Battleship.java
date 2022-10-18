package cn.tedu.submarine;

import javax.swing.*;

/**
 * 战舰类
 */
public class Battleship extends SeaObject{
    private int life;
    public Battleship() {
        super(66, 26, 270, 124, 20);
        life = 5;
    }

    @Override
    public void move() {
        System.out.println("战舰x左右移动");
    }

    @Override
    public ImageIcon readImage() {
        return Images.battleship;
    }
}
