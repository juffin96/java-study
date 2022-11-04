package thread;

public class TestDemo {
    public static void main(String[] args) {
        Account account = new Account("ICBC-111", 100000);

        new DrawThread(account, "小明").start();
        new DrawThread(account, "小红").start();
    }
}
