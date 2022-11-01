package io;

import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        InputStream bis = new BufferedInputStream(new FileInputStream("kunkun.png"));
        OutputStream bos = new BufferedOutputStream(new FileOutputStream("kunkun_cp.png"));
        int len;
        byte[] buffer = new byte[10240];
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
            bos.flush();
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕，用时" + (end - start) + "ms");
        bos.close();
        bis.close();
    }
}
