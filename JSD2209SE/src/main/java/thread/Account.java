package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String cardId;
    private double money;
    // 同步锁对象
    private final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

//    public void drawMoney(double money) {
//        lock.lock();
//        try {
//            String name = Thread.currentThread().getName();
//            if (this.money >= money) {
//                System.out.println(name + "取钱成功，吐出" + money);
//                this.money -= money;
//                System.out.println(name + "取钱后剩余：" + this.money);
//            } else {
//                System.out.println(name + "来取钱，余额不足！");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }

    public synchronized void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        if (this.money >= money) {
            System.out.println(name + "取钱成功，吐出" + money);
            this.money -= money;
            System.out.println(name + "取钱后剩余：" + this.money);
        } else {
            System.out.println(name + "来取钱，余额不足！");
        }
    }

    /**
     * 获取
     *
     * @return cardId
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 设置
     *
     * @param cardId
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获取
     *
     * @return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * 设置
     *
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{cardId = " + cardId + ", money = " + money + "}";
    }
}
