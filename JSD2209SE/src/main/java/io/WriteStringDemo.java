package io;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("demo.txt");
        String line = "唱跳rap篮球";
        byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
        os.write(bytes);
        os.close();
    }
}
