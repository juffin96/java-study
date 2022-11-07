package thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DeamonThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Running..." + new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 设置守护线程必须在线程启动前
        thread.setDaemon(true);
        thread.start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Running2..." + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
