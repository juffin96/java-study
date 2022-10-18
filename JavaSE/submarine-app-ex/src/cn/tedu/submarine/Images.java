package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 图片类
 */
public class Images {
    public static ImageIcon sea;
    public static ImageIcon battleship;
    public static ImageIcon bomb;
    public static ImageIcon mine;
    public static ImageIcon mineSubmarine;
    public static ImageIcon observeSubmarine;
    public static ImageIcon torpedoSubmarine;
    public static ImageIcon gameOver;

    /**
     * 初始化静态图片
     */
    static {
        sea = new ImageIcon("img/sea.png");
        gameOver = new ImageIcon("img/gameover.png");
        battleship = new ImageIcon("img/battleship.png");
        bomb = new ImageIcon("img/bomb.png");
        mine = new ImageIcon("img/mine.png");
        mineSubmarine = new ImageIcon("img/minesubm.png");
        observeSubmarine = new ImageIcon("img/obsersubm.png");
        torpedoSubmarine = new ImageIcon("img/torpesubm.png");
    }

    /**
     * 测试图片是否读取成功
     */
    public static void main(String[] args) {
        System.out.println(sea.getImageLoadStatus());
        System.out.println(gameOver.getImageLoadStatus());
        System.out.println(battleship.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
        System.out.println(mine.getImageLoadStatus());
        System.out.println(mineSubmarine.getImageLoadStatus());
        System.out.println(observeSubmarine.getImageLoadStatus());
        System.out.println(torpedoSubmarine.getImageLoadStatus());
    }
}
