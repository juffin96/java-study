package thread;

public class ThreadDemo02 {
    public static void main(String[] args) {
        Runnable target = new MyThread02();
        Thread t = new Thread(target);
        t.start();

        // 匿名内部类形式
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程输出" + i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程输出" + i);
        }
    }
}
