package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 战舰
 */
public class Battleship extends SeaObject {
    private int life = 5;

    public Battleship() {
        super(66, 26, 270, 124, 20);
        life = 5;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public void move() {

    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
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

    @Override
    public ImageIcon readImage() {
        return Images.battleship;
    }
}
