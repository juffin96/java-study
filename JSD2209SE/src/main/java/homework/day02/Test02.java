package homework.day02;

import java.io.*;

/**
 * 改正错误
 * 使用缓冲流来完成文件的复制操作
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("test_cp.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int d;
        if ((d = bis.read()) != -1) {
            bos.write(d);
        }
        System.out.println("复制完毕");
        bos.close();
        bis.close();
    }
}
