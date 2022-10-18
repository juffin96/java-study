package cn.tedu;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 陈建飞
 */
public class Yang {
    public static void main(String[] args) {
        JFrame frame = new JFrame("羊了个羊");
        JPanel panel = new JPanel();
        JLabel background = new JLabel(new ImageIcon("images/背景.jpg"));
        background.setSize(480, 800);
        background.setLocation(0, 0);
        panel.setLayout(null);
        panel.add(background);

        //生成牌
        ArrayList<JButton> cards = createCards(6);
        print(cards);


        System.out.println("\n-----------------");
        //洗牌
        Collections.shuffle(cards);
        print(cards);

        //摆牌
        deal(cards, panel, 0, 6, 7, 30, 100);
        deal(cards, panel, 42, 5, 6, 60, 133);
        deal(cards, panel, 72, 5, 7, 30, 166);

        //检查是否在最上层
        checkCards(cards);

        System.out.println("\n-----------------");

        ArrayList<JButton> slot = new ArrayList<>();

        addAction(cards, slot);

        updateFrame(frame, panel);
    }
    public static void updateFrame(JFrame frame, JPanel panel){
        frame.add(panel);
        frame.setSize(485, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /**
     * 定义一个方法，封装牌的创建过程，返回值是创建好的全部牌
     *
     * @return cards 一堆牌，按钮
     */
    public static ArrayList<JButton> createCards(int round) {
        String[] names = {"刷子", "剪刀", "叉子", "奶瓶", "干草", "手套", "树桩", "棉花", "毛线", "水桶", "火", "玉米", "白菜", "草", "萝卜", "铃铛"};
        ArrayList<JButton> cards = new ArrayList<>();
        for (int j = 0; j < round; j++) {
            for (String name : names) {
                String filename = "images/" + name + ".png";
                String filename2 = "images/" + name + "2.png";
                JButton card = new JButton(new ImageIcon(filename));
                card.setDisabledIcon(new ImageIcon(filename2));
                card.setSize(59, 66);
                card.setName(name);
                card.setBorderPainted(false);
                cards.add(card);
            }
        }
        return cards;
    }

    /**
     * 控制台打印全部的牌
     *
     * @param cards 牌的集合
     */
    public static void print(ArrayList<JButton> cards) {
        for (int i = 0; i < cards.size(); i++) {
            JButton card = cards.get(i);
            System.out.print(card.getName() + " ");
            if ((i + 1) % 7 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 摆牌
     *
     * @param cards 牌的集合
     * @param panel 摆放牌的面板
     * @param start 开始，是只从那个cards位置开始摆放
     * @param rows  行数
     * @param cols  列数
     * @param x,y   是第一张牌左上角位置
     */
    public static void deal(ArrayList<JButton> cards, JPanel panel, int start, int rows, int cols, int x, int y) {
        for (int i = 0; i < rows * cols; i++) {
            if (i + start == cards.size()) {
                return;
            }
            int x1 = x + i % cols * 59;
            int y1 = y + i / cols * 66;
            JButton card = cards.get(i + start);
            card.setLocation(x1, y1);
            card.setEnabled(false);
            panel.add(card, 0);
        }
    }

    /**
     * 检查每个牌，是否被压住，压住的牌设置为disable，在上层设置为enable
     *
     * @param cards 检查的牌
     */
    public static void checkCards(ArrayList<JButton> cards) {
        for (int i = 0; i < cards.size(); i++) {
            JButton jb1 = cards.get(i);
            jb1.setEnabled(true);
            int x1 = jb1.getX() - 59;
            int y1 = jb1.getY() - 66;
            int x2 = jb1.getX() + 59;
            int y2 = jb1.getY() + 66;
            for (int j = i + 1; j < cards.size(); j++) {
                JButton jb2 = cards.get(j);
                boolean flag = (x1 < jb2.getX() && jb2.getX() < x2) && (y1 < jb2.getY() && jb2.getY() < y2);
                if (flag) {
                    jb1.setEnabled(false);
                }
            }
        }
    }

    public static void addAction(ArrayList<JButton> cards, ArrayList<JButton> slot) {
        for (int i = 0; i < cards.size(); i++) {
            JButton card = cards.get(i);
            card.addActionListener(e -> {
                JButton selected = (JButton) e.getSource();
                System.out.println(selected.getName() + "被点击。。。");
                if (slot.size() == 7) {
                    JOptionPane.showMessageDialog(selected, "卡槽满了，游戏结束！");
                    return;
                }
                cards.remove(selected);
                ActionListener l = selected.getActionListeners()[0];
                selected.removeActionListener(l);
                selected.setLocation(20 + slot.size() * 63, 642);
                checkCards(cards);
                updateSlot(slot, selected);
            });
        }
    }

    private static void updateSlot(ArrayList<JButton> slot, JButton selected) {
        //1.对槽中牌进行排序
        int found = -1;
        for (int i = 0; i < slot.size(); i++) {
            JButton card = slot.get(i);
            if (card.getName().equals(selected.getName())) {
                slot.add(i, selected);
                found = i;
                break;
            }
        }
        if (found == -1) {
            slot.add(selected);
        }
        //3 消除连续的3张牌
        if (found != -1) {
            //如果 found 不是 -1，也就是中间插入，时候开始消除
            //当前位置开始，到最后至少有3张牌
            if (slot.size() - found >= 3) {
                JButton nextNextCard = slot.get(found + 2);
                if (selected.getName().equals(nextNextCard.getName())) {
                    //Parent 是当前按钮所在的面板
                    JPanel panel = (JPanel) selected.getParent();
                    panel.remove(slot.remove(found));
                    panel.remove(slot.remove(found));
                    panel.remove(slot.remove(found));
                    //重新绘制panel，解决删除的残影
                    panel.repaint();
                }
            }
        }
        //2.根据排序结果，重新设置每个牌的位置
        for (int i = 0; i < slot.size(); i++) {
            JButton card = slot.get(i);
            int x = 25 + 62 * i;
            int y = 642;
            card.setLocation(x, y);
        }
    }
}
