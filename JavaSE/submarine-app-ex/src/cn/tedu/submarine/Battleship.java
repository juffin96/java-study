package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 战舰类
 */
public class Battleship extends SeaObject {
    private int life;

    public Battleship() {
        super(66, 26, 270, 124, 20);
        life = 5;
    }

    @Override
    public void move() {
        System.out.println("战舰x左右移动");
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    @Override
    public ImageIcon readImage() {
        return Images.battleship;
    }

    public Bomb shootBomb() {
        return new Bomb(this.x, this.y);
    }

    public void addLife(int num) {
        life += num;
    }

    public void subLife() {
        life--;
    }

    public int getLife() {
        return life;
    }
}
