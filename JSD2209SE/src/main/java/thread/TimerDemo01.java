package thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行A ==> " + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000); // delay指定延时，period指定周期

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行B ==> " + new Date());
            }
        }, 0, 2000);
    }
}
