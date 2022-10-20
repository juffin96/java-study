package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 图片类
 */
public class Images {
    public static ImageIcon sea;                 //海洋图
    public static ImageIcon gameOver;            //游戏结束图
    public static ImageIcon battleship;          //战舰图
    public static ImageIcon bomb;                //炸弹图
    public static ImageIcon mine;                //水雷图
    public static ImageIcon mineSubmarine;       //水雷潜艇图
    public static ImageIcon observeSubmarine;    //侦察潜艇图
    public static ImageIcon torpedoSubmarine;    //鱼雷潜艇图

    static {
        //初始化静态图片
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
        //getImageLoadStatus()返回值：2=MediaTracker.ABORTED 4=MediaTracker.ERRORED 8=MediaTracker.COMPLETE 1=MediaTracker.LOADING
        //返回值为8则表示读取成功
        System.out.println(sea.getImageLoadStatus());
        System.out.println(gameOver.getImageLoadStatus());
        System.out.println(battleship.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
        System.out.println(mine.getImageLoadStatus());
        System.out.println(observeSubmarine.getImageLoadStatus());
        System.out.println(torpedoSubmarine.getImageLoadStatus());
        System.out.println(mineSubmarine.getImageLoadStatus());
    }
}
