package io;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
        // 创建一个文件字节输入流管道与源文件连通
        InputStream is = new FileInputStream("./demo.txt");

        /*// 读取一个字节返回（每次读取一个）
        int b1 = is.read();
        System.out.println((char) b1);
        int b2 = is.read();
        System.out.println((char) b2);
        int b3 = is.read();
        System.out.println((char) b3);

        // 读取完毕返回-1
        int b4 = is.read();
        System.out.println(b4);*/

        // 使用循环遍历，定义一个变量记录每次读取的字节
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }
        is.close();
    }
}
