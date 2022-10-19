package cn.tedu.submarine;

import javax.swing.ImageIcon;

/**
 * 水雷
 */
public class Mine extends SeaObject{

    public Mine(int x, int y) {
        //初始坐标需要根据水雷潜艇的坐标计算，数据不能写死，需传参写活
        super(11, 11, x, y, 2);
    }

    @Override
    public void move(){
        System.out.println("水雷y向上动");
    }

    @Override
    public ImageIcon readImage() {
        return Images.mine;
    }
}
