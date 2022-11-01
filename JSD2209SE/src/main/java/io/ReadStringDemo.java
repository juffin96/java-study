package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("./node.txt");
        File file = new File("./node.txt");
        long len = file.length();
        byte[] bytes = new byte[(int) len];
        is.read(bytes);
        String line = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(line);
        is.close();
    }
}
