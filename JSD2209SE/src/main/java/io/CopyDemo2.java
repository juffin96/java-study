package io;

import java.io.*;

/**
 * 节点流：低级流，真实连接我们的程序与另一端的“管道”，负责实际读写数据的流
 * 处理流：高级流，不能独立存在，必须连接在其他流上
 *
 * 缓冲流：
 * 缓冲内部有一个byte数组，默认长度为8192(8kb)
 * 因此缓冲流最终一定会将读写操作转换为读写来保证读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("kunkun.png");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("kunkun_cp.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int d;
        long start = System.currentTimeMillis();
        while ((d = bis.read()) != -1) {
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时" + (end - start) + "ms");
        bos.close();
        bis.close();
    }
}
