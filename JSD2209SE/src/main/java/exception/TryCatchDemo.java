package exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("开始...");
        try {
            System.out.println("运行时...");
            throw new RuntimeException();
        } catch (StringIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("捕获异常...");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束...");
    }
}
