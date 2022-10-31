package io;

import java.io.FileOutputStream;

/**
 * Java IO
 * Input 输入
 * Output 输出
 */
public class FOSDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("./fos.dat");
        for (int i = 0; i < 26; i++) {
            fos.write(97 + i);
        }
        System.out.println("写出完毕！");
        fos.close();
    }
}
