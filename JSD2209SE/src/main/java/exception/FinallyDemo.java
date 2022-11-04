package exception;

public class FinallyDemo {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally...");
        }
        System.out.println("结束了...");
    }
}
