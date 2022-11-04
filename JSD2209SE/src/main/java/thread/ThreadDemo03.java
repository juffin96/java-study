package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo03 {
    public static void main(String[] args) {
        Callable<String> call = new MyCallable(100);
        FutureTask<String> ft =new FutureTask<>(call);
        Thread t = new Thread(ft);
        t.start();

        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> ft2 = new FutureTask<>(call2);
        Thread t2 = new Thread(ft2);
        t2.start();

        try {
            String s = ft.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s2 = ft2.get();
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
