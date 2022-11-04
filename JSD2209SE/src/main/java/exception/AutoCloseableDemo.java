package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseableDemo {
    /*
     * 自动关闭特性
     */
    public static void main(String[] args) {
        // 只有继承了AutoCloseable接口的类才能在try里定义并初始化
        try (FileOutputStream fos = new FileOutputStream("fos.dat")) {
            fos.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
