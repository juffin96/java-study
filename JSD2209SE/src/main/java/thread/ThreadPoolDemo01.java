package thread;

import java.util.concurrent.*;

public class ThreadPoolDemo01 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 6,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Runnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        // 创建临时线程
        pool.execute(target);
        pool.execute(target);
        // 不创建，拒绝策略被触发
//        pool.execute(target);

        // 关闭线程池，开发中一般不会使用
        pool.shutdownNow(); // 立即关闭，即使任务没有完成，会丢失数据
    }
}
