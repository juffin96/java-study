package thread;

public class MyThread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程输出" + i);
        }
    }
}
