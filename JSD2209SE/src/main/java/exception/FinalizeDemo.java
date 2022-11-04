package exception;

/**
 * finalize是一个方法，定义在Object中，
 * 该方法会被GC调用，当一个对象没有任何引用后就会被GC释放资源，在释放前的最后一个操作就是GC调用其finalize方法
 */
public class FinalizeDemo {
    public static void main(String[] args) {
        System.out.println(test("0") + "," + test(null) + "," + test(""));
    }

    public static int test(String str) {
        try {
            return str.charAt(0) - '0';
        } catch (NullPointerException e) {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
