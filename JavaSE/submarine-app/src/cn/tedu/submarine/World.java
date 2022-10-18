package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
            new MineSubmarine()
    };
    private Mine[] mines = {
            new Mine(200, 300)
    };
    private Bomb[] bombs = {
            new Bomb(300, 400)
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 16, HEIGHT + 39);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }


}
