package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 战舰
 */
public class Battleship extends SeaObject{
    private int life = 5;

    public Battleship() {
        super(66, 26, 270, 124, 20);
        life = 50000;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public void move(){
        System.out.println("战舰x左右移动...");
    }

    @Override
    public ImageIcon readImage() {
        return Images.battleship;
    }
}
