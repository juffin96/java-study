package thread;

/**
 * 取钱的线程类
 */
public class DrawThread extends Thread{
    private Account account;

    public DrawThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.drawMoney(100000);
    }
}
