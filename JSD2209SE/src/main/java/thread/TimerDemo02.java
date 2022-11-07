package thread;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerDemo02 {
    public static void main(String[] args) {
        // 创建线程池，做定时器
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 执行输出：A ==> " + new Date());
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 执行输出：B ==> " + new Date());
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 执行输出：C ==> " + new Date());
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
