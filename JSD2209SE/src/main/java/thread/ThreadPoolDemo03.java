package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo03 {
    public static void main(String[] args) {
        // 创建固定线程数据的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        // 已经没有多余的线程了
        pool.execute(new MyRunnable());

        ExecutorService pool1 = Executors.newWorkStealingPool();
    }
}
