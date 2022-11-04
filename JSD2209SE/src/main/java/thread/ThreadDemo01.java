package thread;

public class ThreadDemo01 {
    public static void main(String[] args) {
        Thread t = new MyThread01();
        /*
         * 为什么不直接调用run方法，而是调用start方法启动线程？
         * 直接调用run方法会当次普通方法执行，此时相当于单线程执行。
         * 只有调用start方法才是启动一个新的线程执行。
         *
         * 不要把主线程任务放在子线程之前。
         * 这样主线程一直是先跑完的，相当于是一个单线程的效果。
         */
        // 子线程执行
        t.start();

        // 主线程执行
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程执行输出：" + i);
        }
    }
}
