package thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        // 获取主线程
        Thread main = Thread.currentThread();
        // 获取线程的名字
        String name = main.getName();
        System.out.println("名字：" + name);
        // 获取唯一标识
        long id = main.getId();
        System.out.println("唯一标识：" + id);
        // 获取线程的优先级，默认值为5，整肃范围：1-10
        int priority = main.getPriority();
        System.out.println("优先级：" + priority);

        // 线程是否活着
        boolean isAlive = main.isAlive();
        System.out.println("是否活着：" + isAlive);
        // 是否为守护线程
        boolean isDaemon = main.isDaemon();
        System.out.println("是否为守护线程：" + isDaemon);
        // 是否被中断
        boolean isInterrupted = main.isInterrupted();
        System.out.println("是否被中断：" + isInterrupted);
    }
}
