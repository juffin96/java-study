package cn.tedu.submarine;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

/**
 * 世界窗口类
 */
public class World extends JLabel{
    public static final int HEIGHT = 479;
    public static final int WIDTH = 641;
    private Battleship battleship = new Battleship();
    private SeaObject[] submarines = {
            new ObserveSubmarine(),
            new MineSubmarine(),
            new TorpedoSubmarine()
    };
    private Bomb[] bombs = {
            new Bomb(200, 300)
    };
    private Mine[] mines = {
            new Mine(300, 400)
    };

    @Override
    public void paint(Graphics g){
        Images.sea.paintIcon(null, g, 0, 0);
        battleship.paintImage(g);
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].paintImage(g);
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].paintImage(g);
        }
        for (int i = 0; i < mines.length; i++) {
            mines[i].paintImage(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 6, HEIGHT + 29);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
