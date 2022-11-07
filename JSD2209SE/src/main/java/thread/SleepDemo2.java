package thread;

import java.util.Date;

public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " ==> 开始休眠 " + new Date());
                Thread.sleep(500000); // 造成阻塞
            } catch (InterruptedException e) {
                // 中止阻塞时执行
                System.out.println(Thread.currentThread().getName() + " ==> 被打断了 " + new Date());
            }
            System.out.println(Thread.currentThread().getName() + " ==> 醒了 " + new Date());
        });

        Thread huang = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " ==> 执行" + i + " " + new Date());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " ==> 中断堵塞 " + new Date());
            lin.interrupt(); // 中断阻塞的线程
        });

        lin.start();
        huang.start();
    }
}
