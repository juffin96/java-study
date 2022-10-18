package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * 游戏窗口
 */
public class World extends JPanel {
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;

    //如下就是窗口中所看到的对象
    private Battleship ship = new Battleship();
    private SeaObject[] submarines = {
            new ObserveSubmarine(),
            new MineSubmarine(),
            new TorpedoSubmarine()
    };
    private Mine[] mines = {
            new Mine(200, 300)
    };
    private Bomb[] bombs = {
            new Bomb(300, 400)
    };

    public void paint(Graphics g){
        //画海洋
        Images.sea.paintIcon(null, g, 0, 0);
        //画战舰
        ship.paintImage(g);
        //遍历潜艇
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].paintImage(g);
        }
        //遍历水雷
        for (int i = 0; i < mines.length; i++) {
            mines[i].paintImage(g);
        }
        //遍历炸弹
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].paintImage(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //会创建上面的所有对象
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 6, HEIGHT + 29);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //会自动调用paint()方法
        frame.setVisible(true);
    }
}
