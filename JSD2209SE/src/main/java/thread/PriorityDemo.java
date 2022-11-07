package thread;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("min");
            }
        });
        Thread norm = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("norm");
            }
        });
        Thread max = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("max");
            }
        });
        min.setPriority(Thread.MIN_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        norm.start();
        max.start();
    }
}
